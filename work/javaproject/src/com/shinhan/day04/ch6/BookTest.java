package com.shinhan.day04.ch6;

public class BookTest {
	public static void f2(String[] args) {
		String s1 = "자바";
		String s2 = new String("자바");
		
		char[] arr = {'A','B','C','자','바','다'};
		String s3 = new String(arr);
		System.out.println(s3.toLowerCase()); 		// 소문자로 변경
		
		
		
	}
	
	
	public static void main(String[] args) {
		// 객체 선언 + 생성
		
		Book[] arr = new Book[5];
		
		
		arr[0] = new Book();
		arr[1] = new Book("SQL배우기", "홍길동", 32000);
		arr[2] = new Book("WEB배우기",23000);
		arr[3] = new Book(23000,"다빈치");
		arr[4] = new Book(70000);
		
		arr[0].title = "이것이 자바다";
		arr[0].author = "신용권";
		arr[0].price = 38000;
		System.out.println("==================");
		
		for(Book b:arr) 
		{print(b); 
		b.bookInfo();
		}
		
	}

	private static void print(Book b1) {
		System.out.println("1.제목 : " + b1.title);
		System.out.println("1.작가 : " + b1.author);
		System.out.println("1.가격 : " + b1.price);
		System.out.println("==================");
	}


	public static void f1(String[] args) {
		
		// 기본형 변수
		int i = 0;
		
		// 1. 객체 참조 변수 선언
		Book b1;
		
		// 2. 객체 생성 > field가 자동으로 초기화
		b1 = new Book();
		
		// 3. 객체 사용
		System.out.println("제목 : " + b1.title);
		System.out.println("작가 : " + b1.author);
		System.out.println("가격 : " + b1.price);
		System.out.println("지역변수는 반드시 초기화 : " + i);
			
	}

}
