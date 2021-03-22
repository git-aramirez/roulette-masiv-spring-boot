package com.roulette.masiv.repository;
import java.util.Map;

import com.roulette.masiv.domain.Bet;
import com.roulette.masiv.domain.Roulette;

public interface IRouletteRepository {
	
	String saveRoulette(Roulette roulette);
	boolean rouletteOpening(String idRoulette);
	void doBet(Bet bet);
	void saveBet(Bet bet);
	Map<String,Bet> findAllBets();
	Map<String,Roulette> findAllRoulettes();
	
}
