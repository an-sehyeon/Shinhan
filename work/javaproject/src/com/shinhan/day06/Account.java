package com.shinhan.day06;

public class Account {
	
	// 1.field
	private String accNo;		// 계좌번호
	private String owner; 		// 예금주
	private int balance;		// 잔고
	
	// instance field가 final이면 선언시 또는 생성시 초기화된다.
	private final int aa=0;
	
	// 상수는 반드시 선언시 초기화
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	
	// 2. constructor
	public Account() {this(null,null,0);}
	public Account(String accNo, String owner, int balance) {
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
		System.out.println("계좌가 생성되었습니다.");
	}
	
	@Override
	public String toString() {
		return "현재 계좌 상태 [계좌번호=" + accNo + ", 예금주=" + owner + ", 잔액=" + balance + "]";
	}
	// 입금
	public void deposit(int amount) {
		balance += amount;
	}
	
	// 출금
	int withdraw(int amount) {
		if(balance >= amount) {
			balance -= amount;
			System.out.println("출금성공");
			return amount;
		}else {
			System.out.println("잔고부족. 출금실패");
			return 0;
		}
	}
	
	void setBalance(int balance) {
		// 상수들의 묶음은 enum이다. 
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
	public static void main(String[] args) {
		
	}
}
