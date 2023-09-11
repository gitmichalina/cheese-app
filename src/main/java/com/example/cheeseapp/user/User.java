package com.example.cheeseapp.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "first_name",
            nullable = false)
    private String firstName;

    @Column(name = "last_name",
            nullable = false)
    private String lastName;

    @Column(name = "username",
            nullable = false)
    private String username;

    @Column(name = "email",
            nullable = false,
            unique = true)
    private String email;

    @Column(name = "location",
            nullable = false)
    private String location;

    @Column(name = "profile_image_id",
            nullable = false)
    private String profileImageId;

    @Column(name = "description",
            nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender",
            nullable = false)
    private UserGender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "type",
            nullable = false)
    private UserType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",
            nullable = false)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",
            nullable = false)
    private UserRole role;

    @Column(name = "created_at",
            nullable = false,
            updatable = false
    )
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "modified_at",
            nullable = false)
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public User(String firstName, String lastName, String username, String email, String location, String profileImageId, String description, UserGender gender, UserType type, UserStatus status, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.location = location;
        this.profileImageId = profileImageId;
        this.description = description;
        this.gender = gender;
        this.type = type;
        this.status = status;
        this.role = role;
    }
}
