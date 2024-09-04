package com.bank.app.controllers;

import com.bank.app.services.PrzelewBlikFrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PrzelewBlikFrameController {

    @Autowired
    private PrzelewBlikFrameService przelewBlikFrameService;

}
