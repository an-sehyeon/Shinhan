package com.shinhan.day07;

public class Rectangle extends Shape{
	int width, height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
				
	}
	
	public double getArea() {
		return width * height;
	}
}
