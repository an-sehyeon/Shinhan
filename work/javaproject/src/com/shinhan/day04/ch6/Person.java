package com.shinhan.day04.ch6;

/*
 * 접근지정자(modifier)
 * public : 모든 패키지에서 접근가능
 * progected : 생략 -> 같은 패키지에서만 접근가능
 * private : 
 * */

public class Person {
	// 1. field (instance멤버변수, static(class)변수)
	// instance 멤버변수 : 각각의 instance마다 만들어짐
	// static(class)변수 : 모든 instance들이 공유한다.
	static int numberOfPersons; 		// Person 객체가 생성될 때마다 증가(전체 인구 수)
	int age;
	String name;
	
	// 2. 생성자
	public Person(){
		this(12, "Anonymous");
	}
	
	public Person(int age, String name){
		this.name = name;
		this.age = age;
		numberOfPersons++;
	};
	
	// 3. 메서드, 함수 : 반드시 return 에 대한 정의가 필요
	// return값이 없다면 void로 표시한다.
	public void selfIntroduce() {
		System.out.println("내 이름은"
				+ name
				+ " 이며, 나이는"
				+ age
				+ "살 입니다.");
	
	}
	
	public static int getPopulation() {
		return numberOfPersons;
	}

}
