package com.shinhan.day06.inheritence;

public class CreditLineAccount extends Account {

	//field 추가
	int creditLine;
	
	//생성자추가
	CreditLineAccount(String accNo, String owner, int balance, int creditLine){
		super(accNo, owner, balance);
		this.creditLine = creditLine;
	}
	
	//재정의 (부모가 정의메서드를 다시 구현)
	//메서드이름같고 매개변수 개수와 타입같고 return같고 접근제한자는 같거나 더 넓어져야한다. 
	@Override //컴파일러가 해석한다. annotation 
	public int withdraw(int amount) {
		if(getBalance()+creditLine < amount) {
			System.out.println("잔액부족으로 출금불가.");
			return 0;
		}
		setBalance(getBalance() - amount);
		return amount;
	}

	@Override
	public String toString() {
		return "CreditLineAccount [creditLine=" + creditLine + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}





