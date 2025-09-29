package com.shinhan.day07.LAB2;

abstract public class Shape {
	int numSides;
	
	public Shape(int numSides){
		this.numSides = numSides;
	}

	public int getNumSides() {
		return numSides;
	}
	
	abstract double getArea();
	
	abstract double getPerimeter();

	
	
}
