package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Account {
	private String accNo;
	private String owner;
	private int balance;
	
	// 출금 로직
	public int withdraw(int amount) {
		if(balance < amount) {
			System.out.println("잔액부족");
			return 0;
		}
		balance -= amount;
		return amount;
	}
	
	// 입금 로직
	public void deposit(int amount) {
		balance += amount;
	}
}
