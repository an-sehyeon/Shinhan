package com.shinhan.day06.lab;

public class Car extends Vehicle{

	int gasMilege;
	
	public Car(String name,int speed,int gasMilege  ){
		super(name, speed);
		this.gasMilege = gasMilege;
	}
	
	
	@Override
	public void info() {
		super.info();
		System.out.println("연비:" + gasMilege + "km/L");
	}
	
	
}
