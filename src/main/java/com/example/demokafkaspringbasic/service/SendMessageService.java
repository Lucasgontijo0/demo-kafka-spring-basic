package com.example.demokafkaspringbasic.service;

import com.example.demokafkaspringbasic.resource.pojo.RequestMessage;
import com.example.demokafkaspringbasic.resource.pojo.ResponseMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class SendMessageService {

    private static final String FIRST_TOPIC = "firsttopic";

    private final KafkaTemplate<String, RequestMessage> kafkaTemplate;

    public SendMessageService(KafkaTemplate<String, RequestMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public ResponseMessage sendMessage(RequestMessage message) {

        ListenableFuture<SendResult<String, RequestMessage>> future = kafkaTemplate.send(FIRST_TOPIC, message);

        future.addCallback(
                result -> {
                    System.out.println("Sent message: [" + result.getRecordMetadata().offset() + "]");
                },
                ex -> System.out.println("Unable to send message: [" + message + "due to: " + ex.getMessage())
        );

        return new ResponseMessage(message.getId());
    }
}
