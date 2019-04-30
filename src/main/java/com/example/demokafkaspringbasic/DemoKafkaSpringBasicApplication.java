package com.example.demokafkaspringbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class DemoKafkaSpringBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoKafkaSpringBasicApplication.class, args);
    }

}
