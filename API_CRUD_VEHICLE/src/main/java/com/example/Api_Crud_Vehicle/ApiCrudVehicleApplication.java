package com.example.Api_Crud_Vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.Api_Crud_Vehicle.repositories")
public class ApiCrudVehicleApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiCrudVehicleApplication.class, args);
	}

}
