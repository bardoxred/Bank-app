package com.bank.app.controllers;

import com.bank.app.services.HistoriaFrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HistoriaFrameController {

    @Autowired
    private HistoriaFrameService historiaFrameService;

}
