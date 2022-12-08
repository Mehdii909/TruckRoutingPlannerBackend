package com.example.app.service.interfaces;

import com.example.app.payload.LoginRequest;
import com.example.app.payload.LoginResponse;
import com.example.app.payload.RegisterRequest;

public interface IAuth {

    LoginResponse login(LoginRequest loginRequest);

    void register(RegisterRequest registerRequest);
}
