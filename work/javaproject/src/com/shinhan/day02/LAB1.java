package com.shinhan.day02;

import java.util.Scanner;

public class LAB1 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		hokeyGraphics('*',4,true);
//		hokeyGraphics('&',6,false);
		f5();

	}

	// 문제5. 입력 받은 수 만큼 '*' 로 직각 역삼각형 출력
	private static void f5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요>>");
		int num = sc.nextInt();
		
		for(int i= 0; i <= num; i++) {
			for(int j = num; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();
		
	}

	// 문제4. isRect 값이 true면 사각형 모양 출력
	//	  isRect 값이 false 이면 삼각형 출력
	private static void hokeyGraphics(char cell, int size, boolean isRect) {
		if(isRect) {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		}else {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < i; j++) {
					System.out.print(cell);
				}
				System.out.println();
			}
			
		}
		
	}

	// 문제3. 입력받은 수가 홀수인 경우 홀수의 총 합
	//    입력받은 수가 짜수인 경우 짝수의 총 합
	private static void f3() {
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력하세요>>");
		int num = sc.nextInt();
		int total = 0;
		int stat;

		stat = num % 2 == 0 ? 0 : 1;
		for (int i = stat; i <= num; i += 2) {
			total += i;
		}
		System.out.println("결과 값 : " + total);
	}

	// 문제2. 문자열을 입력 받아 한 글자씩 증가시키며 출력(대문자 출력)
	private static void f2() {
		Scanner sc = new Scanner(System.in);

		System.out.println("문자열을 입력하세요 : ");
		String input = sc.nextLine().toUpperCase();
		int len = input.length() + 1;

		for (int i = len; i >= 1; i--) {
			System.out.println(input.substring(0, len - i));
		}

	}

	// 문제1. 초기값, 마지막값, 증가분 입력 받은 후 초기값부터 마지막 값까지 증가분씩 값을 증가시키며 각 값들의 총합
	// 		결과가 1000을 넘으면 결과에 2000을 더해주는 프로그램
	private static void f1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("초기값을 정수로 입력하세요 : ");
		int stat = sc.nextInt();
		System.out.print("마지막값을 정수로 입력하세요 : ");
		int end = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요 : ");
		int step = sc.nextInt();

		int result = 0;
		for (int i = stat; i <= end; i += step) {
			result += i;
			if (result >= 1000) {
				System.out.printf("총합은 %d 입니다.", result += 2000);
			}
		}
		System.out.printf("총합은 %d 입니다.", result);

		System.out.print("초기값을 정수로 입력하세요>>");
		int stat2 = sc.nextInt();
		System.out.print("마지막값을 정수로 입력하세요>>");
		int end2 = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요>>");
		int step2 = sc.nextInt();
		int result2 = 0;

		for (int i = stat2; i < end2; i += step2) {
			result2 += i;
		}
		if (result2 > 1000)
			result2 += 2000;

		System.out.printf("총합은 %d 입니다.", result2);

	}
}
