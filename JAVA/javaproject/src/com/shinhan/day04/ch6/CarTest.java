package com.shinhan.day04.ch6;

public class CarTest {

	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car("그랜저");
		Car car3 = new Car("ABC", "black");
		Car car4 = new Car("DDD", "red", 200);
		
		System.out.println(car1.carCount);
		System.out.println(car2.carCount);
		System.out.println(car3.carCount);
		System.out.println(car4.carCount);
		System.out.println(Car.carCount);
		
		
		car1.carInfoPrint();
		car2.carInfoPrint();
		car3.carInfoPrint();
		car4.carInfoPrint();
		

	}

}
