package com.shinhan.day04.ch6;

//Korean이라는 class를 이용해서 Object들을 만들예정이다. 설계도를 만드는 중
public class Korean {

	//1.field(변수, 값을 저장하는 목적)
	String nation = "대한민국";
	String name;
	String ssn;
	//2.constructor method....컴파일시에 생성자정의없으면 자동으로 default생성자 만들어줌
	//Overlong지원됨
	Korean(){
		//생성자가 감은이름의 다른 생성자를 호출
		this("아무개", null);
	}
	Korean(String name, String ssn){
		//매개변수로 받은 값을 field에 초기화한다. 
		//매개변수와 field이름이 충돌, 구분하기위해 현재객체를 this
		this.name = name;
		this.ssn = ssn;
	}
	//3.일반 method
	void display() {
		System.out.println("=========한국사람정보==============");
		System.out.println("이름:" + name);
		System.out.println("ssn:" + ssn);
	}
	//4.block
	//5.inner Class
}
