package com.shinhan.day06.inheritence;


//기존class
public class Account  {

	private String accNo;
	private String owner;
	private int balance;
	
	String id;
	
	public Account() {
		
	}
	
	
	public Account(String accNo, String owner, int balance) {
		super();
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}
	
	
	void deposite(int amount) {
		balance += amount;
	}
	int withdraw(int amount) {
		if(balance < amount) {
			System.out.println("잔액부족으로 출금불가.");
			return 0;
		}
		balance -= amount;
		return amount;
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

    //@Override : 덮어쓰기 , 재정의 , 기존거 사용안하고 현재거만 사용 
	@Override
	public String toString() {
		return "!!!![accNo=" + accNo + ", owner=" + owner + ", balance=" + balance + "]";
	}
 
	
	
	
}
