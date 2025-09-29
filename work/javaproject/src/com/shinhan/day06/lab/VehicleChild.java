package com.shinhan.day06.lab;

public class VehicleChild extends Vehicle{
	VehicleChild(){
		super("",0);
	}
	void method1() {
		start();
	}
}

class Test{
	void f1() {
		Vehicle aa = new Vehicle("",0);
		aa.info();
	}
}
