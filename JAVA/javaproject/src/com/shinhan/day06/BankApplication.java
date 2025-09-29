package com.shinhan.day06;

import java.util.Scanner;

public class BankApplication {

	Account[] accountArr = new Account[100];
	Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		BankApplication app = new BankApplication();
		boolean isStop = false;
		while(!isStop) {
			displyMenu();
			int job = app.sc.nextInt();
			switch(job) {
			case 1->{ f_makeAccount(app); }
			case 2->{ f_accoutList(app); }
			case 3->{ f_deposit(app);}
			case 4->{ f_withdraw(app);}			
			case 5->{isStop=true;}
			default->{}
			}
		}
		System.out.println("===프로그램종료====");
	}

	private static void f_deposit(BankApplication app) {
		System.out.println("=====입금=====");
		System.out.print("계좌번호>>");
		String accNo = app.sc.next();
		System.out.print("입급액>>");
		int amount = app.sc.nextInt();
		for(int i=0;i<app.accountArr.length;i++) {
			if(app.accountArr[i]==null) break; //반복문빠지기 
            if(!app.accountArr[i].getAccNo().equals(accNo)) continue; //계좌가 다르면 계속 다른계좌를 비교한다.
            
            app.accountArr[i].deposit(amount);
            break;
		}
		
	}

	private static void f_withdraw(BankApplication app) {
		System.out.println("=====출금=====");
		System.out.print("계좌번호>>");
		String accNo = app.sc.next();
		System.out.print("출금액>>");
		int amount = app.sc.nextInt();
		for(int i=0;i<app.accountArr.length;i++) {
			if(app.accountArr[i]==null) break; //반복문빠지기 
            if(!app.accountArr[i].getAccNo().equals(accNo)) continue; //계좌가 다르면 계속 다른계좌를 비교한다.
            
            app.accountArr[i].withdraw(amount);
            break;
		}
	}
	
	private static void f_accoutList(BankApplication app) {
		for(Account acc:app.accountArr) {
			if(acc == null) {
				break;
			}
			System.out.println(acc);
		}
		
	}

	private static void f_makeAccount(BankApplication app) {
		System.out.println("======계좌생성=====");
		System.out.print("계좌번호>>");
		String accNo = app.sc.next();
		System.out.print("계좌주>>");
		String owner = app.sc.next();
		
		int balance = 0;
		while(true) {
			System.out.print("초기입급액>>");
			balance = app.sc.nextInt();
			//if(balance>= Account.MIN_BALANCE && balance<=Account.MAX_BALANCE) break;
			if(balance>= AccountEnum.MIN_BALANCE.getAmount() && 
			   balance<=AccountEnum.MAX_BALANCE.getAmount()) break;
			
		}
		
		
		Account acc = new Account(accNo, owner, balance);
		for(int i=0;i<app.accountArr.length;i++) {
			if(app.accountArr[i] == null) {
				app.accountArr[i] = acc; 
				
				break;
			}
		}
		
	}


	private static void displyMenu() {
		System.out.println("==================================");
		System.out.println("1.계좌생성 2.계좌목록 3.예금 4.출금 5.종료");
		System.out.println("==================================");
		System.out.print("선택>");
		
	}

}
