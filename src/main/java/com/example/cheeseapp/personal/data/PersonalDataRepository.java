package com.example.cheeseapp.personal.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonalDataRepository extends JpaRepository<PersonalData, UUID> {
}
