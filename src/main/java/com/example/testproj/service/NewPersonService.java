package com.example.testproj.service;

import com.example.testproj.entity.NewPerson;
import com.example.testproj.json.dto.DepartmentDto;

import java.util.List;
import java.util.Map;

public interface NewPersonService {
    List<NewPerson> findAll();

    NewPerson getById(Integer id);

    NewPerson save(NewPerson newPerson);

    void deleteById(Integer id);
}
