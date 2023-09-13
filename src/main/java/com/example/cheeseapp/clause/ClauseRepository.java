package com.example.cheeseapp.clause;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClauseRepository extends JpaRepository<Clause, UUID> {
}
