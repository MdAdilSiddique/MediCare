package com.mediCare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MediCarecApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediCarecApplication.class, args);
	}

}
