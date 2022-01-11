package com.example.testproj.controller;

import com.example.testproj.entity.Person;
import com.example.testproj.json.dto.Filter;
import com.example.testproj.json.dto.PersonDto;
import com.example.testproj.service.PersonService;
import liquibase.pro.packaged.F;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/people")
@AllArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<PersonDto>> getAllPeople(
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String birthDate,
            @RequestParam(required = false) String department) {
        Filter filter = new Filter(lastname, birthDate, department);
        return ResponseEntity.ok(service.findByFilter(filter));
    }

    @PostMapping("/new")
    public ResponseEntity<?> createPerson(@RequestBody PersonDto personDto) {
        return ResponseEntity.status(201).body(service.save(personDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Integer id, @RequestBody PersonDto personDto) {
        if (personDto.getId() == null) {
            personDto.setId(id);
        } else if (!Objects.equals(personDto.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }
        return ResponseEntity.status(201).body(service.save(personDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
