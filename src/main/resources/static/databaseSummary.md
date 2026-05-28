# The Ultimate JPA Relationships Guide: Think Database First

## The Big Picture: JPA Relationships are About Foreign Keys

> Before writing a single line of Java code or slapping on Spring/JPA annotations, **always think about the database structure first**.

In a relational database, a relationship between tables is strictly represented by either:

1. **A Foreign Key (FK) column** (in the same table)
2. **A Join Table** (a separate bridge table holding two foreign keys)

---

## Example: Many Addresses Belong to One User

### `users` Table

```text
+----+-------+-------------------+
| id | name  | email             |
+----+-------+-------------------+
```

### `addresses` Table

```text
+----+---------------+---------+
| id | street        | user_id |
+----+---------------+---------+
```

`user_id` is a foreign key pointing to `users.id`.

* **Database Reality:** One `User` row can match many `Address` rows.
* **Java/JPA Representation:** `User` contains a `List<Address>`, and `Address` contains a reference to `User`.

This is a classic **One-to-Many / Many-to-One** bidirectional relationship.

---

# 1. Relationship Vocabulary

## One-to-One (`@OneToOne`)

One row relates to exactly one other row.

### Analogy

```text
User 1 ---- 1 Profile
```

### Common Examples

* `User` ↔ `Profile`
* `Employee` ↔ `EmployeeDetails`
* `Person` ↔ `Passport`

---

## One-to-Many (`@OneToMany`)

One parent record owns multiple child records.

### Analogy

```text
User 1 ---- Many Addresses
```

### Example

One user can save:

* Home address
* Work address
* Shipping address

---

## Many-to-One (`@ManyToOne`)

The exact same relationship as One-to-Many, just viewed from the child’s perspective.

### Analogy

```text
Address Many ---- 1 User
```

### Important Database Fact

> The **Many** side almost always owns the foreign key.

Example:

```text
addresses.user_id
```

Each address row stores exactly one user reference.

---

## Many-to-Many (`@ManyToMany`)

Multiple records on one side relate to multiple records on the other side.

### Analogy

```text
User Many ---- Many Tags
```

A user can have many tags (`Admin`, `VIP`) and a tag can belong to many users.

### Database Structure

Requires a **join table**.

```text
users               user_tags               tags
+----+      +---------+--------+      +----+
| id | <--- | user_id | tag_id | ---> | id |
+----+      +---------+--------+      +----+
```

---

# 2. Owning Side vs. Inverse Side

This is one of the most confusing parts of JPA.

## Definitions

### Owning Side

The entity that controls the database relationship.

Usually:

* Holds the foreign key
* Defines the join table

### Inverse Side

The read-only mirrored side.

Uses:

```java
mappedBy = "fieldName"
```

---

## Ownership Table

| Relationship Type           | Owning Side             | Inverse Side               |
| --------------------------- | ----------------------- | -------------------------- |
| `@ManyToOne` / `@OneToMany` | `@ManyToOne` side       | `@OneToMany(mappedBy=...)` |
| `@OneToOne`                 | Side with `@JoinColumn` | Side with `mappedBy`       |
| `@ManyToMany`               | Side with `@JoinTable`  | Side with `mappedBy`       |

---

## Example: One-to-Many / Many-to-One

```java
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    // Inverse side
    @OneToMany(mappedBy = "user")
    private List<Address> addresses = new ArrayList<>();
}
```

```java
@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;

    // Owning side
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```

---

## Why This Matters

JPA only watches the **owning side** for database updates.

This works:

```java
address.setUser(user);
```

This alone does NOT persist the relationship:

```java
user.getAddresses().add(address);
```

Without updating the owning side, the foreign key is never saved.

---

# 3. Bidirectional vs. Unidirectional

## Unidirectional Relationship

Only one entity knows the relationship exists.

```java
@Entity
public class Address {

    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```

### Result

You can do:

```java
address.getUser();
```

But you cannot do:

```java
user.getAddresses();
```

unless you write a custom query.

---

## Bidirectional Relationship

Both entities reference each other.

---

## Golden Rule

Always synchronize both sides using helper methods.

