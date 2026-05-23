# Spring Framework (:)) Quick Reference Guide

A structured cheat sheet of Spring Boot + Java annotations grouped by category for quick revision.

---

## 1. Stereotype Annotations (Spring Beans)
These annotations define Spring-managed components (beans).

| Annotation | Layer | Purpose | Example |
|---|---|---|---|
| `@Component` | Generic | Base stereotype for any Spring bean | `HelperService` |
| `@Service` | Business | Business logic layer | `UserService` |
| `@Repository` | Data | Database access layer + exception translation | `UserRepository` |
| `@Controller` | Web | Handles HTTP requests (MVC controllers) | `HomeController` |

---

## 2. Configuration & Bean Management
Used for manually defining and controlling beans.

| Annotation | Purpose |
|---|---|
| `@Configuration` | Marks a class as a configuration source |
| `@Bean` | Defines a Spring-managed bean manually |
| `@Primary` | Sets default bean when multiple exist |
| `@Scope` | Defines bean lifecycle (singleton, prototype, etc.) |
| `@Lazy` | Delays bean creation until first use |

---

## 3. Dependency Injection (DI)
Controls how Spring injects dependencies into objects.

| Annotation | Purpose | Usage |
|---|---|---|
| `@Autowired` | Inject dependency automatically | Prefer constructor injection |
| `@Qualifier` | Select specific bean implementation | When multiple beans exist |
| `@Value` | Inject external config values | From `application.yaml` or env vars |

---

## 4. Bean Lifecycle Annotations
Used to run logic during bean creation and destruction.

| Annotation | Purpose |
|---|---|
| `@PostConstruct` | Runs after dependency injection is complete |
| `@PreDestroy` | Runs before bean is removed from container |

---

## 5. Web / MVC Annotations
Used for handling HTTP requests and routing.

| Annotation | Purpose | Example |
|---|---|---|
| `@Controller` | MVC controller (returns views) | `HomeController` |
| `@RequestMapping` | Maps URL to method | `"/home"` |
| `@GetMapping` | Handles GET requests | `@GetMapping("/users")` |
| `@PostMapping` | Handles POST requests | `@PostMapping("/users")` |
| `@RequestParam` | Reads query parameters | `?id=1` |
| `@PathVariable` | Reads URL path variables | `/users/{id}` |

---

## 6. Spring Boot Core
Core application bootstrapping.

| Annotation | Purpose |
|---|---|
| `@SpringBootApplication` | Combines configuration + auto-configuration + component scan |

---

## 7. JPA / Database Annotations
Used for ORM mapping between Java and database.

| Annotation | Applied On | Purpose |
|---|---|---|
| `@Entity` | Class | Marks a database table |
| `@Table` | Class | Custom table name |
| `@Id` | Field | Primary key |
| `@GeneratedValue` | Field | Auto-generates ID |
| `@Column` | Field | Column mapping + constraints |

---

## 8. Lombok Annotations
Used to reduce boilerplate code.

| Annotation | Purpose | Generates |
|---|---|---|
| `@Getter` | Generates getters | `getX()` |
| `@Setter` | Generates setters | `setX()` |
| `@NoArgsConstructor` | Empty constructor | `User()` |
| `@AllArgsConstructor` | Full constructor | `User(id, name, ...)` |
| `@Builder` | Builder pattern | Fluent object creation |

---

## 9. Java Built-in Annotations
Standard Java annotations.

| Annotation | Purpose |
|---|---|
| `@Override` | Indicates method override from parent class/interface |

---

## 10. Bean Scopes (Lifecycle Control)

| Scope | Description | Use Case |
|---|---|---|
| `singleton` | One instance per Spring container (default) | Services, repositories |
| `prototype` | New instance every time requested | Stateful objects |
| `request` | One instance per HTTP request | Web request data |
| `session` | One instance per user session | Login/cart data |
| `application` | One per web application | Global shared data |

---

## Quick Best Practices

- Prefer **constructor injection** over field injection
- Use `@Primary` for default implementation
- Use `@Qualifier` for explicit selection
- Keep services stateless → use `singleton`
- Use `prototype` only when necessary
- Always define `@Id` in JPA entities
- Use Lombok to reduce boilerplate but understand generated code
- Keep controllers thin, services contain business logic