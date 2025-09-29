package com.shinhan.day04;

public class Person {
 
	//1.field
	String name;
	
	//2.method
	void play() {
		
	}
	void eat() {
		
	}
	void calc_use() {
		//사용관계
		//Class타입 Object변수선언 = new로 생성 
		Calculator cal = new Calculator();
		int result = cal.add(1, 2);
		System.out.println("add==>" + result);
	}
	
}
