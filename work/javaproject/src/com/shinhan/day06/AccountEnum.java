package com.shinhan.day06;

public enum AccountEnum {
	MIN_BALANCE(0), MAX_BALANCE(100);
	
	int amount;
	AccountEnum(int amount){
		this.amount = amount;
	}
	
	int getAmount(){
		return amount;
	}
}
