package com.example.NumberGame;

import com.example.NumberGame.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration //for config
@ComponentScan //for beans
@EnableJpaRepositories //JPA
@EntityScan //Hibernate
public class NumberGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumberGameApplication.class, args);

	}
}
