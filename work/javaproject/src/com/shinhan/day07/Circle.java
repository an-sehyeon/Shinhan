package com.shinhan.day07;

public class Circle extends Shape{
	int radius; 	// 반지름
	
	public Circle(int radius){
		this.radius = radius;
	}
	
	public double getArea() {
		return radius * radius*Math.PI;
	}
}
