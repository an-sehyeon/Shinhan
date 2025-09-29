package com.shinhan.day03;

import java.util.Scanner;

//>java LAB2
//JVM이 class load한다. class는 method영역으로 들어간다. static이 처음부터 메모리에 load된다. 
//   non-static은 load되지않고 new에 의해서 생성되면 load된다.    

public class LAB2 {
	//field
	static Scanner sc = new Scanner(System.in);
	
   //method
	public static void main(String[] args) {
		f3();

		sc.close();
		System.out.println("==========main end========");
	}

	private static void f3() {
		
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. ");
		int su = sc.nextInt();
		if (su < 2 || su > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			sc.close();
			return; // 호출한 곳으로 돌아간다.
			// System.exit(0); //즉시 정상종료 ....main으로 돌아가지않는다.
		}
		for (int i = 1; i <= su; i++) {
			int result = 1;
			for (int j = 1; j <= i; j++) {
				result *= j;
			}

			System.out.printf("%d ! = %d\n", i, result);
		}

		/*
		 * 문제3. 임의의 숫자를 입력 받아 아래와 같은 실행 결과가 나타나는 프로그램을 작성하십시오. 정수 n의 팩토리얼(factorial)은
		 * 1부터 n까지의 모든 정수를 곱한 것으로 n!로 표시합니다. 단 2보다 작거나 9보다 큰 정수가 입력될 경우에는 “잘못된 숫자가
		 * 입력되었습니다.”라는 경고 메시지를 출력하고 프로그램을 종료합니다.
		 * 
		 */

	}

	private static void f2() {

		System.out.print("2 ~ 100사이의 정수를 입력하세요. :");
		// 판별
		boolean isPrime = true;
		int su = sc.nextInt();
		for (int i = 2; i < su; i++) {
			if (su % i == 0) {
				isPrime = false;
				break;
			}
		}
		System.out.println(isPrime ? "소수" : "소수아니다");

		/*
		 * 문제2. 소수란 자신과 1외의 다른 수로는 나누어 떨어지지 않는 정수입니다. 아래와 같이 2~100 사이의 숫자를 입력하면 소수인지 여부를
		 * 판별하는 프로그램을 작성하십시오.
		 * 
		 * 실행 예 1) 2 ~ 100사이의 정수를 입력하세요. : 47 //1~47 47는(은) 소수입니다.
		 * 
		 * 
		 */

	}

	private static void f1() {

		int dan;
		while (true) {
			System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. :");
			dan = sc.nextInt();
			if (dan <= 1 || dan >= 10) {
				continue; // 반복계속
			}
			break; // 반복빠지기
		}

		for (int gop = 1; gop <= 9; gop++) {
			System.out.printf("%d * %d = %2d\n", dan, gop, dan * gop);
		}

		// 문제1. 1보다 크고 10보다 작은 정수를 입력 받아서 아래와 같은 실행 결과가 나타나도록
		// 입력 받은 숫자에 해당하는 구구단을 완성시키는 프로그램입니다.
		// 2보다 작거나 9보다 큰 정수가 입력될 경우에는 “잘못된 숫자가 입력되었습니다.”라는 경고 메시지를 출력하고 프로그램을 종료합니다.
		/*
		 * 1보다 크고 10보다 작은 정수를 입력하세요. : 3 3 * 1 = 3 3 * 2 = 6 3 * 3 = 9 ... 3 * 9 = 27
		 */

	}

	private static void f_review2() {
		// 반복문:for, while, do~while
		System.out.println("===for문======");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);

		}
		System.out.println("===while문======");
		int i = 1;
		while (i <= 5) {
			System.out.println(i);

			i++;

		}
		System.out.println("=== do~while문======");
		i = 1;
		do {
			System.out.println(i);

			i++;

		} while (i <= 5);

	}

	private static void f_review() {
		// 조건문:3항연산자이용, if,switch
		// 입력된 숫자가 짝수인지, 홀수인가?
		int su = 10;
		String result = su % 2 == 0 ? "짝수" : "홀수";
		String result2;
		if (su % 2 == 0) {
			result2 = "짝수";
		} else {
			result2 = "홀수";
		}
		String result3;
		switch (su % 2) {
		default:
			result3 = "짝수";
			break;
		case 1:
			result3 = "홀수";
			break;

		}
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
	}

}
