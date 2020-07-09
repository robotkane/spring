package com.example.helloworld.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse1 {
    private String message;
    private String errorTypeName;

    public ErrorResponse1(Exception e) {
        this(e.getClass().getName(), e.getMessage());
    }

    public ErrorResponse1(String errorTypeName, String message) {
        this.errorTypeName = errorTypeName;
        this.message = message;
    }
}