```java
public void addAddress(Address address) {
    this.addresses.add(address);
    address.setUser(this);
}

public void removeAddress(Address address) {
    this.addresses.remove(address);
    address.setUser(null);
}
```

---

# 4. Database Operations: Normal Records

## Adding a Standalone Record

```java
User user = new User();

user.setName("Ali");
user.setEmail("ali@example.com");

userRepository.save(user);
```

### SQL

```sql
INSERT INTO users (name, email)
VALUES (?, ?);
```

---

## Deleting a Standalone Record

```java
User user = userRepository.findById(1L)
        .orElseThrow();

userRepository.delete(user);
```

### SQL

```sql
DELETE FROM users WHERE id = ?;
```

### Warning

This fails if foreign keys still reference the user.

Example:

```text
addresses.user_id -> users.id
```

---

# 5. Modeling Actions in One-to-Many

## Adding a Related Record

```java
User user = userRepository.findById(userId)
        .orElseThrow();

Address address = new Address();

address.setStreet("Main Street");
address.setCity("Cairo");

user.addAddress(address);

userRepository.save(user);
```

---

## Cascade Persist

```java
@OneToMany(
    mappedBy = "user",
    cascade = CascadeType.PERSIST
)
private List<Address> addresses;
```

Saving the user automatically saves new addresses.

Without cascade:

```java
addressRepository.save(address);
```

must be called manually.

---

## Removing a Related Record

```java
User user = userRepository.findById(userId)
        .orElseThrow();

Address address = user.getAddresses()
        .stream()
        .filter(a -> a.getId().equals(addressId))
        .findFirst()
        .orElseThrow();

user.removeAddress(address);

userRepository.save(user);
```

What happens next depends on `orphanRemoval`.

---

# 6. Understanding `orphanRemoval = true`

An orphan is a child entity disconnected from its parent.

---

## With `orphanRemoval = true`

```java
@OneToMany(
    mappedBy = "user",
    orphanRemoval = true
)
```

This triggers:

```sql
DELETE FROM addresses WHERE id = ?;
```

---

## Without `orphanRemoval`

JPA only nullifies the foreign key:

```sql
UPDATE addresses
SET user_id = NULL
WHERE id = ?;
```

Fails if:

```sql
user_id NOT NULL
```

---

# 7. `orphanRemoval` vs. `CascadeType.REMOVE`

| Feature  | `CascadeType.REMOVE`   | `orphanRemoval = true`       |
| -------- | ---------------------- | ---------------------------- |
| Trigger  | Delete parent          | Remove child from collection |
| Result   | Deletes all children   | Deletes disconnected child   |
| Use Case | Parent-child lifecycle | Collection management        |

---

## Common Combination

```java
@OneToMany(
    mappedBy = "user",
    cascade = CascadeType.ALL,
    orphanRemoval = true
)
```

---

# 8. Cascade Types Cheat Sheet

| Cascade Type | Meaning                       |
| ------------ | ----------------------------- |
| `PERSIST`    | Save children automatically   |
| `MERGE`      | Update children automatically |
| `REMOVE`     | Delete children automatically |
| `REFRESH`    | Reload children               |
| `DETACH`     | Detach children               |
| `ALL`        | Everything above              |

---

## Rule of Thumb

Use cascade only if the child cannot exist without the parent.

### Good Candidates

* `User -> Address`
* `Order -> OrderItem`
* `Invoice -> InvoiceLine`

### Bad Candidates

* `User -> Role`
* `Product -> Category`

Deleting a user should NOT delete the `Admin` role.

---

# 9. Many-to-One Operations

## Add Product to Category

```java
Category cat = categoryRepository.findById(catId)
        .orElseThrow();

Product product = new Product();

product.setName("Mechanical Keyboard");
product.setCategory(cat);

productRepository.save(product);
```

---

## Remove Product from Category

```java
Product product = productRepository.findById(productId)
        .orElseThrow();

product.setCategory(null);

productRepository.save(product);
```

### SQL

```sql
UPDATE products
SET category_id = NULL
WHERE id = ?;
```

---

## Delete Product

```java
productRepository.delete(product);
```

This deletes only the product.

