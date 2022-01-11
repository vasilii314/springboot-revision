package com.example.testproj.service;

import com.example.testproj.entity.Department;
import com.example.testproj.json.dto.DepartmentDto;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<DepartmentDto> findAll();

    DepartmentDto getById(Integer id);

    Map<String, Integer> save(DepartmentDto departmentDto);

    void deleteById(Integer id);
}
