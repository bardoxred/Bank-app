package com.bank.app.services;

import com.bank.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginFrameService {

    @Autowired
    private final UserRepository userRepository;

    public LoginFrameService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}