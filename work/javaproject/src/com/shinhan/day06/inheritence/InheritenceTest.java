package com.shinhan.day06.inheritence;

public class InheritenceTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
		
		
	}
	
	private static void f6() {
		BonusPointAccount acc1 = new BonusPointAccount("1234", "김사장", 1000, 1500);
		System.out.println(acc1);
		acc1.deposit(2000);
		int amount = acc1.withdraw(3500);
		System.out.println(amount + "출금");
		System.out.println(acc1);
	}
		
	

	private static void f5() {
		CreditLineAccount acc1 = new CreditLineAccount("1234", "김사장", 1000, 1500);
		System.out.println(acc1);
		acc1.deposit(2000);
		int amount = acc1.withdraw(3500);
		System.out.println(amount + "출금");
	}

	private static void f4() {
		CheckingAccount acc1 = new CheckingAccount("9999", "김모씨", 40000, "3434");
		System.out.println(acc1);
		
		acc1.deposit(1000);
		System.out.println(acc1.getBalance());
		int amount = acc1.withdraw(500);
		System.out.println("출금 : " + amount);
		System.out.println("잔고 : " + acc1.getBalance());
		amount = acc1.pay("3434", 1000);
		System.out.println("출금 : " + amount);
		System.out.println("잔고 : " + acc1.getBalance());
	}

	private static void f3() {
		Account acc1 = new Account("1234","홍길동",1234);
		System.out.println(acc1);
	}

	private static void f2() {
		Account acc1 = new Account();
		acc1.setAccNo("1234");
		acc1.setOwner("홍길동");
		acc1.setBalance(5000000);
		System.out.println(acc1);
	}

	private static void f1() {
//		Child c1 = new Child();
//		Child c2 = new Child("홍길동",20);
//		System.out.println(c2.name);
//		System.out.println(c2.age);
		
		Child c3 = new Child("장그래", 20, 1000);
		System.out.println(c3.name);
		System.out.println(c3.age);
		System.out.println(c3.salary);
	}

}
