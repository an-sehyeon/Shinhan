package com.shinhan.day05;


//final : 최종을 의미, 한번초기화하고 변경불가 
public final class Book {

	String title;
	int price;
	
	//1.final field:선언시 또는 생성시에만 초기화
	final String author1="김작가";
	final String author2;
	
	
	//상수(static final) : 이 class의 모든 Object가 같은 값을 가지고 변경불가 
	//선언시에만 값할당이 가능하다. 
	//일반적으로 이름은 대문자로 쓴다. 
	static final String PUBLISHER = "신한출판사";
	static final double PI = 3.141592;
	
	
	
	public Book() {
		this.author2 = "아무개";
		//PUBLISHER = "";
		//PI = 3.14;
		
	}
	public Book(String title, int price, String author2) {
		super();
		this.title = title;
		this.price = price;
		this.author2 = author2;
	}
	void updateAuthor(String author2) {
        //final field는 값 할당후 변경불가 
		//this.author2 = author2;
	}
	
	
	//2.final method...재정의불가(자식의 부모의 기능을 재정의 불가) 
	final void display() {
		System.out.println("Book의 display method이다.");
	}
	
	//3.final class .... 상속불가 
}
