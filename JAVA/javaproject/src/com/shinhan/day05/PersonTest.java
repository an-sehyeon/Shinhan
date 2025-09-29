package com.shinhan.day05;

import com.shinhan.day04.ch6.Person;

public class PersonTest {

	public static void main(String[] args) {
		Person p1, p2;
	 
		p1 = new Person();
		p2 = new Person(20, "홍길동");
		
		p1.selfIntroduce();
		p2.selfIntroduce();
		
		int count = Person.getPopulation();
		System.out.println("인구수:" + count);
		
		

	}

}
