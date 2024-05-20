package com.bank.app;

import com.bank.app.controllers.MainFrameController;
import com.bank.app.forms.MainFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.bank.app")
public class AppApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AppApplication.class).headless(false).run(args);
	}
	@Bean
	public MainFrame mainFrame(MainFrameController mainFrameController) {
		return new MainFrame(mainFrameController);
	}
}
