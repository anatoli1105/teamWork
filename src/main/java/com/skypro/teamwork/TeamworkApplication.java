package com.skypro.teamwork;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition

public class TeamworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamworkApplication.class, args);
	}

}
