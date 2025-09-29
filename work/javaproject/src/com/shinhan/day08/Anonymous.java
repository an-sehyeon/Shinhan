package com.shinhan.day08;

//익명구현 class를 field, local변수, 매개변수로 넘기기, 받기
public class Anonymous {
	Vehicle field() {
		return field;
	}
	Vehicle field2() {
		return field;
	}
	
	Vehicle field = ()->{System.out.println("람다표현식으로 익명구현class 구현하기(field로 사용)");};

	void method1() {
		Vehicle localVar = () -> System.out.println("람다표현식으로 익명구현class 구현하기(localVar로 사용)");
		localVar.run();
	}
	
	void method2(Vehicle v) {
		v.run();
	}
}
