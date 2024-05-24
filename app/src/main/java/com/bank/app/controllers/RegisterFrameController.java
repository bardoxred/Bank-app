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

        User user = new User();
        user.setHashedEmail(hashedEmail);
        user.setHashedPassword(hashedPassword);

        UserData userData = new UserData();

        userData.setFirstName(firstName);
        userData.setSecondName(secondName);
        userData.setLastName(lastName);
        userData.setBirth(birthDate);
        userData.setPhoneNumber(phoneNumber);
        userData.setUser(user);

        registerFormService.registerUser(user, userData);
       }

}
