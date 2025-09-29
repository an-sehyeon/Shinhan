package com.shinhan.day06;

public class Account {

	//1.field
	private String accNo;  //계좌번호
	private String owner;  //예금주
	private int balance;   //잔고 
	
	//instance field가 final이면 선언시 또는 생성시 초기화한다. 
	private final int aa=0;
	
	//상수는 반드시 선언시 초기화한다. 
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	 
 
	//2.constructor
	public Account() {
		this(null, null, 0);
	}
	public Account(String accNo, String owner, int balance) {
		super();
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
		System.out.println("계좌가 생성되었습니다.");
	}
	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", owner=" + owner + ", balance=" + balance + "]";
	}
	//입금하다 
	void deposit( int amount) {
		balance += amount;
	}
	//출금하다
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
	
	
	void setBalance(int balance){
		//상수들의 묶음은 enum이다. Account에서 사용된 상수가 
		//만약에 관련 classe들에서 동일한값을 쓴다면 enum권장  
		int min = AccountEnum.MIN_BALANCE.getAmount();
		int max = AccountEnum.MAX_BALANCE.getAmount();
		
		if(balance >= min && balance<=max) {
		    this.balance = balance;
		    //System.out.println("잔고가 수정되었습니다.");
		}
	}
	
	int getBalance(){
		return balance;
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
	
	
}

/*
19. 은행 계좌 객체인 Account 객체는 잔고(balance) 필드를 가지고 있습니다. balance 필드는 
음수값이 될 수 없고, 최대 백만 원까지만 저장할 수 있습니다. 외부에서 balance 필드를 마음대로 
변경하지 못하도록 하고, 0 <= balance <= 1,000,000 범위의 값만 가질 수 있도록 Account 클래
스를 작성해보세요.
➊ Setter와 Getter를 이용
➋ 0과 1,000,000은 MIN_BALANCE와 MAX_BALANCE 상수를 선언해서 이용
➌ Setter의 매개값이 음수이거나 백만 원을 초과하면 현재 balance 값을 유지
*/
