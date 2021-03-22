package com.roulette.masiv.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roulette.masiv.domain.Roulette;

@SpringBootApplication(scanBasePackages = { "com.roulette"})
public class RouletteMasivSpringBootApplication {

	public static void main(String[] args) {
		System.out.println(Roulette.MAXIMUN_BET_VALUE);
		SpringApplication.run(RouletteMasivSpringBootApplication.class, args);
	}

}
