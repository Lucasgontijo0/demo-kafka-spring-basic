package com.example.demokafkaspringbasic.resource;

import com.example.demokafkaspringbasic.resource.pojo.RequestMessage;
import com.example.demokafkaspringbasic.resource.pojo.ResponseMessage;
import com.example.demokafkaspringbasic.service.SendMessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/messages")
public class MessageResource {

    private final SendMessageService sendMessageService;

    public MessageResource(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @PostMapping
    public ResponseMessage sendMessage(@RequestBody @Valid RequestMessage message) {
        message.setId(UUID.randomUUID());
        return this.sendMessageService.sendMessage(message);
    }
}
