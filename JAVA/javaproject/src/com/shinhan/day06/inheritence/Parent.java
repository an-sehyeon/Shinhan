package com.shinhan.day06.inheritence;

public class Parent {

	String name;
	int age;
	
	public Parent(){
		System.out.println("부모의 default생성자");
	}

	public Parent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("부모의 arg2개 생성자");
	}
	void print() {
		System.out.println("이름은 " + name);
		System.out.println("나이는 " + age);		
	}
	
}
