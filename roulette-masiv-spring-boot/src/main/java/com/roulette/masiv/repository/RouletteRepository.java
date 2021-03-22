package com.roulette.masiv.repository;


import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.roulette.masiv.domain.Bet;
import com.roulette.masiv.domain.Roulette;


@Repository
public class RouletteRepository implements IRouletteRepository{
	
	private static final String KEY_ROULETTE ="Roulette";
	private static final String KEY_BET="Bet";
	
	private RedisTemplate<String,Roulette> redisTemplate;
	private HashOperations hashOperations;
	
	public RouletteRepository(RedisTemplate<String, Roulette> redisTemplate) {
		this.redisTemplate=redisTemplate;
	}
	
	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}
	

	@Override
	public String saveRoulette(Roulette roulette) {
		String id = UUID.randomUUID().toString();
		hashOperations.put(KEY_ROULETTE,id, roulette);
		return id;
	}

	@Override
	public boolean rouletteOpening(String idRoulette) {
		Roulette roulette = (Roulette) hashOperations.get(KEY_ROULETTE, idRoulette);
	    boolean status=roulette.rouletteOpening();
	    hashOperations.put(KEY_ROULETTE,idRoulette, roulette);   
	    return status;
	}
	
	private static Logger l = LoggerFactory.getLogger(RouletteRepository.class);
	
	@Override
	public void doBet(Bet bet) {
		Roulette roulette = (Roulette) hashOperations.get(KEY_ROULETTE, bet.getIdRoulette());
		if(bet.doBet(roulette)) {
			l.info("entroooo");
			roulette.setAmountMoneyBet(roulette.getAmountMoneyBet()+bet.getMoneyBet());
			roulette.saveBet(bet);
			hashOperations.put(KEY_ROULETTE,bet.getIdRoulette(), roulette);
			saveBet(bet);
		}
	}
	
	@Override
	public void saveBet(Bet bet) {
		hashOperations.put(KEY_BET,UUID.randomUUID().toString(), bet);
	}

	@Override
	public Map<String, Bet> findAllBets() {
		return hashOperations.entries(KEY_BET);
	}

	@Override
	public Map<String, Roulette> findAllRoulettes() {
		return hashOperations.entries(KEY_ROULETTE);
	}

	

}
