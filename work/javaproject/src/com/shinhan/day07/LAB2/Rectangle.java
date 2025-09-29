package com.shinhan.day07.LAB2;

public class Rectangle extends Shape implements Resizable {
	
	double width, height;
	
	Rectangle(double width, double heigth) {
		super(4);
		this.width = width;
		this.height = heigth;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return width * height/2;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resize(double s) {
		width = width * s;
		height = height * s;
	}

	
}
