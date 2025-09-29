package com.shinhan.day06.lab;

public class Truck extends Vehicle{
	int maxLoad;
	
	public Truck(String name, int speed, int maxLoad) {
		super(name, speed);
		this.maxLoad = maxLoad;
	}
	
	public void info() {
		super.info();
		System.out.println("최대 적재량 : " + maxLoad + "kg)\n");
	}
}
