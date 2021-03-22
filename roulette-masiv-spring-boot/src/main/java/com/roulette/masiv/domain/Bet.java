package com.roulette.masiv.domain;

import org.springframework.data.redis.core.HashOperations;

public class Bet {
	
	private static final String BLACK_COLOR = "black";
	private static final String RED_COLOR ="red";
	private String idRoulette;
	private int number;
	private String color;
	private String idUser;
	private double moneyBet;
	
	
	public boolean doBet(Roulette roulette) {
		if(roulette!=null && isNumberBetValid() && isColorBetValid() && isValidAmountMoney(roulette)) {
			return true;
		}
		
		return false;
	}
	
	public boolean isValidAmountMoney(Roulette roulette) {
		if( (roulette.getAmountMoneyBet() + moneyBet) > Roulette.MAXIMUN_BET_VALUE )
			return false;
		return true;
		
	}
	
	public boolean isColorBetValid() {
		if(color.equalsIgnoreCase(BLACK_COLOR) || color.equalsIgnoreCase(BLACK_COLOR))
			return true;
		return false;
	}
	
	
	public boolean isNumberBetValid() {
		if(number>=0 && number<=36)
			return true;
		return false;
	}
	
	public String getIdRoulette() {
		return idRoulette;
	}
	public void setIdRoulette(String idRoulette) {
		this.idRoulette = idRoulette;
	}
	public double getMoneyBet() {
		return moneyBet;
	}
	public void setMoneyBet(double moneyBet) {
		this.moneyBet = moneyBet;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
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
