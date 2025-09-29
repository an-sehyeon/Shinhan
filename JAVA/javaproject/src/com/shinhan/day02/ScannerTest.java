package com.shinhan.day02;

import java.util.Scanner;


//CRUD(Create Read Update Delete)프로그램 작성시 사용할 예정 
public class ScannerTest {

	public static void main(String[] args) {
		f7();

	}

	private static void f7() {
		int balance = 0;
		boolean isEnd = false;
		int job;
		Scanner sc = new Scanner(System.in);
		while(!isEnd) {
			menuDisplay();
			job = sc.nextInt();
			switch(job) {
				case 1->{
					System.out.print("입금액>>");
					int amount = sc.nextInt();
					balance += amount;
				}
				case 2->{
					System.out.print("출금액>>");
					int amount = sc.nextInt();
					if(balance < amount) {
						System.out.println("잔고부족. 출금불가"); continue;
					}
					balance -= amount;
				}
				case 3->{
					System.out.println("잔고:" + balance);
				}
				case 4->{isEnd = true;}
				default->{
					System.out.println("지원되지 않는 업무입니다.");
				}
			}
		}
		sc.close();
		System.out.println("==========종료===================");
	}

	private static void menuDisplay() {
		System.out.println("-----------------------");
		System.out.println("1.예금 2.출금 3.잔고 4.종료");
		System.out.println("-----------------------");
		System.out.print("작업선택>>");
	}

}





