package com.bank.app;

import com.bank.app.forms.MainFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.bank.app")
public class AppApplication {

	public static void main(String[] args) {
		var ctx = new SpringApplicationBuilder(AppApplication.class).headless(false).run(args);
		ctx.getBean(MainFrame.class);
	}

}
