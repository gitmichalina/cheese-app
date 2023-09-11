package com.example.cheeseapp.cheese;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CheeseRepository extends JpaRepository<Cheese, Long> {

}
