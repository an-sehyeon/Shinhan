package com.shinhan.day07;

import com.shinhan.day06.lab.Vehicle;

public class VehicleChild extends Vehicle{

	VehicleChild(){
		super("", 0);
	}
	void method1() {
		start();
		stop();
		info();
	}
	
	
}

class Test{
	void f1() {
		Vehicle aa = new Vehicle("", 0);
		aa.info();
	}
}
