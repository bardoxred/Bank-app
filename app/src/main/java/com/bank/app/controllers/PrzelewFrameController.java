package com.bank.app.controllers;

import com.bank.app.services.PrzelewFrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PrzelewFrameController {

    @Autowired
    private PrzelewFrameService przelewFrameService;

}
