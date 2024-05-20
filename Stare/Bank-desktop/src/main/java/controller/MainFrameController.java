package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import service.MainFrameService;

@Controller
@RequiredArgsConstructor
public class MainFrameController {

    private final MainFrameService mainFrameService;

    public void login(String email, String password) {
        mainFrameService.saveUser(email, password);
    }
}