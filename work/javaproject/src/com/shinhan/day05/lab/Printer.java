package com.shinhan.day05.lab;

public class Printer {
	void println(int data) {
		System.out.println("int값 출력 : " + data);
	}
	
	void println(boolean data) {
		System.out.println("boolean값 출력 : " + data);
	}
	
	
	void println(double data) {
		System.out.println("double값 출력 : " + data);
	}
	
	void println(String data) {
		System.out.println("String값 출력 : " + data);
	}
	
	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
	}
}
