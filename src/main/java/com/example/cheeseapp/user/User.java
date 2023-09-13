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

    @Column(name = "username",
            nullable = false,
            unique = true)
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

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type",
            nullable = false)
    private UserType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",
            nullable = false)
    private UserStatus status;

    @Column(name = "created_at",
            nullable = false,
            updatable = false
    )
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "modified_at",
            nullable = false)
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public User(String username, String email, String location, String profileImageId, String description, UserType type, UserStatus status) {
        this.username = username;
        this.email = email;
        this.location = location;
        this.profileImageId = profileImageId;
        this.description = description;
        this.type = type;
        this.status = status;
    }
}
