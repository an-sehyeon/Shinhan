package com.shinhan.day06.lab;

// final class는 상속불가
// final field는 수정불가
// final method는 재정의 불가
public class Vehicle {
	private String name;
	private int speed;
	
	
	public Vehicle(String name, int speed) {
		this.name = name;
		this.speed = speed;
	}
	
	public void start() {
		System.out.println(name + " 출발합니다. (속도 : " + speed + "km/h)\n");
	}
	
	public void stop() {
		System.out.printf("%s 멈춥니다.\n",name);
	}
	
	public void info() {
		System.out.printf("차량명: %s, (최고속도 : %dkm/h)",name,speed);
	}

	
	
	
	
}
