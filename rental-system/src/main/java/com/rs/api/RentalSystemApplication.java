package com.rs.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.rs.controller"})
@EntityScan(basePackages = {"com.rs.entity"})
public class RentalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalSystemApplication.class, args);
	}

}
