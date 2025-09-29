package com.shinhan.day04.ch6;

public class TestAccount {
	public static void main(String[] args) {
		Account acc = new Account("078-3762-293", 1000000);
		acc.deposit(2000000);
		acc.withdraw(500000);
		// System.out.println( acc. getBalance());
		//System.out.println( acc. getAccNo ());
	}

}