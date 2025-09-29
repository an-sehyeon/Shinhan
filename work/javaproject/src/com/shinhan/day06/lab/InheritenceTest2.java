package com.shinhan.day06.lab;

import com.shinhan.day06.inheritence.Account;
import com.shinhan.day06.inheritence.BonusPointAccount;
import com.shinhan.day06.inheritence.CheckingAccount;
import com.shinhan.day06.inheritence.CreditLineAccount;

public class InheritenceTest2 {
	public static void main(String[] args) {
//		call();
//		call2();
		call3();
	}

	private static void call3() {
		Account[] arr = new Account[4];
		
		arr[0] = new Account("122","김", 2000);
		arr[1] = new BonusPointAccount("123","박", 1000, 100);
		arr[2] = new CheckingAccount("124","양", 3000, "9999");
		arr[3] = new CreditLineAccount("125","정", 3000, 2000);
		
		for(Account acc : arr) {
			acc.deposit(1);
			int amount = acc.withdraw(100);
			System.out.println("출금 : " + amount);
			System.out.println("잔고 : " + acc.getBalance());
			System.out.println(acc);
			
			// 강제형변환 : 자식타입 = (자식타입) 부모객체, 단 부모객체가 자식타입으로 만든 객체일때만 가능
			if(acc instanceof CheckingAccount card) {
			int aa = card.pay("9999",amount);
			System.out.println("카드번호로 출금 : " + aa);
			}
			
			System.out.println("=======================================");
		}
		
	}

	// 객체지향 프로그램의 3가지 특징 : 캡슐화(private), 상속성(extends), 다형성(사용법은 같지만 결과가 다르다)
	private static void call2() {
		
		// 1. 참조형 자동형변환 : 부모타입 = 자식객체
		Vehicle[] arr = new Vehicle[3];
		arr[0] = new Car("ABC승용차", 100,15);
		arr[1] = new Bus("시내버스", 100, 40);
		arr[2] = new Truck("화물트럭", 90, 5000);
		for(Vehicle v : arr) {
			print(v);
		}
		
		// 2. 참조형 강제형변환 : 자식타입 = (자식타입)부모객체, 단, 부모객체의 본래의 instance가 자식이었을때만 가능
	}
	
	public static void print(Vehicle v) {
		v.info();
		v.start();
		v.stop();
		
		if(v instanceof Bus) {
		Bus b = (Bus)v;
		b.info2();
		}
		System.out.println("====================");
		System.out.println();
	}

	private static void call() {
		// 1. 기본형 자동형변환 : 큰방 = 작은값
		int i = 100;
		double j = i;
		System.out.println(i + ":" + j);
		
		// 2. 기본형 강제형변환 : 작은방 = (작은방타입)큰값
		i = (int)j;
		System.out.println(i);
		
		
		
		
	}
	
		
		
}
