package com.shinhan.day06.inheritence;

public class InheritenceTest {

	public static void main(String[] args) {
		f6();

	}

	private static void f6() {
		BonusPointAccount acc1 = 
				new BonusPointAccount("1234", "김", 1000, 10);
		System.out.println(acc1);
		acc1.deposite(2000);
		int amount = acc1.withdraw(3500);
		System.out.println(amount + "출금");
		System.out.println(acc1);
		
	}

	
	private static void f5() {
		CreditLineAccount acc1 = 
				new CreditLineAccount("1234", "김", 1000, 500);
		System.out.println(acc1);
		acc1.deposite(2000);
		int amount = acc1.withdraw(3500);
		System.out.println(amount + "출금");
		
	}

	private static void f4() {
		CheckingAccount acc1 = new CheckingAccount("99999", "김대현", 2000, "3434");
		System.out.println(acc1);
		
		acc1.id = 100;
		String s = acc1.toString();
		System.out.println(s);
		
		
		
		acc1.deposite(1000);
		System.out.println("잔고:" + acc1.getBalance());
		int amount = acc1.withdraw(500);
		System.out.println("출금:" + amount);
		System.out.println("잔고:" + acc1.getBalance());
		amount = acc1.pay("3434", 1000);
		System.out.println("출금:" + amount);
		System.out.println("잔고:" + acc1.getBalance());
	}

	private static void f3() {
		Account acc1 = new Account("12345", "홍길동2", 1000);
		System.out.println(acc1);
		
	}
	
	private static void f2() {
		Account acc1 = new Account();
		acc1.setAccNo("1234");
		acc1.setOwner("홍길동");
		acc1.setBalance(1000);
		System.out.println(acc1);
		
	}

	private static void f1() {

        //Child c1 = new Child();
        /*Child c2 = new Child("조상호", 20);
        System.out.println(c2.name);
        System.out.println(c2.age);*/
		
		Child c3 = new Child("안가연", 20, 1000);
		System.out.println(c3.name);
        System.out.println(c3.age);
        System.out.println(c3.salary);
	}

}
