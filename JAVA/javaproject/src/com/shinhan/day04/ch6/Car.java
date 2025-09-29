package com.shinhan.day04.ch6;

public class Car {

	//1.field(Object들마다 가지는 멤버변수)
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	//C언어의 share변수, 자바는 static변수 
	//class를 이용해서 생성한 모든instance(멤버)가 공유한다.   
	static int carCount;
	
	
	//2.constructor(생성자)--field초기화 
	public Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		System.out.println("자동차가 생성되었습니다.");
		carCount++;
	}
	public Car() {
		 this(null, null, 0);
	}
	public Car(String model) {
		this(model, null, 0);
	}
	public Car(String model, String color) {
		this(model, color, 100);
	}
	//3.일반메서드 
    void carInfoPrint() {
    	System.out.println("=============Car의 정보==============");
    	System.out.printf("제조사는 %s\n", company);
    	System.out.printf("모델은 %s\n", this.model);
    	System.out.printf("색깔은 %s\n", color);
    	System.out.printf("최대속도는 %d\n", maxSpeed);
    }
	
}







