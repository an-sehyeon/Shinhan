package com.shinhan.day05;

//자바의 패키지(package) : 관련있는 class들의 묶음 
//window의 폴더 
//unix의 디렉토리 



public class FinalTest {

	
	
	//instance method : static, non-static사용기가능 
	public void display() {
		f2();
		System.out.println(getClass().getName());
	}
	
	//static method : 객체생성없이 사용가능 
	public static void main(String[] args) {
		
		new FinalTest().display(); 

	}
	//static method : 객체생성없이 사용가능 
	private static void f2() {
		//상수는 값 변경불가 
		//Math.PI = 3.14;
		System.out.println(Math.PI);
		 
		
		
	}

	private static void f1() {
		Book b1 = new Book("자바다", 38000, "박작가");
		System.out.println(b1.title);
		System.out.println(b1.price);
		System.out.println(b1.author1);
		System.out.println(b1.author2);
		
		b1.display();
		//Book.PUBLISHER = "";
		System.out.println(Book.PUBLISHER);
		
	}

}


