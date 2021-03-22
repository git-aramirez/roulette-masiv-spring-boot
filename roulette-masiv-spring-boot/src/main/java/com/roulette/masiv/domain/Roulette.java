package com.roulette.masiv.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Roulette implements Serializable{
	
	private static final double MAXIMUN_BET_VALUE =10000;
	private boolean status;
	private ArrayList<Bet> myBets;
	
	public Roulette() {
		this.status=false;
		myBets = new ArrayList<>();
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
