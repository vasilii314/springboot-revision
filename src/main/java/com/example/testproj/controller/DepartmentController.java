package com.example.testproj.controller;

import com.example.testproj.json.dto.DepartmentDto;
import com.example.testproj.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/new")
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.status(201).body(service.save(departmentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto) {
        if (departmentDto.getId() == null) {
            departmentDto.setId(id);
        } else if (!Objects.equals(departmentDto.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }
        return ResponseEntity.status(201).body(service.save(departmentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}
