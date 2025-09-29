package com.shinhan.day06.lab;

//final class는 상속불가. 
//final field는 수정불가 
//final method는 재정의불가 

public  class Vehicle {

	//속성(field)
	String name;
	int speed;
	
	final int score=99;
	final void f1() {
		System.out.println("final test");
	}
	
	public Vehicle(String name,int speed){
		this.name = name;
		this.speed = speed;
	}
	
	
	
	//기능(method)
	public void start() {
		//score=100;
		System.out.printf("%s 출발합니다. (속도: %d km/h) \n", name, speed);
	}
	public void stop() {
		System.out.printf("%s 멈춥니다.\n", name);
	}
	public void info() {
		System.out.printf("차량명 : %s, 최고속도:%d km/h \n", name, speed);
	}
	
}
