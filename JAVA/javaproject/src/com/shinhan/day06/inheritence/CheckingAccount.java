package com.shinhan.day06.inheritence;


//새로운class: 기존class와 유사 
//상속받으면 부모가 변경시 자식에 반영된다. 
//수정, 추가가능 
//자식 생성시 부모가 자동으로 생성된다(호출)...super()
public class CheckingAccount extends  Account{
 
	//부모의 field수정
	int id;
	
	//추가field
	String cardNo;
	
	CheckingAccount(String accNo, String owner, int balance,String cardNo ){
		super(accNo,owner,balance );
		this.cardNo = cardNo;
	}
	CheckingAccount(String accNo, String owner){
		super(accNo,owner,0);
	}
	
	
	
	//추가method
	int pay(String cardNo, int amount) {
		if(this.cardNo.equals(cardNo)) {
			return withdraw(amount);
		}else {
			System.out.println("카드번호 불일치");
			return 0;
		}
	}
	
	

	//추가메서드
	void info() {
		System.out.println("accNo:" + getAccNo());
		System.out.println("owner:" + getOwner());
		System.out.println("balance:" + getBalance());
		System.out.println("cardNo:" + cardNo);
	}
	//부모가 가지고있는 메서드를 재정의
	@Override
	public String toString() {
		String str = super.toString();
		
		return "CheckingAccount [cardNo=" + cardNo + "]" + str;
	}
	 
}











