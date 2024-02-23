package com.tibetyo.ible;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class IbleApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbleApplication.class, args);
	}

}
