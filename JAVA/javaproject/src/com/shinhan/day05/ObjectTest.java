package com.shinhan.day05;

public class ObjectTest {

	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car("ABC");
		Car c3 = new Car("ABC", "black");
		Car c4 = new Car("ABC", "black", 2000);

		System.out.println(c1.toString()); //주소출력
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
	}

}
