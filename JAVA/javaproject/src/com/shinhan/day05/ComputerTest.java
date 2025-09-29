package com.shinhan.day05;

public class ComputerTest extends Computer{

	void f1() {
		Computer com1 = new Computer();
		com1.os = "윈도우";
		com1.price = 300;
		com1.print();
		//com1.print2(); 생략은 같은패키지에서만 접근가능 
		
		//상속받으면 다른 패키지에서도 접근가능 
		print3();
		
		
		//com1.print4();  private접근불가 
	}
}
