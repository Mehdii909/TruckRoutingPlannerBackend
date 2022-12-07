package com.example.app.service.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

public interface ICustomUserDetailsService {


    UserDetails loadUserById(Long id);

}