package com.example.testproj.repository;

import com.example.testproj.entity.NewPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewPersonRepository extends JpaRepository<NewPerson, Integer> {
}