Never cascade REMOVE from child to parent.

---

# 10. Many-to-Many Operations

## Link Existing Records

```java
User user = userRepository.findById(userId)
        .orElseThrow();

Tag tag = tagRepository.findById(tagId)
        .orElseThrow();

user.getTags().add(tag);
tag.getUsers().add(user);

userRepository.save(user);
```

### SQL

```sql
INSERT INTO user_tags (user_id, tag_id)
VALUES (?, ?);
```

---

## Break Relationship

```java
user.getTags().remove(tag);
tag.getUsers().remove(user);

userRepository.save(user);
```

### SQL

```sql
DELETE FROM user_tags
WHERE user_id = ?
AND tag_id = ?;
```

---

## Important Warning

Never use:

```java
CascadeType.REMOVE
```

on `@ManyToMany`.

Deleting one user should NOT delete shared tags.

---

# 11. One-to-One Layouts

## Option A: Foreign Key

```text
profiles
[id | bio | user_id]
```

```java
// User
@OneToOne(
    mappedBy = "user",
    cascade = CascadeType.ALL,
    orphanRemoval = true
)
private Profile profile;
```

```java
// Profile
@OneToOne
@JoinColumn(name = "user_id")
private User user;
```

---

## Option B: Shared Primary Key (`@MapsId`)

```text
profiles
[user_id (PK/FK) | bio]
```

```java
@Entity
public class Profile {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
```

### Benefit

* Saves storage
* Guarantees consistency

---

# 12. Key Conceptual Distinctions

## Add Related Record

Creates a new dependent row.

```java
Address a = new Address();
user.addAddress(a);
```

### SQL

```sql
INSERT INTO addresses ...
```

---

## Add Relationship

Links two existing records.

```java
user.getTags().add(existingTag);
```

### SQL

```sql
INSERT INTO user_tags ...
```

---

## Delete Related Record

```java
user.removeAddress(address);
```

(with `orphanRemoval = true`)

### SQL

```sql
DELETE FROM addresses ...
```

---

## Delete Relationship

```java
user.getTags().remove(tag);
```

### SQL

```sql
DELETE FROM user_tags ...
```

---

# 13. Transactions & Dirty Checking

## Transactional Service Layer

```java
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void addAddress(Long userId, Address address) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        user.addAddress(address);

        // No explicit save() needed
    }
}
```

Hibernate auto-detects changes and flushes them on commit.

---

## Managed vs Detached

### Managed

Inside active transaction.

Changes auto-persist.

### Detached

Outside transaction.

Changes are ignored unless merged/saved.

---

# 14. Lazy vs Eager Loading

| Relationship  | Default | Recommendation   |
| ------------- | ------- | ---------------- |
| `@OneToMany`  | LAZY    | LAZY             |
| `@ManyToMany` | LAZY    | LAZY             |
| `@ManyToOne`  | EAGER   | Override to LAZY |
| `@OneToOne`   | EAGER   | Override to LAZY |

---

# 15. Common Mistakes

## Mistake 1: Updating Only Inverse Side

Bad:

```java
user.getAddresses().add(address);
```

Fix:

```java
address.setUser(user);
```

---

## Mistake 2: Cascade REMOVE on Many-to-Many

Can accidentally delete shared data.

---

## Mistake 3: Missing `@Transactional`

Leads to:

```text
LazyInitializationException
```

---

## Mistake 4: Recursive `toString()` Loops

Fix with:

```java
@ToString.Exclude
@ManyToOne
private User user;
```

---

# 16. Master Blueprint

## Parent Entity

```java
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private List<Address> addresses = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_tags",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setUser(this);
    }
}
```

---

## Child Entity

```java
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
```

---

# Final Strategy Table

| Use Case                     | Main Annotation | Cascade Strategy                       |
| ---------------------------- | --------------- | -------------------------------------- |
| Parent owns child completely | `@OneToMany`    | `CascadeType.ALL + orphanRemoval=true` |
| Lookup/reference data        | `@ManyToOne`    | No REMOVE cascade                      |
| Shared associations          | `@ManyToMany`   | No REMOVE cascade                      |

```
```
