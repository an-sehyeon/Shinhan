package com.shinhan.day05;

/*
 * Modifier : 접근권한 활용방법
 * 활용방법 : static, final,...
 * 
 * =========(class, field, constructor, method)=========
 * 접근 권한은 4가지
 * public 		: 모든 패키지에서 접근가능
 * procected	: 같은 패키지이라면 접근가능, 다른패키지라면 상속받은 경우 접근가능
 * 생략(default) 	: 같은 패키지에서 접근가능
 * private		: 자신의 클래스에서만 접근가능
 * */
public class Computer {
	int a;
	public static int b;
	public static final int c=100;
	
	public String os;
	public int price;
	public Computer(){
		
	}
	public Computer(String os, int price) {
		this.os = os;
		this.price = price;
	}
	
	public void print() {
		System.out.println(os);
		System.out.println(price);
	}

	void print2() {
		System.out.println(os);
		System.out.println(price);
	}
	
	protected void print3() {
		System.out.println(os);
		System.out.println(price);
		print4();
	}
	
	private void print4() {
		System.out.println(os);
		System.out.println(price);
	}
	
	
	
}
