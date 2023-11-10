package com.progresssoft.warehouse.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		scanBasePackages={
			"com.progresssoft.warehouse.dto", 
			"com.progresssoft.warehouse.bll", 
			"com.progresssoft.warehouse.repository"})
@EnableJpaRepositories("com.progresssoft.warehouse.repository")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
