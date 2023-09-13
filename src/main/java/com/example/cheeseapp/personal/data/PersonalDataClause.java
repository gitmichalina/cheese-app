package com.example.cheeseapp.personal.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "personal_data_clause")
public class PersonalDataClause {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "personal_data_id")
    private PersonalData personalData;

    @Column(name = "clause_id")
    private UUID clauseId;

    private Boolean accepted;

}
