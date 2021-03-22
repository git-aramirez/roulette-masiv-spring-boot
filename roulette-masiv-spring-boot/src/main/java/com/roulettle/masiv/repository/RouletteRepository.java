package com.roulettle.masiv.repository;


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
	private HashOperations hashOperatations;
	
	public RouletteRepository(RedisTemplate<String, Roulette> redisTemplate) {
		this.redisTemplate=redisTemplate;
	}
	
	@PostConstruct
	private void init() {
		hashOperatations = redisTemplate.opsForHash();
	}
	

	@Override
	public String save(Roulette roulette) {
		String id = UUID.randomUUID().toString();
		hashOperatations.put(KEY_ROULETTE,id, roulette);
		return id;
	}

	@Override
	public boolean roulettleOpening(String idRoulette) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doBet(Bet bet, String idRoulette) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Bet> findAllBets() {
		return hashOperatations.entries(KEY_BET);
	}

	@Override
	public Map<String, Roulette> findAllRoulettes() {
		System.out.println(hashOperatations.entries(KEY_ROULETTE));
		return hashOperatations.entries(KEY_ROULETTE);
	}

}
