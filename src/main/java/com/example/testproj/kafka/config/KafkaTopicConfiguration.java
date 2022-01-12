package com.example.testproj.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic newPeopleTopic() {
        return new NewTopic("new-people", 3, (short) 1);
    }
}
