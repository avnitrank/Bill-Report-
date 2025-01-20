package com.example.Bill_Generation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BillGenerationApplication {
	public static void main(String[] args) {
		SpringApplication.run(BillGenerationApplication.class, args);
	}
}
