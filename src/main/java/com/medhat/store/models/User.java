package com.medhat.store.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// If you read this comment then .. you are awesome <3 and you deserve a cookie :D
@Setter
@Getter
@Entity
@AllArgsConstructor // to make a constructor that sets
@NoArgsConstructor //to make an empty constructor
@Builder // adding builder methods that looks just like  a stream and ends with .build()
@Table(name = "users")
@ToString // if i keep to put ToString annotation, it will print all the fields of the class so i have to exclude some
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //because id is auto incremented
    private Long id;

    @Column(nullable = false , name = "name") //mapping name and additional characteristics
    private String name;

    @Column(nullable = false , name = "password")
    private String password;

    @Column(nullable = false , unique = true , name = "email")
    private String email;


    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @Builder.Default
    private Set<Product> wishlist = new HashSet<>();


    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST , CascadeType.REMOVE} , orphanRemoval = true)
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Profile profile;

    @ManyToMany
    @JoinTable(
            name = "user_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Builder.Default
    @ToString.Exclude
    private Set<Tag> tags = new HashSet<>();

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }

    public void removeAllAddresses() {
        addresses.forEach(address -> address.setUser(null));
        addresses.clear();
    }

    public void addTag(String tagName) {
        var tag = new Tag(tagName);
        tags.add(tag);
        tag.getUsers().add(this);
    }
    public void removeTag(String tagName) {
        var tag = tags.stream().filter(t -> t.getName().equals(tagName)).findFirst().orElse(null);
        if (tag != null) {
            tags.remove(tag);
            tag.getUsers().remove(this);
        }
    }
}
