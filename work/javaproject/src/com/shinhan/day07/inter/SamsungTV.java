package com.shinhan.day07.inter;

// TV interface를 구현한 class이다.
// 구현 class는 여려개의 interface를 구현할 수 있다.
public class SamsungTV implements TV,Soundable{
	
	String company = "삼성";
	 
	void samsungInfo() {
		System.out.println(company);
	}

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + "전원을 켭니다.");
	}
	
	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + "전원을 끕니다.");
	}
		
	@Override
	public void show() {
		System.out.println(getClass().getSimpleName() + "--show!!!");
	}
	
	@Override
	public void sound(){
		System.out.println("삼성이 Soundable을 구현함");
	}

}
