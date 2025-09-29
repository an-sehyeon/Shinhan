package com.shinhan.day01;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

//>java Car

//class:자바프로그램은 class들로 만들어진다.
//변수 + 메서드 
public class Car {
    //1.field(변수, 속성, 특징)
	String model;
	int price;
	//2.생성자(constructor)메서드
	Car(){
		System.out.println("4.Car의 기본생성자");
	}
	//3.일반메서드
	void go() {
		System.out.println(model + "자동차가 간다");
	}
	//4.block
	static{
		System.out.println("1.car가 메모리에 올라올때 1번 실행된다.");
	}
	{
		System.out.println("3.car가 생성시마다  실행된다.");
	}
	//5.inner class
	class CarHandle{
		
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("2.Car의 main시작");
		
		Car c1 = new Car();
		Car c2 = new Car();
		c1.model = "제네시스";
		c2.model = "그랜져";
		c1.go();
		c2.go();
		
		 
	}
	
	
	
	
	
}







