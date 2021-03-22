package com.roulette.masiv.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Roulette implements Serializable{
	
	public static final double MAXIMUN_BET_VALUE =10000;
	private float amountMoneyBet;
	private boolean status;
	private ArrayList<Bet> myBets;
	
	public Roulette() {
		this.status=false;
		myBets = new ArrayList<>();
	}
	
	public void saveBet(Bet bet) {
		myBets.add(bet);
	}
	
	public float getAmountMoneyBet() {
		return amountMoneyBet;
	}

	public void setAmountMoneyBet(float amountMoneyBet) {
		this.amountMoneyBet = amountMoneyBet;
	}

	public boolean rouletteOpening() {
		if(status)
			return false;
		setStatus(true);
		return true;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArrayList<Bet> getMyBets() {
		return myBets;
	}

	public void setMyBets(ArrayList<Bet> myBets) {
		this.myBets = myBets;
	}
	
}
