package com.example.helloworld.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException1 extends RuntimeException {
    private String message;

    public ResourceNotFoundException1() {
        super();
    }

    public ResourceNotFoundException1(String message) {
        super(message);
        this.message = message;
    }
}
