package com.shinhan.day07;

public class Parent {
	
	// 1. feild
	int score;
	
	// 2. constructor -> default 생성자는 정의없을때만 컴파일시 만들어진다.
	public Parent(int score) {
		this.score = score;
		System.out.println("Parent의 default 생성자");
	}
	
	// 3. method
	void info() {
		System.out.println("부모의 info메서드 score = " + score);
	}
}
