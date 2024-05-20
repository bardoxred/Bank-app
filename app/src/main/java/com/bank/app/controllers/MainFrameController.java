package com.bank.app.controllers;

import com.bank.app.services.MainFrameService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class MainFrameController {

    @Autowired
    private MainFrameService mainFrameService;

    public void login(String email, String password) {
        mainFrameService.saveUser(email, password);
    }
}