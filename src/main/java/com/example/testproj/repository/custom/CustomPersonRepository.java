package com.example.testproj.repository.custom;

import com.example.testproj.entity.Person;
import com.example.testproj.json.dto.Filter;

import java.util.List;

public interface CustomPersonRepository {
    List<Person> findByFilter(Filter filter);
}
