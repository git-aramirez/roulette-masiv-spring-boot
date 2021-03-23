package com.roulette.masiv.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roulette.masiv.domain.Roulette;

@SpringBootApplication(scanBasePackages = { "com.roulette"})
public class RouletteMasivSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouletteMasivSpringBootApplication.class, args);
	}

}
