package com.shinhan.day04.ch6;

public class CarTest {

	public static void main(String[] args) {

		Car car1 = new Car();
		Car car2 = new Car("그랜져");
		Car car3 = new Car("제네시스","RED");
		Car car4 = new Car("소나타","PINK",300);
		
		
		System.out.println("생성된 car 수 : " + Car.carCount);
		car1.carInfoPrint();
		car2.carInfoPrint();
		car3.carInfoPrint();
		car4.carInfoPrint();
		
		
	}

}
