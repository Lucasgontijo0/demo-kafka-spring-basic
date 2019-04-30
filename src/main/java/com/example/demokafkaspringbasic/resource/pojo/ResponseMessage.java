package com.example.demokafkaspringbasic.resource.pojo;

import java.util.UUID;

public class ResponseMessage {

    private UUID id;
    private String message;

    public ResponseMessage(UUID id) {
        this.id = id;
        this.message = "Message received, you can find result with this id.";
    }

    public String getMessage() {
        return message;
    }

    public UUID getId() {
        return id;
    }

}
