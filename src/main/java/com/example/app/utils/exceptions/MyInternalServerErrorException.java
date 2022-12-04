package com.example.app.utils.exceptions;

import org.springframework.http.HttpStatus;

public class MyInternalServerErrorException extends RuntimeException {

    private static final long serialVersionUID = 1318882938077890962L;

    public MyInternalServerErrorException(String message) {
        super(message);
    }

    public MyInternalServerErrorException() {
        super("An unexpected error occurred");
    }

    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
