package com.shinhan.day02;

import java.util.Scanner;

// 구동 순서
// 1. java > LAB2
// 2. JVM이 class load한다. > class는 method영역으로 돌아감 > static이 처음부터 메모리에 load 
// 		- non-static은 load 되지 않고, new에 의해서 생성되면 load 된다.
// 		- static은 static만 호출 가능

public class LAB2 {

	public static void main(String[] args) {

//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
		f8();

	}

	// 8번. 두 수의 최대공약수
	private static void f8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력값");
		
		// 한 줄로 입력된 문자열을 쉼표 기준으로 분리하여 문자열 배열로 저장
		String[] input = sc.nextLine().split("[, /]");		// 콤마, 공백, 슬래시를 구분자로 나눠 값을 입력 받음

		if (input.length == 2) {							// 배열 길이가 2가 맞는지 확인
			int a = Integer.parseInt(input[0].trim());		// 첫 번째 문자열 정수로 변환, 양쪽 공백 제거
			int b = Integer.parseInt(input[1].trim());		// 두 번째 문자열 정수로 변환, 양쪽 공백 제거

			System.out.println("최대 공약수 : " + gcd(a, b));
		} else {											// 배열 길이가 2가 아니면 오류 메시지 출력
			System.out.println("다시 제대로 입력하세요");
		}
	}

	public static int gcd(int a, int b) {
		// 방법1)
//		while (b != 0) {									// b가 0이 될 때까지 반복
//			a = a % b;										// a를 b로 나눈 나머지를 a에 저장
//			int temp = a;									// 나머지 값을 temp에 저장
//			a = b;											// b 값을 a로 이동
//			b = temp;										// 나머지 값을 b로 이동 (다음 반복을 위해)
//		}
//		return a;											// b가 0이 되었을 때 a가 최대 공약수
		
		// 방법2)
		int min = Math.min(a , b);
		int result = 1;
		for(int i = min; i >= 1; i--) {
			if(a % 1 == 0 && b % i == 0) {
				result = i;
				break;
			}
		}
		System.out.println(result);
		return result;
	}
	

	// 7번. 해당 월의 날짜 수
	private static void f7() {
		Scanner key = new Scanner(System.in);

		System.out.print("월 입력 : ");
		int month = key.nextInt();

		numDay(month);

		key.close();
	}
	
	public static void numDay(int mon) {

		switch (mon) {
		case 4, 6, 9, 11:
			System.out.printf("numDays(%d) -> %d", mon, 30);
			break;
		case 1, 3, 5, 7, 8, 10, 12:
			System.out.printf("numDays(%d) -> %d", mon, 31);
			break;
		case 2:
			System.out.printf("numDays(%d) -> %d", mon, 28);
			break;
		default:
			System.out.printf("%d월은 존재하지 않습니다. 다시 입력하세요", mon);
		}
	}

	// 6번. 윤년 계산
	private static void f6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("해당 연도를 입력하세요 : ");
		int year = sc.nextInt();

		System.out.print("해당 월을 입력하세요 : ");
		int month = sc.nextInt();

		int lastDay = 0; 										// 말일을 저장할 변수

		switch (month) { 										// 월에 따라 말일을 결정
		case 1,3,5,7,8,10,12 -> {lastDay = 31;}					// 말일이 31일인 달
		case 4,6,9,11 -> {lastDay = 30;}						// 말일이 30일인 달
		case 2 -> {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {// 4의 배수이면서 100의 배수가 아니거나 400의 배수인 경우는 윤년
				lastDay = 29; 									// 윤년이면 말일이 29일
			} else {
				lastDay = 28; 									// 윤년이 아니면 말일이 28일
			};													// 2월은 윤년 여부에 따라 말일이 28일 또는 29일
			} 													
		default ->{ 											// 잘못된 월을 입력할 때 처리
			System.out.println("1~12월 사이의 올바른 월을 입력하세요ㅡㅡ");
			}
		}
		System.out.printf("%d년 %d월의 말일은 %d일 입니다.", year, month, lastDay);

		sc.close();
	}

	// 5번. 수열에서의 합
	private static void f5() {
		int num1 = 1; 											// 첫 번째 항
		int num2 = 1; 											// 처음 증가량
		int sum = 0; 											// 누적 합계 담을 변수

		for (int i = 1; i <= 15; i++) { 						// 15번 반복
			sum += num1; 										// 현재 항을 합계에 더함
			num1 += num2; 										// 다음 항 : 현재 항 + 증가량
			num2++; 											// 반복될때마다 증가량 1씩 증가
		}
		System.out.println("15번까지의 합 : " + sum);

	}

	// 4번. 정수의 배수의 개수와 합
	private static void f4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		int count = 0; 											// 배수의 개수를 저장할 변수
		int total = 0; 											// 배수의 합을 저장할 변수

		// 1부터 1000까지 반복하며 num의 배수를 찾음
		// 방법 1)
