package com.medhat.store.models;
import jakarta.persistence.*;
import lombok.*;

// If you read this comment then .. you are awesome <3 and you deserve a cookie :D
@Setter
@Getter
@Entity
@AllArgsConstructor // to make a constructor that sets
@NoArgsConstructor //to make an empty constructor
@Builder // adding builder methods that looks just like  a stream and ends with .build()
@Table(name = "users")
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

}
