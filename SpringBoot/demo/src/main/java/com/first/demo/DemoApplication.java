package com.first.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.first.demo.domain.User;
import com.first.demo.service.userService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(DemoApplication.class, args);

		userService userService = context.getBean(userService.class);
		System.out.println(userService.tellAStory());
	}

}
