package com.roulettle.masiv.repository;
import java.util.Map;

import com.roulette.masiv.domain.Bet;
import com.roulette.masiv.domain.Roulette;

public interface IRoulettleRepository {
	String save(Roulette roulette);
	boolean roulettleOpening(String idRoulette);
	void doBet(Bet bet,String idRoulette);
	Map<String,Bet> findAllBets();
	Map<String,Roulette> findAllRoulettes();
}
