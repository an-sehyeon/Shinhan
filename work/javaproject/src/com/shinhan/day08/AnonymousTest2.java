package com.shinhan.day08;

public class AnonymousTest2 {

	public static void main(String[] args) {
		
		// 1. 구현class 사용하기
		work(new RemoteA(),10,20);
		work(new RemoteB(),10,20);
		
		work(new RemoteInterface() {
			@Override
			public String buttonClick(int a, int b) {
				return "익명구현 class ==> " + (a*b);
			}},10,20);
			
		// 람다표현식
		RemoteInterface f = (aa,bb) ->"람다표현식 사용 -> "+(aa/bb);
		work(f,10,5);
	}
	
	public static void work(RemoteInterface remote, int num1, int num2) {
		String result = remote.buttonClick(num1, num2);
		System.out.println(result);
		System.out.println("--------------------------");
	}

}
