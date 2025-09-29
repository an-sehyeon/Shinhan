package com.shinhan.day04.ch6;

// Class : 설계도, template, object를 생성하기 위한 틀
// field + method

// public은 모든 패키지에서 접근이 가능함을 의미.
// class는 5가지 구성요소를 정의할 수 있다. 필수인것은 없다.
public class Book {
	
	// 1. field(특징, 변수)
	String title;
	String author;
	int price;
	
	// 2. contructor method(생성자) 
	//    값을 초기화하는 것이 목적
	//    생성자 정의가 없으면 컴파일타임에 자동으로 기본생성자를 만듬
	// 	  생성자는 return을 가질 수 없다.
	// 	  매개변수로 받은 값을 field에 할당(초기화)
	
	
	// 생성자 OverLoading
	// 이름은 같고, 매개변수 사양(개수,타입)이 다르면 여러개 정의 가능
	// 매개변수이름과 field 이름이 같아서 충돌됨
	// 구별하기위해서 객체 자신을 this로 접근한다.
	// this는 이 class를 이용해서 만든 객체(실체)
	// 하나의 생성자가 같은 이름의 다른 생성자를 호출 : this() 
	Book(){
		this(null,null,0);
	}
	
	Book(String title, String author, int price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	Book(String title,int price){
		this(title, null, price);
	}
	
	Book(int price, String author){
		this(null, author, price);
	}
	
	Book(int price){
		this("미제","미상",price);
	}
	
	// 3. 일반 method
	void bookInfo() {
		System.out.println("책제목 : " + title);
		System.out.println("저자 : " + author);
		System.out.println("가격 : " + price);
		System.out.println("~~~~~~~~~bookInfo End~~~~~~~~~~~~");
	}
	
	// 4. block : {  }

	// 5. Inner Class : 클래스안에 클래스
	
}
