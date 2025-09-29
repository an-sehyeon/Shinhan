package com.shinhan.day09.lab;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor		// 필수(final) field를 초기화하는 생성자를 만들기
@EqualsAndHashCode(of = {"model"})
class CellPhone{
	private String model;
	private double battery;
	
//	public CellPhone(String model) {
//		this.model = model;
//	}
	
	// RuntimeException은 자동으로 던져짐
	void call(int time) {
		if(time <0)throw new IllegalArgumentException("통화시간입력오류");
		System.out.println("통화시간 : " + time + "분");
		battery -= time * 0.5;
		if(battery < 0) battery = 0;
	}
	
	void printBattery() {
		System.out.printf("남은 배터리 양 : %2.1f\n",battery);
	}
	
	void charge(int time) {
		if(time < 0) throw new IllegalArgumentException("충전시간오류");
		System.out.printf("충전 시간 : %d\n", time);
		battery += time * 3;
		if(battery > 100) battery = 100;
	}
	
	// 재정의(override) : 이름, 매개변수, return이 같아야한다.
//	public boolean equals(Object obj) {
//		if(!(obj instanceof CellPhone)) return false;
//		
//		CellPhone otherCellphone = (CellPhone)obj;
//		if(model.equals(otherCellphone.model)) return true;
//		
//		return false;
//	}
}



public class CellPhoneMain {
	public static void main(String[] args) {

		CellPhone myPhone = new CellPhone("SCH-600", 0);
		myPhone.charge(20); // 20분간 충전을 한다.
		myPhone.printBattery();
		myPhone.call(300); // 300분간 통화를 한다.
		myPhone.printBattery();
		myPhone.charge(50); // 50분간 충전을 한다.
		myPhone.printBattery();
		myPhone.call(40); // 40분간 통화를 한다.
		myPhone.printBattery();
		
		// Exception처리했으므로 프로그램이 중단없이 계속 진행함.
		try {
			myPhone.call(-20); // 통화시간이 잘못 입력되었다.
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		CellPhone yourPhone = new CellPhone("SCH-600", 0);
		if (myPhone.equals(yourPhone)) {
			System.out.println("동일 모델입니다.");
		} else {
			System.out.println("다른 모델입니다.");
		}
	}
}
