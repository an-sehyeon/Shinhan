package com.shinhan.day08;


public class AnonymousExample {
	public static void main(String[] args) {
		
		Anonymous anony = new Anonymous();
		anony.field.run();
//		anony.field2.run();
		
		anony.method1();
		
		// 매개변수로 넘기기
		anony.method2(() -> System.out.println("람다식으로 paraeter보내기"));
		anony.method2(new Vehicle() {
			
			@Override
			public void run() {
				System.out.println("익명구현class를 파라메터로 보내기");
			}
		});
		
	}
	

}
