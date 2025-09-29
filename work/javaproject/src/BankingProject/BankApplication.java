package BankingProject;

import java.util.Scanner;

public class BankApplication {
	Scanner sc = new Scanner(System.in);
	Account[] arr = new Account[100];

	public static void main(String[] args) {
		BankApplication app = new BankApplication();

		boolean isStop = false;
		while (!isStop) {
			display();
			int job = app.sc.nextInt();
			switch (job) {
			case 1 -> {f_makeAccount(app);}
			case 2 -> {f_accountlist(app);}
			case 3 -> {f_diposit(app);}
			case 4 -> {
			}
			case 5 -> {
				isStop = true;
			}
			default -> {
			}
			}
		}
		System.out.println("프로그램 종료!!!");

	}

	private static void f_diposit(BankApplication app) {
		System.out.println();
		System.out.println("===예금===");
		System.out.print("계좌번호 : ");
		String accNo = app.sc.next();
		System.out.print("입금액 : ");
		int amount = app.sc.nextInt();
		
		for(int i = 0; i < app.arr.length; i++) {
			if(app.arr[i] == null)break;
			if(!app.arr[i].getAccNo().equals(accNo))continue;
			
			app.arr[i].deposit(amount);
			System.out.printf("현재 %s님의 계좌 잔액 : %d\n",app.arr[i].getOwner(),app.arr[i].getBalance()+"원");
		}
		
		
		
		
	}

	private static void f_accountlist(BankApplication app) {
		System.out.println();
		System.out.println("===계좌목록===");
		boolean hasAccount = false;
		for (Account acc : app.arr) {
			if (acc != null) {
				System.out.println(acc);
				hasAccount = true;
			}
		}
		if(!hasAccount) {
			System.out.println("현재 등록된 계좌가 없습니다.");
			System.out.println();
		}
	}

	private static void f_makeAccount(BankApplication app) {
		System.out.println("===계좌생성===");
		System.out.print("계좌번호 : ");
		String accNo = app.sc.next();
		System.out.print("예금주 : ");
		String owner = app.sc.next();

		int balance = 0;
		while (true) {
			System.out.print("초기입금액 : ");
			balance = app.sc.nextInt();
			if (balance >= AccountEnum.MIN_BALANCE.getAmount() && balance <= AccountEnum.MAX_BALANCE.getAmount()) {
				break;
		}else {
			System.out.println("초기입금액을 정상적으로 입력하세요>>>");
		}
		}

		Account acc = new Account(accNo, owner, balance);
		for (int i = 0; i < app.arr.length; i++) {
			if (app.arr[i] == null) {
				app.arr[i] = acc;
				break;
			}
		}
		System.out.println("계좌가 생성되었습니다.!!!");
	}

	private static void display() {
		System.out.println("==================================");
		System.out.println("1.계좌생성 2.계좌목록 3.예금 4.출금 5.종료");
		System.out.println("==================================");
		System.out.print("선택>");
	}
}
