package com.shinhan.day06;

public class SingleToneTest {

	public static void main(String[] args) {
		LoginServlet a = LoginServlet.getInstance();
		LoginServlet b = LoginServlet.getInstance();
		
		System.out.println(a == b);
		
		ShopService c1 =ShopService.getInstance();
		ShopService c2 =ShopService.getInstance();
		System.out.println(c1 == c2?"같다":"다르다");

	}

}
