package com.shinhan.day03;

public class LAB2 {

	public static void main(String[] args) {
//		f_review();
		f_review2();

	}

	private static void f_review2() {
		// 반복문 : for, while, do~while
		
		System.out.println("===for문===");
		for(int i = 0;i <=5 ;i++) {
			System.out.println(i);
		}
		
		System.out.println("===while문===");
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			if(i % 2 == 0) {
				i++;
			}				
			
			
		System.out.println("===do~while문===");
		i = 1;
		do {
			System.out.println(i);
			if(i % 2 == 0) {
				i++;
			}}
			while(i <= 5);
			
		}	
		
	}

	private static void f_review() {
		// 조건문 : 3항연산자 이용, if, switch 반복문 : for, while, do~while
		// 입력된 숫자가 짝수인지, 홀수인지 판별
		int num = 10;
		String result = num % 2 == 0 ? "짝수" : "홀수";
		String result2;
		if (num % 2 == 0) {
			result2 = "짝수";
		} else {
			result2 = "홀수";
		}
		String result3 = "";
		switch (num % 2) {
		case 0:
			result3 = "짝수";
			break;
		case 1:
			result3 = "홀수";
		}
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);

	}

}
