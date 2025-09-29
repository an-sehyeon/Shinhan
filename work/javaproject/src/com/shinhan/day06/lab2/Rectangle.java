package com.shinhan.day06.lab2;

public class Rectangle extends Shape {
	int width;
	int height;

	public Rectangle(String color, int width, int height) {
		super(color, "rectangle");
		this.width = width;
		this.height = height;
	}

	@Override
	public double calculateArea() {
		
		return width * height;
	}

	@Override
	public double calculatePerimeter() {
		
		return 2 * (width + height);
	}

}
