package com.shinhan.day07;

// abstract class : 추상메서드가 0개 이상있다. = 추상메서드가 있을 수도 있고 없을 수도 있다.
public abstract class Shape {
	
	// 부모를 통해 자식의 기능을 이용하기 위해 정의.
	// 자식이 재정의하면 재정의된 메서드가 수행됨.
	// 정의는 있고 구현은 없다 (abstract method)
	public abstract double getArea();
	void f1() {
		System.out.println("일반메서드 구현");
	}
	
}
