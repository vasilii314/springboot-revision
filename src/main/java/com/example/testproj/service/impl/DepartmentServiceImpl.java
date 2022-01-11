package com.example.testproj.service.impl;

import com.example.testproj.entity.Department;
import com.example.testproj.json.dto.DepartmentDto;
import com.example.testproj.json.mapper.DepartmentMapper;
import com.example.testproj.repository.DepartmentRepository;
import com.example.testproj.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    private final DepartmentMapper mapper;

    @Override
    public List<DepartmentDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toDepartmentDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getById(Integer id) {
        return mapper.toDepartmentDto(repository.getById(id));
    }

    @Override
    public Map<String, Integer> save(DepartmentDto departmentDto) {
        Map<String, Integer> res = new HashMap<>();
        res.put("id", repository.save(mapper.toDepartment(departmentDto)).getDepartmentId());
        return res;
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
