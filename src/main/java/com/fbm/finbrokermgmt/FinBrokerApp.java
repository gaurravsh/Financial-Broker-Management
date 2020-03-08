package com.fbm.finbrokermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FinBrokerApp {
	public static void main(String[] args) {
		SpringApplication.run(FinBrokerApp.class, args);
	}
}
