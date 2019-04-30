package com.example.demokafkaspringbasic.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfiguration {

    @Value("${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configurations = new HashMap<>();
        configurations.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configurations);
    }

    @Bean
    public NewTopic firstTopic() {
        String PARTITION_NAME = "firsttopic";
        int NUMBER_OF_PARTITIONS = 1;
        short REPLICATION_FACTOR = 1;
        return new NewTopic(PARTITION_NAME, NUMBER_OF_PARTITIONS, REPLICATION_FACTOR);
    }

    @Bean
    public NewTopic secondTopic() {
        String PARTITION_NAME = "secondtopic";
        int NUMBER_OF_PARTITIONS = 1;
        short REPLICATION_FACTOR = 1;
        return new NewTopic(PARTITION_NAME, NUMBER_OF_PARTITIONS, REPLICATION_FACTOR);
    }

}
