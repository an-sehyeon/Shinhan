package com.shinhan.day10;

public class PrintService {
	
	@PrintAnnotation()
	public void method1() {
		System.out.println("실행 -- method1() ");
		
	}
	
	@PrintAnnotation(value = "*")
	public void method2() {
		System.out.println("실행 -- method2() ");
	}
	
	@PrintAnnotation(value = "#", number = 10)
	public void method3() {
		System.out.println("실행 -- method3() ");
	}
	
	@PrintAnnotation(value = "@", number2 = 20)
	public void method4() {
		System.out.println("실행 -- method4() ");
	}

}
