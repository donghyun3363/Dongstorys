package com.dong.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class DongstorysApplication {

	public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "C:/app/config/spring/real-application.yml";

	public static void main(String[] args) {
		SpringApplication.run(DongstorysApplication.class, args);
	}
}
