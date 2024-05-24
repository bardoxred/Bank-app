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


    public void registerUser(String firstName, String secondName, String lastName,
                             Date birthDate, String phoneNumber, String emailAdress,
                             String password) {
        String hashedEmail = registerFormService.hashEmail(emailAdress);
        String hashedPassword = registerFormService.hashPassword(password);

        User user = new User(hashedEmail, hashedPassword);
        UserData userData = new UserData(firstName, secondName, lastName, birthDate, phoneNumber, user);

        registerFormService.registerUser(user, userData);
       }

}
