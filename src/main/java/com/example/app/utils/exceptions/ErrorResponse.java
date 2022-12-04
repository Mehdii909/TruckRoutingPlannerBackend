package com.example.app.utils.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@NoArgsConstructor
public class ErrorResponse {


    int status;


    String error;

    String time = new Date().toString();


    public ErrorResponse(String error, HttpStatus status) {
        this.error = error;
        this.status = status.value();
    }
}
