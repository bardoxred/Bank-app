package com.bank.app.controllers;


import com.bank.app.services.RegisterFrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class RegisterFrameController {

    @Autowired
    private RegisterFrameService registerFrameService;


    public String getErrorMessage() {
        return registerFrameService.getPasswordMessage();
    }

    public boolean registerUser(String firstName, String secondName, String lastName, Date birthDate, String phoneNumber, String email, String password, String confirmPassword) {
        return registerFrameService.registerUser(firstName, secondName, lastName, birthDate, phoneNumber, email, password, confirmPassword);
    }
}
