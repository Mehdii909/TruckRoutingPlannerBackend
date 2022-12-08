package com.example.app.service.impliments;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.app.enums.ERole;
import com.example.app.payload.LoginRequest;
import com.example.app.payload.LoginResponse;
import com.example.app.payload.RegisterRequest;
import com.example.app.persistance.dao.UserRepository;
import com.example.app.persistance.entities.User;
import com.example.app.security.JwtTokenProvider;
import com.example.app.service.interfaces.IAuth;
import com.example.app.utils.exceptions.MyInternalServerErrorException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuth {

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);

        return new LoginResponse(token);
    }

    @Override
    public void register(RegisterRequest request) {
        try {
            User user = new User(request.getUsername(), request.getEmail(), passwordEncoder.encode(request.getPassword()),
                    ERole.ROLE_CHAUFFEUR);
            userRepository.save(user);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }

    }
}
