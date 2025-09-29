package com.shinhan.day05.lab;

public class BookTest {
	public static void main(String[] args) {
		//1.배열참조변수선언 + 배열생성, 5개의 연속공간 만들기
	    Book[] b = new Book[5];
		b[0] = new Book("Java Program",30000);
		b[1] = new Book("JSP Program",25000);
		b[2] = new Book("SQL Fundamentals",20000);
		b[3] = new Book("JDBC Program",32000);
		b[4] = new Book("EJB Program",25000);
		
		BookMgr bm = new BookMgr(b);
		bm.printBookList();
		bm.printTotalPrice();
	}
}

