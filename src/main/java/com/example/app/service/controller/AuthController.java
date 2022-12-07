package com.example.app.service.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.payload.LoginRequest;
import com.example.app.payload.LoginResponse;
import com.example.app.payload.RegisterRequest;
import com.example.app.service.impliments.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse result = authService.login(loginRequest);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody RegisterRequest registerRequest) {

        authService.register(registerRequest);

    }
}
