package com.shinhan.day06.lab;

public class Bus extends Vehicle{

	int passengerCount;
	
	public Bus(String name,int speed,int passengerCount){
		super(name, speed);
		this.passengerCount = passengerCount;
	}
	
	//final method는 재정의불가 
//	void f1() {
//		System.out.println("final test");
//	}
	
	
	@Override
	public void info() {
		super.info();
		System.out.println("승객수:" + passengerCount + "명");
	}
	
	public void info2() {
		System.out.println("버스!!!!");
	}
}
