package com.project.javafundamentals;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Users", version = "1.0", description = "API for user management"))
public class JavaFundamentalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaFundamentalsApplication.class, args);
	}

}
