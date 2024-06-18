package com.bank.app.controllers;

import com.bank.app.forms.LoginFrame;
import com.bank.app.services.LoginFrameService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class LoginFrameController {

    @Autowired
    private LoginFrameService loginFrameService;

    public boolean login(String email, String password) {
        return loginFrameService.isAutorized(email, password);
    }
}