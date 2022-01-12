package com.example.testproj.service.impl;

import com.example.testproj.entity.NewPerson;
import com.example.testproj.entity.Person;
import com.example.testproj.json.dto.Filter;
import com.example.testproj.json.dto.PersonDto;
import com.example.testproj.json.mapper.PersonMapper;
import com.example.testproj.kafka.msg.NewPersonMsg;
import com.example.testproj.repository.PersonRepository;
import com.example.testproj.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    private final PersonMapper mapper;

    private final KafkaTemplate<String, Object> template;

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
        Person person = repository.save(mapper.toPerson(personDto));
        res.put("id", person.getPersonId());
        template.send("new-people", new NewPerson(
                person.getPersonId(),
                person.getLastname(),
                person.getFirstname(),
                person.getMiddleName(),
                person.getBirthDate(),
                Date.valueOf(LocalDate.now()),
                Time.valueOf(LocalTime.now())
        )).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message");
                ex.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("Message sent {}", result.getProducerRecord());
            }
        });
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
