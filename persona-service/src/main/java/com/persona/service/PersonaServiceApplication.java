package com.persona.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PersonaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonaServiceApplication.class, args);
	}

}
