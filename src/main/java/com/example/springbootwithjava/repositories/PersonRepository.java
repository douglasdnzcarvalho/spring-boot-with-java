package com.example.springbootwithjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootwithjava.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
