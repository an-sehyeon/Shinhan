package com.shinhan.day07.LAB2;

public class RectTriangle extends Shape{
	double width , heigth;

	public RectTriangle(double width, double heigth) {
		super(3);
		this.width = width;
		this.heigth = heigth;
	}

	@Override
	double getArea() {
		return width * heigth/2;
	}

	@Override
	double getPerimeter() {
		return width + heigth + Math.sqrt((width * width + heigth * heigth));
	}

}
