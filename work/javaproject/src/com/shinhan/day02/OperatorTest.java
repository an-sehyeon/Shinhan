package com.shinhan.day02;

import java.util.Scanner;

public class OperatorTest {
	

	public static void main(String[] args) {
//		call();
//		call2();
//		call3();
//		call4();
//		call5();
//		call6();
//		call7();
		call8();
	}

	private static void call8() {
		// 산술 > 비교 > 논리(&& > ||) > 대입
		int a = 100;
		int b = 200;
		
		boolean v1 = 10 + 20 - 30 < 100 && ++a > b;
		
		System.out.println(v1);
		System.out.println(a);
	}

	private static void call7() {
		int v1 = 11;
		// 삼항 연산자
		String result = v1%2==0?"짝수":v1>=10?"홀수.10이상":"홀수.10이하";
		
		// 조건문
		String result2;
		if(v1%2==0) {
			result2 = "짝수";
		}else {
			if(v1>=10) {
				result2 = "홀수.10이상";
			}else {
				result2 = "홀수.10이하";
			}
		}
		System.out.println(result);
		System.out.println(result2);
	}

	private static void call6() {
		int v1 = 10;
		int v2 = 7;
		
		System.out.printf("%4s\n",Integer.toBinaryString(v1));
		System.out.printf("%4s\n",Integer.toBinaryString(v2));
		System.out.println(v1 & v2);			// 1010 & 0111 ==> 0010 = 2
		
		System.out.println(v1 >> 2);
		
		v1++;
		++v1;
		v1 = v1+1;			// 단순 대입 연산자
		v1 += 1;			// 복합 대입 연산자
		
		System.out.println(v1);
	}

	private static void call5() {
		int v1 = 100;
		int v2 = 100;
		
		System.out.println(v1 >= 100 && ++v2 >= 100);
		System.out.println(v2);
		
	}

	private static void call4() {
		// byte, short, char, int, long, float, double, boolean
		int v1 = 100;
		int v2 = 100;
		System.out.println(v1 == v2);
		
		// Sgring은 고정 문자열, 변경불가
		// 주소 같음
		String s1 = "자바";
		String s2 = "자바";
		// 주소 다름
		s1 = s1 + "프로그램";
		s2 = s2 + "프로그램";
		System.out.println(System.identityHashCode(s1));		// 주소 확인
		System.out.println(System.identityHashCode(s2));
		System.out.println(s1 == s2);							// 주소가 같다. 주소가 달라짐
		
		System.out.println(s1.equals(s2)); 						// 내용을 비교

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println(sc1 == sc2); 						// 주소 비교 > 주소 다름
		
		// "=="는 기본형은 값을 비교, 기본형이 아니면 주소를 비교
		
	}

	private static void call3() {
		int v1 = 10;
		double v2 = 0;
		System.out.println(v1/v2);		// 0.0으로 나누면 무한대 = Infinity
		System.out.println(v1%v2);		// 0.0으로 나누면 몫은 NaN
		
		// 조건문으로 연산가능한지 check
		if(Double.isInfinite(v1/v2)) {
			System.out.println("0.0으로 나누면 무한대");
		}else {
			System.out.println(v1/v2);		
		}

		if(Double.isNaN(v1%v2)) {
			System.out.println("0.0으로 나누면 몫은 NaN(Not a Number)");
		}else {
			System.out.println(v1%v2);		
		}
		
	}

	private static void call2() {
		int v1 = 10;
		int v2 = 0;
		System.out.println(v1/v2); 		// 정수는 0으로 나눌수 없다. Exception 발생
	}

	private static void call() {
		int data = 10;
		
		System.out.println(++data); 	// 전위연산자, 증가하고 출력하기
		System.out.println(data++); 	// 후위연산자, 출력하고 증가하기
		System.out.println(data);
	}

}
