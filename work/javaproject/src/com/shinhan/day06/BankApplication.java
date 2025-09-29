package com.shinhan.day06;

import java.util.Scanner;

public class BankApplication {
	
	Account[] accountArr = new Account[100];
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		BankApplication app = new BankApplication();
		boolean isStop = false;
		
		while(!isStop) {
			displayMenu();
			int job = app.sc.nextInt();
			switch(job){
			case 1 -> {f_makeAccount(app);}
			case 2 -> {f_accountList(app);}
			case 3 -> {f_deposit(app);}
			case 4 -> {f_withdraw(app);}
			case 5 -> {isStop = true;}
			default -> {;}
			}
		}
		System.out.println("====프로그램 종료====");
		
	}

	private static void f_withdraw(BankApplication app) {
		System.out.println("====출금====");
		System.out.print("계좌번호 입력 : ");
		String accNo = app.sc.next();
		
		System.out.print("출금액 입력 : ");
		int amount = app.sc.nextInt();
		for(int i = 0;i < app.accountArr.length;i++) {
			if(app.accountArr[i]== null) break;		// 계좌가 비어있으면 반복문 빠지기
			if(!app.accountArr[i].getAccNo().equals(accNo)) continue;	// 계좌가 다르면 계속 다른계좌를 비교
			
			app.accountArr[i].withdraw(amount);		// 입금
			break;									// 반복문 종료
			
		}
		
	}

	private static void f_deposit(BankApplication app) {
		System.out.println("====입금====");
		System.out.print("계좌번호 입력 : ");
		String accNo = app.sc.next();
		
		System.out.print("입금액 입력 : ");
		int amount = app.sc.nextInt();
		boolean found = false;
		for(int i = 0;i < app.accountArr.length;i++) {
			if(app.accountArr[i]== null) break;		// 계좌가 비어있으면 반복문 빠지기
			if(!app.accountArr[i].getAccNo().equals(accNo)) continue;	// 계좌가 다르면 계속 다른계좌를 비교
			
			app.accountArr[i].deposit(amount);		// 입금
			found = true;
			break;									// 반복문 종료
			
		}
		if(!found) {System.out.println("해당계좌가 존재하지 않습니다.");}
	}

	private static void f_accountList(BankApplication app) {
		for(Account acc : app.accountArr) {
			if (acc == null) {
				break;
			}
			System.out.println(acc);
		}
	}

	private static void f_makeAccount(BankApplication app) {
		System.out.println("====계좌생성====");
		System.out.print("계좌번호 입력 : ");
		String accNo = app.sc.next();
		
		System.out.print("계좌주 입력 : ");
		String owner = app.sc.next();
		
		System.out.print("초기입금액 입력 : ");
		int balance = app.sc.nextInt();
		
		Account acc = new Account(accNo, owner, balance);
		for(int i = 0; i<app.accountArr.length; i++) {
			if(app.accountArr[i] == null){
				app.accountArr[i] = acc;
				break;
			}
		}
	}

	private static void displayMenu() {
		System.out.println("===================================");
		System.out.println("1.계좌생성 2.계좌목록 3.예금 4.출금 5.종료 ");
		System.out.println("===================================");
		System.out.print("선택 >>>");
	}

}
