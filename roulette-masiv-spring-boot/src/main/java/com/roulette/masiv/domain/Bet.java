package com.roulette.masiv.domain;

import java.io.Serializable;

public class Bet implements Serializable{
	
	public static final String RED_COLOR ="red";
	public static final String BLACK_COLOR ="black";
	private String idRoulette;
	private String idBet;
	private byte number;
	private String color;
	private String idUser;
	private float moneyBet;
	private float moneytWinBet;
	
	public Bet() {
		this.number=-1;
	}
	
	public boolean doBet(Roulette roulette,String idBet) {
		if(roulette!=null && (isNumberBetValid() || isColorBetValid()) && isValidAmountMoney(roulette) && roulette.isStatus()) {
			roulette.setAmountMoneyBet(roulette.getAmountMoneyBet()+this.getMoneyBet());
			this.idBet=idBet;
			roulette.saveBet(this);
			return true;
		}
		return false;
	}
	
	
	public boolean isColorBetValid() {
		return (color.equalsIgnoreCase(RED_COLOR) || color.equalsIgnoreCase(BLACK_COLOR));
	}
	public boolean isValidAmountMoney(Roulette roulette) {
		return ((roulette.getAmountMoneyBet() + moneyBet) <= Roulette.MAXIMUN_BET_VALUE );	
	}
	
	public String getIdBet() {
		return idBet;
	}

	public void setIdBet(String idBet) {
		this.idBet = idBet;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public float getMoneytWinBet() {
		return moneytWinBet;
	}
	public void setMoneytWinBet(float monetWinBet) {
		this.moneytWinBet = monetWinBet;
	}

}
