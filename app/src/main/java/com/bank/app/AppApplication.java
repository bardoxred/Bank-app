package com.bank.app;

import com.bank.app.controllers.LoginFrameController;
import com.bank.app.controllers.RegisterFrameController;
import com.bank.app.forms.LoginFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.bank.app")
public class AppApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AppApplication.class).headless(false).run(args);
		System.out.println("blabla");
	}
	@Bean
	public LoginFrame mainFrame(LoginFrameController loginFrameController, RegisterFrameController registerFrameController) {
		return new LoginFrame(loginFrameController, registerFrameController);
	}

}
