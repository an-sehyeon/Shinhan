package com.shinhan.day06.lab;

public class VehicleTest {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		Car car = new Car("승용차", 180, 15);
		Bus bus = new Bus("시내버스", 100, 40);
		Truck truck = new Truck("화물드럭", 90, 5000);
		
		car.info();
		car.start();
		car.stop();
		
		bus.info();
		bus.start();
		bus.stop();
		
		truck.info();
		truck.start();
		truck.stop();
		
		
	}

}
