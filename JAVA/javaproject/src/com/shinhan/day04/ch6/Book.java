package com.shinhan.day04.ch6;

//class : 설계도, template, object를 생성하기 위한 틀
//field + method

//public은 모든 패키지에서 접근이 가능함을 의미한다. 
//class는 5가지 구성요소를 정의할수 있다. 필수인것은 없다.
public class Book {

	//1.field(속성, 특징, 변수)
	String title;
	String author;
	int price;
	
	//2.constructor method...
	//값을 초기화하는 것이 목적이다. 
	//생성자정의가 없으면 컴파일타임에 자동으로 기본생성자를 만든다. 
	//생성자는 return을 가질수 없다. 
	
	//생성자의 Overloading 
	//이름은 같고 매개변수 사양(개수,타입)이 다르면 여러개 정의가능 
	//매개변수로 받은 값을 field에 할당한다.(초기화)
	//매개변수이름과 field이름이 같아서 충돌됨 
	//구별하기위해 객체자신을 this로 접근한다.
	//this는 이 class를 이용해서 만든 객체(실체)
	//하나의 생성자가 같은이름의 다른 생성자를 호출 : this() 
	//매개변수가 작은곳에서 많은곳을 호출할까?OK 반대로?
	Book(){
		this(null,null,0);
	}
	Book(String title, String author, int price){
		System.out.println("argument3개 생성자");
		this.title = title;
		this.author = author;
		this.price = price;	
	}
	Book(String title, int price){
		this(title, null, price);
	}
	Book( int price, String author){
		this(null, author, price);
	}
	Book( int price){
		this("미제", "미상", price);
	}
	
	//3.일반 method
	void bookInfo() {
		System.out.println("*책제목:" + title);
		System.out.println("*저자:" + author);
		System.out.println("*가격:" + price);
		System.out.println("~~~~~~bookInfo End~~~~");
	}
	
	//4.block: {  }
	
	//5.Inner Class
}










