package com.shinhan.day06.lab;

public class Car extends Vehicle{
	
	int gasMileage;
	
	public Car(String name, int speed, int gasMileage){
		super(name, speed);
		this.gasMileage = gasMileage;
	}
	
	public void info() {
		super.info();
		System.out.println("연비: " + gasMileage + "km/L)\n");
	}

}
