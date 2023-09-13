package com.example.cheeseapp.cheese;


import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="cheese")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cheese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
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
    private String alternativeSpellings;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "modified_by")
    private String modifiedBy;

}
