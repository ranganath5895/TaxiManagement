package com.taxi.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaxiManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiManagementApplication.class, args);
	}
}
