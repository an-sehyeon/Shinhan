package com.shinhan.day07.inter;

// TV interface를 구현한 class이다.
public class LgTV implements TV{
	
	String company2 = "LG전자";
	 
	void display() {
		System.out.println("우리 회사는 화질이 좋아요");
	}

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + "전원을 켭니다.!!!!!");
	}
	
	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + "전원을 끕니다.!!!!!");
	}
	
	@Override
	public void show() {
		System.out.println(getClass().getSimpleName() + "--show");
	}

	@Override
	public void active() {
		TV.super.active();
		System.out.println("===LG가 재정의 함===");
	}

	//@Override
	static void staticMethod2() {
		System.out.println("구현클래스가 재정의 불가-> 추가메서드");
	}
	
		

}
