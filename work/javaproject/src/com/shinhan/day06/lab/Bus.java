package com.shinhan.day06.lab;

public class Bus extends Vehicle{
	int passengerCount;
	
	public Bus(String name, int speed, int passeengerCount) {
		super(name, speed);
		this.passengerCount = passeengerCount;
	}
	
	public void info() {
		super.info();
		System.out.println("승객 수요 가능 인원 : " + passengerCount + "명\n");
	}
	
	public void info2() {
		System.out.println("버스!!!");
	}
}
