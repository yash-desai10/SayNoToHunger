package com.example.SayNoToHunger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.example.SayNoToHunger")
@EnableJpaRepositories(basePackages="com.example.SayNoToHunger.repo")
public class SayNoToHungerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SayNoToHungerServerApplication.class, args);
	}

}
