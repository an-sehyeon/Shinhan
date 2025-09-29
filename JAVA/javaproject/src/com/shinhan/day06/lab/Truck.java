package com.shinhan.day06.lab;

public class Truck extends Vehicle{

	int maxLoad;
	
	public Truck(String name,int speed,int maxLoad){
		super(name, speed);
		this.maxLoad = maxLoad;
	}
	
	
	@Override
	public void info() {
		super.info();
		System.out.println("적재용량:" + maxLoad + "kg");
	}
	
	
}
