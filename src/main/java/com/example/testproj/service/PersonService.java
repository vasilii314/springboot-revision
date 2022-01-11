package com.example.testproj.service;

import com.example.testproj.entity.Department;
import com.example.testproj.entity.Person;
import com.example.testproj.json.dto.Filter;
import com.example.testproj.json.dto.PersonDto;

import java.util.List;
import java.util.Map;

public interface PersonService {

    List<PersonDto> findAll();

    PersonDto getById(Integer id);

    List<PersonDto> findByFilter(Filter filter);

    Map<String, Integer> save(PersonDto personDto);

    void deleteById(Integer id);
}
