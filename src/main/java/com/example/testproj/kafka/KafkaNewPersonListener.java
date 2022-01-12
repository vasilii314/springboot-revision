package com.example.testproj.kafka;

import com.example.testproj.entity.NewPerson;
import com.example.testproj.service.NewPersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class KafkaNewPersonListener {

    private NewPersonService service;

    @KafkaListener(topics = "new-people", clientIdPrefix = "json", containerFactory = "kafkaListenerContainerFactory")
    public void listenAsObject(ConsumerRecord<String, NewPerson> cr,
                               @Payload NewPerson payload) {
        log.info("New person message payload {}",  payload);
        log.info("NewPerson saved {}", service.save(payload));
    }
}
