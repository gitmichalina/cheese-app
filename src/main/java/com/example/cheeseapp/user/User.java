package com.example.cheeseapp.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // id zostanie stworzone przez nas.
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String username;
    private String email;
    private String location;

    @Column(name = "profile_image_id")
    private String profileImageId;
    private String description;
    private String gender;
    private String type;
    private String status;
    private String role;

    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "modified_at")
    private String modifiedAt;

}
