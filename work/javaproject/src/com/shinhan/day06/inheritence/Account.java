package com.shinhan.day06.inheritence;

public class Account {

	private String accNo;
	private String owner;
	private int balance;
	
	public void deposit(int amount) {			// 입금 기능
		balance += amount;
	}
	
	public int withdraw(int amount) {			// 출금 기능
		
		if(balance < amount) {
			System.out.println("잔액부족으로 출금불가");
			return 0;
		}
		balance -= amount;
		return amount;
	}
	
	public Account() {
		
	}

	public Account(String accNo, String owner, int balance) {
		super();
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", owner=" + owner + ", balance=" + balance + "]";
	}
	
	
}
