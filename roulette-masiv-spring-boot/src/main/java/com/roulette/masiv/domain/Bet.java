package com.roulette.masiv.domain;

public class Bet {
	
	private int number;
	private String color;
	private String idUser;
	private double moneyBet;
	
	
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
