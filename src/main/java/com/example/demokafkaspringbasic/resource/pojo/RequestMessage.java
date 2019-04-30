package com.example.demokafkaspringbasic.resource.pojo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

public class RequestMessage implements Serializable {

    private UUID id;

    @NotNull
    private String message;

    public RequestMessage() {
    }

    public RequestMessage(UUID id, @NotNull String message) {
        this.id = id;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
