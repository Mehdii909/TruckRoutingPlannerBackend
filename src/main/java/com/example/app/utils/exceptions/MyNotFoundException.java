package com.example.app.utils.exceptions;

import org.springframework.http.HttpStatus;

public class MyNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7372335587262907273L;

    public MyNotFoundException(String message) {
        super(message);
    }

    public MyNotFoundException() {
        super("Resource not found");
    }

    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}

