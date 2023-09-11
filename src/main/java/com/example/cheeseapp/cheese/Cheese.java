package com.example.cheeseapp.cheese;


import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="cheese")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cheese {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String summary;
    private String description;
    private String region;
    private String aroma;
    private String flavour;
    private Milk milk;
    private Colour colour;
    private CountryOfOrigin country;
    private Family family;
    private Rind rind;
    private Texture texture;
    private Type type;

    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "modified_at")
    private String modifiedAt;

}
