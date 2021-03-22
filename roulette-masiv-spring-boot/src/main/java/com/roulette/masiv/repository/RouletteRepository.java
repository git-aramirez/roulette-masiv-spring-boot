package com.roulette.masiv.repository;


import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.roulette.masiv.domain.Bet;
import com.roulette.masiv.domain.Roulette;


@Repository
public class RouletteRepository implements IRoulettleRepository{
	
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
	public String save(Roulette roulette) {
		String id = UUID.randomUUID().toString();
		hashOperations.put(KEY_ROULETTE,id, roulette);
		return id;
	}

	@Override
	public boolean roulettleOpening(String idRoulette) {
		Roulette roulette = (Roulette) hashOperations.get(KEY_ROULETTE, idRoulette);
	    boolean status=roulette.rouletteOpening();
	    hashOperations.put(KEY_ROULETTE,idRoulette, roulette);   
	    return status;
	}

	@Override
	public void doBet(Bet bet, String idRoulette) {
		// TODO Auto-generated method stub
		
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
