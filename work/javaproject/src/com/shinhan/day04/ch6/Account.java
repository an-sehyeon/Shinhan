package com.shinhan.day04.ch6;

public class Account {
	// 1. field(data 저장 목적)
	String accNo;
	int balance;
	
	// 2. 생성자(new에 의해 자동호출되는 메서드), field를 초기화 목적
	Account(String accNo, int balance){
		this.accNo = accNo;
		this.balance = balance;
		print("계좌가 개설되었습니다.");
	}
	
	void deposit(int amount) {
		balance += amount;
		print("계좌에 " + amount + "원이 입급되었습니다.");
		
	}
	
	void withdraay(int amount) {
		balance =- amount;
		print("계좌에 " + amount + "원이 출금되었습니다.");
	}

	String getAccNo() {
		return accNo;
	}
	
	int  getBalance() {
		return balance;
	}
	
	void print(String message) {
		System.out.println(getAccNo() + message);
		System.out.println(accNo + "계좌의 잔고는 "  + getBalance() + "원입니다.");
	}
	
	/*
	계좌(Account) 클래스는 
	계좌 번호를 나타내는 accNo 데이터와 
	잔고를 나타내는 balance 데이터를 가지고 있습니다.

	함수로는 입금을 의미하는 deposit 함수와 출금을 의미하는 withdraw 함수 및 잔고를 확인하는 getBalance 함수와 계좌 번호를 확인하는 getAccNo 함수를 가지고 있습니다. TestAccount 클래스를 이용하여 Account 클래스의 함수를 호출시켰을 때 콘솔에 출력되는 결과는 다음과 같습니다.


	[TestAccount 실행결과]
	078-3762-293 계좌가 개설되었습니다.
	078-3762-293 계좌의 잔고는 1000000원입니다.


	078-3762-293 계좌에 2000000원이 입금되었습니다.
	078-3762-293 계좌의 잔고는 3000000원입니다.

	078-3762-293 계좌에 500000원이 출금되었습니다.
	078-3762-293 계좌의 잔고는 3500000원입니다.
	*/

}
