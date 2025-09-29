package com.shinhan.day07.inter;

// interface : 규격서, 상수 + 추상메스드들의 묶음
public interface TV {
	
	// 1. 상수, public static final 생략가능
	int SBS = 6;
	public static final int KBS = 9;
	
	// 2. 추상메서드, public abstract 생략가능
	void powerOn();
	public abstract void powerOff();
	public abstract void show();
	
	// 3. default 메서드 : 구현 class가 공통적으로 사용가능한 기능, 재정의 가능한 메서드
	default void active() {
		System.out.println("interface의 default 메서드 active()");
		privatemethod();
		System.out.println("---------default method에 주로하는 코드------");
		powerOn();
		show();
		powerOff();
	}
	
	// 4. static 메서드
	public static void staticMethod() {
		System.out.println("interface의 static 메서드 -> 구현 클래스가 재정의 불가");
		privateStaticMethod();
	}
	
	// 5. private 메서드
	private void privatemethod() {
		System.out.println("interface의 내부에서만 사용되는 private메서드");
	}
	
	// 6. private static 메서드
	private static void privateStaticMethod() {
		System.out.println("inter의 내부의 static에서만 사용되는 메서드");
	}

}