//		for (int i = num; i <= 1000; i++) {
//			if (i % num == 0) { 								// i가 num의 배수라면
//				count++; 										// 배수 개수 증가
//				total += i; 									// 배수 합 누적
//			}
		
		// 방법 2)
		for (int i = num; i <= 1000; i+=num) {					// i+=num : num값 만큼 증가 하면 num의 배수
			count++;
			total+=i;
		}
		System.out.printf("%d의 배수 개수 = %d\n", num, count);
		System.out.printf("%d의 배수 합 = %d\n", num, total);

		sc.close();
	}

	// 3번. 팩토리얼 계산
	private static void f3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요 : ");
		int n = sc.nextInt();
		int result = 1; 										// 결과를 저장할 변수, 곱셈이므로 1로 초기화

		if (n < 2 || n > 9) { 									// n이 2보다 작거나 9보다 크면 오류 메시지 출력
			System.out.println("잘못된 숫자가 입력되었습니다.");
		} else {
			for (int i = 1; i <= n; i++) { 						// 1부터 n번까지 반복
				result *= i; 									// 반복될때마다 result에 현재 i값을 곱한 후 누적
				System.out.printf("%d ! = %d\n", i, result);
			}
		}

		sc.close();
	}

	// 2번. 소수 계산
	private static void f2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("2~100 사이의 숫자를 입력하세요 : ");
		int num = sc.nextInt();

		if (num < 2 || num > 100) { 						// 입력값이 2보다 작거나 100보다 크면 오류 메시지 출력 후 종료
			System.out.println("좋게 말할때 똑바로 입력하세요.");
		} else { 											// 범위 안에 들어 온다면 소수 판별 실행
			boolean isPrime = true; 						// 소수 여부를 저장할 변수, true로 초기화

			for (int i = 2; i <= Math.sqrt(num); i++) { 	// 2부터 제곱근까지 반복
				if (num % i == 0) { 						// num이 i로 나누어 떨어진다면 소수 아님
					isPrime = false; 						// 소수가 아니라면 isPrime을 false로 저장
					break; 									// 반복문 종료
				}
			}

			if (isPrime) { 									// 현재 isPrime값이 true라면? 소수
				System.out.println(num + "는(은) 소수입니다.");
			} else { 										// 현재 isPrime값이 false라면 소수가 아님
				System.out.println(num + "는(은) 소수가 아닙니다.");
			}
		}

		sc.close();

	}

	// 1번. 구구단
	private static void f1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요 >>");
		int num = sc.nextInt();

		if (num < 2 || num > 9) { 							// 입력값이 2보다 작거나 9보다 크면 잘못된 값으로 간주
			System.out.println("잘못된 숫자가 입력되었습니다.");
		} else { 											// 정상적인 범위에 해당한다면 해당 단의 구구단을 출력
			for (int i = 1; i < 10; i++) { 					// i는 1부터 9까지 증가하며 반복 (곱하는 수)
				System.out.printf("%d * %d = %2d\n", num, i, num * i); // num(단)의 i번째 곱셈 결과 출력
			}
			sc.close();
		}
	}

}
