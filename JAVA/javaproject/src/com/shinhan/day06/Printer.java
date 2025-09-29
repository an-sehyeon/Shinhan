package com.shinhan.day06;

public class Printer {

	static void println(int data) {
		System.out.println("int값 출력:" + data);
	}
	static void println(boolean data) {
		System.out.println("boolean값 출력:" + data);
	}
	static void println(double data) {
		System.out.println("double값 출력:" + data);
	}
	static void println(String data) {
		System.out.println("String값 출력:" + data);
	}
	
	public static void main(String[] args) {
		 Printer.println(10);
		 Printer.println(true);
		 Printer.println(5.7);
		 Printer.println("홍길동");
		 f1();
	}
	
	
	
	public static void f1() {
		 Printer printer = new Printer();
		 printer.println(10);
		 printer.println(true);
		 printer.println(5.7);
		 printer.println("홍길동");

	}
}














