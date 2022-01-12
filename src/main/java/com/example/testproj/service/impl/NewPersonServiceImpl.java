package com.example.testproj.service.impl;

import com.example.testproj.entity.NewPerson;
import com.example.testproj.repository.NewPersonRepository;
import com.example.testproj.service.NewPersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class NewPersonServiceImpl implements NewPersonService {

    private final NewPersonRepository repository;

    @Override
    public List<NewPerson> findAll() {
        return repository.findAll();
    }

    @Override
    public NewPerson getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public NewPerson save(NewPerson newPerson) {
        return repository.save(newPerson);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
