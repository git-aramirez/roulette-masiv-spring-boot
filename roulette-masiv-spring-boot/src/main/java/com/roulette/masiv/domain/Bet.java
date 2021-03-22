package com.roulette.masiv.domain;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;

import com.roulette.masiv.repository.RouletteRepository;

public class Bet implements Serializable{
	
	private static final String BLACK_COLOR = "black";
	private static final String RED_COLOR ="red";
	private String idRoulette;
	private byte number;
	private String color;
	private String idUser;
	private float moneyBet;
	
	private static Logger l = LoggerFactory.getLogger(Bet.class);
	
	public Bet() {
		this.number=-1;
	}
	
	public boolean doBet(Roulette roulette) {
		
		if(roulette!=null && (isNumberBetValid() || isColorBetValid()) && isValidAmountMoney(roulette) && roulette.isStatus()) {
			roulette.setAmountMoneyBet(roulette.getAmountMoneyBet()+this.getMoneyBet());
			roulette.saveBet(this);
			return true;
		}
		return false;
	}
	
	public boolean isValidAmountMoney(Roulette roulette) {
		return ((roulette.getAmountMoneyBet() + moneyBet) <= Roulette.MAXIMUN_BET_VALUE );	
	}
	
	public boolean isColorBetValid() {
		return color.equalsIgnoreCase(RED_COLOR) || color.equalsIgnoreCase(BLACK_COLOR);
	}
	
	
	public boolean isNumberBetValid() {
		return number>=0 && number<=36;
	}
	
	public String getIdRoulette() {
		return idRoulette;
	}
	public void setIdRoulette(String idRoulette) {
		this.idRoulette = idRoulette;
	}
	public float getMoneyBet() {
		return moneyBet;
	}
	public void setMoneyBet(float moneyBet) {
		this.moneyBet = moneyBet;
	}
	public byte getNumber() {
		return number;
	}
	public void setNumber(byte number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
}
