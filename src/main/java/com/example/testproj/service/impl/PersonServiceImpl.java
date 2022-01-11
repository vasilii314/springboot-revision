package com.example.testproj.service.impl;

import com.example.testproj.json.dto.Filter;
import com.example.testproj.json.dto.PersonDto;
import com.example.testproj.json.mapper.PersonMapper;
import com.example.testproj.repository.PersonRepository;
import com.example.testproj.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    private final PersonMapper mapper;

    @Override
    public List<PersonDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toPersonDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto getById(Integer id) {
        return mapper.toPersonDto(repository.getById(id));
    }

    @Override
    public Map<String, Integer> save(PersonDto personDto) {
        Map<String, Integer> res = new HashMap<>();
        res.put("id", repository.save(mapper.toPerson(personDto)).getPersonId());
        return res;
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<PersonDto> findByFilter(Filter filter) {
        return repository
                .findByFilter(filter)
                .stream()
                .map(mapper::toPersonDto)
                .collect(Collectors.toList());
    }
}
