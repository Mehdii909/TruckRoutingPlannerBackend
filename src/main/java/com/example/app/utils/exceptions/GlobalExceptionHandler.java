package com.example.app.utils.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MyNotFoundException.class)
    public ResponseEntity<ErrorResponse> generateNotFoundException(MyNotFoundException ex) {
        log.error("ERROR " + ex.getMessage());
        ErrorResponse response = new ErrorResponse(ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(response, ex.getStatus());
    }

    @ExceptionHandler(MyInternalServerErrorException.class)
    public ResponseEntity<ErrorResponse> generateNotFoundException(MyInternalServerErrorException ex) {
        log.error("ERROR " + ex.getMessage());
        ErrorResponse response = new ErrorResponse(ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(response, ex.getStatus());
    }

}
