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
		return rouletteRepository.save(roulette);
	}
	
	@PostMapping("/rouletteOpening/{id}")
	public boolean rouletteOpening(@PathVariable String id) {
		return rouletteRepository.roulettleOpening(id);
	}
	
//	@PostMapping
//	public void doBet(@RequestBody Bet bet,@PathVariable String id) {
//		rouletteRepository.doBet(bet, id);
//	}
	
	
	@GetMapping("/bets")
	public Map<String,Bet> findAllBets(){
		return rouletteRepository.findAllBets();
	}
	
	@GetMapping("/roulettes")
	public Map<String, Roulette> findAllRoulettes(){
		return rouletteRepository.findAllRoulettes();
	}
}
