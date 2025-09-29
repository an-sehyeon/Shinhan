package com.shinhan.day06.lab2;

public class Circle extends Shape {

	
	double radius;
	double circumference;
	
	public Circle(String color, int radius) {
		super(color, "Circle");
		this.radius = radius;
	}

	public double getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}
	
	@Override
	public  double calculateArea() {
		return radius*radius*Math.PI;
	}

	@Override
	public  double calculatePerimeter() {
		circumference = 2*Math.PI*radius;
		return circumference;
	}
	
}
