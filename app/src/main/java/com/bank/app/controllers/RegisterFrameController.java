package com.bank.app.controllers;


import com.bank.app.models.User;
import com.bank.app.models.UserData;
import com.bank.app.services.RegisterFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class RegisterFrameController {

    @Autowired
    private RegisterFormService registerFormService;


    public String getErrorMessage() {
        return registerFormService.getPasswordMessage();
    }

    public boolean registerUser(String firstName, String secondName, String lastName, Date birthDate, String phoneNumber, String email, String password, String confirmPassword) {
        return registerFormService.registerUser(firstName, secondName, lastName, birthDate, phoneNumber, email, password, confirmPassword);
    }
}
