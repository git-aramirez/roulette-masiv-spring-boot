package com.roulette.masiv.controller;

import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roulette.masiv.domain.Bet;
import com.roulette.masiv.domain.Roulette;
import com.roulette.masiv.repository.RouletteRepository;


@RestController
public class RouletteController {
	
	private RouletteRepository rouletteRepository;
	
	public RouletteController(RouletteRepository rouletteReposotory) {
		this.rouletteRepository=rouletteReposotory;
	}
	
	@PostMapping("/createRoulette")
	public String createRoulettes(@RequestBody Roulette roulette) {
		return rouletteRepository.saveRoulette(roulette);
	}
	
	@GetMapping("/rouletteOpening/{idRoulette}")
	public boolean rouletteOpening(@PathVariable String idRoulette) {
		return rouletteRepository.rouletteOpening(idRoulette);
	}
	
	@PostMapping("/doBet")
	public void doBet(@RequestBody Bet bet) {
		rouletteRepository.doBet(bet);
	}
	
	@GetMapping("/closeBets/{idRoulette}")
	public Map<String,Bet> closeBets(@PathVariable String idRoulette){
		return rouletteRepository.closeBets(idRoulette);
	}
	
	@GetMapping("/roulettes")
	public Map<String, Roulette> findAllRoulettes(){
		return rouletteRepository.findAllRoulettes();
	}
}
