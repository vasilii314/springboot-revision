package com.example.testproj.repository;

import com.example.testproj.entity.Person;
import com.example.testproj.repository.custom.CustomPersonRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>, CustomPersonRepository {
}
