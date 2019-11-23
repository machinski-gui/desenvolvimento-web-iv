package com.rs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@SpringBootApplication
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)

public class RentalSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(RentalSystemApplication.class, args);
	}

}
