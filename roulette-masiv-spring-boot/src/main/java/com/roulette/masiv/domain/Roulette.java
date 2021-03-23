package com.roulette.masiv.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.springframework.data.redis.core.HashOperations;

import com.roulette.masiv.repository.RouletteRepository;

public class Roulette implements Serializable{
	
	
	public static final double MAXIMUN_BET_VALUE =10000;
	private static final byte MAXIMUN_NUMBER_BET = 36;
	private static final byte AMOUNT_WON_NUMBER = 5;
	private static final float AMOUNT_WON_COLOR = (float) 1.8;
	
	private float amountMoneyBet;
	private boolean status;
	private byte winningNumber;
	private ArrayList<Bet> myBets;
	private ArrayList<Bet> myWinningBet;
	
	private Random random;
	
	public Roulette() {
		this.status=false;
		this.winningNumber=-1;
		myBets = new ArrayList<>();
		random= new Random();
		myWinningBet=new ArrayList<>();
	}
	
	public boolean rouletteOpening() {
		if(status)
			return false;
		setStatus(true);
		return true;
	}
	
	public void saveBet(Bet bet) {
		myBets.add(bet);
	}
	
	public void closeBets() {
		this.status=false;
		winningNumber = (byte) random.nextInt(MAXIMUN_NUMBER_BET+1);
		float amounWinningtDinner =0;
		for (int i = 0; i < myBets.size(); i++) {
			if(myBets.get(i).getNumber()==winningNumber && myBets.get(i).isNumberBetValid()) {
				amounWinningtDinner=myBets.get(i).getMoneyBet()*AMOUNT_WON_NUMBER;
				if(isWinningAmountMoneyColor(myBets.get(i).getColor(),winningNumber) && myBets.get(i).isColorBetValid()) {
					amounWinningtDinner+=myBets.get(i).getMoneyBet()*AMOUNT_WON_COLOR;
				}
				myBets.get(i).setMoneytWinBet(amounWinningtDinner);
				myWinningBet.add(myBets.get(i));	
			}else if (isWinningAmountMoneyColor(myBets.get(i).getColor(),winningNumber)){
				amounWinningtDinner=myBets.get(i).getMoneyBet()*AMOUNT_WON_COLOR;
				myBets.get(i).setMoneytWinBet(amounWinningtDinner);
				myWinningBet.add(myBets.get(i));
			}
		}	
	}
	
	public void updateBetsHashOperations(HashOperations hashOperations) {
		for (int i = 0; i < myBets.size(); i++) {
			hashOperations.put(RouletteRepository.KEY_BET, myBets.get(i).getIdBet(),myBets.get(i));
		}
	}
	
	public boolean isWinningAmountMoneyColor(String color, byte winningNumber) {
		return ((winningNumber%2==0 && color.equalsIgnoreCase(Bet.RED_COLOR)) || 
				(winningNumber%2!=0 && color.equalsIgnoreCase(Bet.BLACK_COLOR))) ;
	}
		
	public ArrayList<Bet> getMyWinningBet() {
		return myWinningBet;
	}

	public void setMyWinningBet(ArrayList<Bet> myWinningBet) {
		this.myWinningBet = myWinningBet;
	}

	public byte getWinningNumber() {
		return winningNumber;
	}

	public void setWinningNumber(byte winningNumber) {
		this.winningNumber = winningNumber;
	}

	public float getAmountMoneyBet() {
		return amountMoneyBet;
	}

	public void setAmountMoneyBet(float amountMoneyBet) {
		this.amountMoneyBet = amountMoneyBet;
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
