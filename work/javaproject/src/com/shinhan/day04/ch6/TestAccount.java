package com.shinhan.day04.ch6;

public class TestAccount {
	public static void main(String[] args) {
		Account acc = new Account("078-3762-293", 100000);
		acc.deposit(200000);
		acc.deposit(500000);
	}

}
