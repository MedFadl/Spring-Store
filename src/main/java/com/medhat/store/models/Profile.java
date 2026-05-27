package com.medhat.store.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "profiles")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "loyalty_points")
    private Integer loyaltyPoints;




    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    @MapsId //pk and fk at the same time
    @ToString.Exclude
    private User user;
}