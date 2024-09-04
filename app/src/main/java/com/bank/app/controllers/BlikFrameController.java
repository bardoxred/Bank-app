package com.bank.app.controllers;

import com.bank.app.services.BlikFrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BlikFrameController {

    @Autowired
    private BlikFrameService blikFrameService;

}
