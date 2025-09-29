package com.shinhan.day01;

// 자바의 기본형타입 : data저장, 연산 가능, 비교 가능
// Wrapper class = 자바의 기본형타입 + 기능

/*
 * byte => Byte
 * short => Short
 * char => Character
 * int => Integer
 * long => Long
 * float => Float
 * double = Double
 * boolean => Boolean
 * */

public class VariableTest1 {

	public static void main(String[] args) {
		f7();
	}

	private static void f7() {
		boolean v1 = true;
		boolean v2 = false;
		int score = 100;
		// boolean v4 = score >= 90;
		
		// &&는 단축구문, 모두 참이면 참
		// &&는 앞의 결과가 맞으면 뒤에 문장을 수행
		// &&는 앞의 결과가 틀리면 뒤에 문장을 수행하지 않는다.
		boolean v4 = score >= 90 && ++score <= 100;
		
		System.out.println(v4);
		System.out.println(score);
		
		// ||는 하나라도 참이면 참
		// ||는 앞의 겨로가가 맞으면 뒤에 문장을 수행하지 않는다.
		// ||는 앞의 결과가 틀리면 뒤에 문장을 수행한다.
		boolean v5 = score < 90 || ++score <= 100;
		
		
		System.out.println(v5);
		System.out.println(score);
	}

	private static void f6() {
		// 실수값의 기본은 double이다.
		double v1 = 3.12345678901234567890;
		double v2 = 3.123456789f;
		
		System.out.println(v1);
		System.out.println(v2);
		
	}

	private static void f5() {
		// 자바의 리터럴값은 기본이 int
		// L, l 대소문자 무관
		long v1 = 2147483648000L;
		v1++;
		System.out.println(v1);
		
	}

	private static void f4() {
//		int v1 = 2147483647;	// 4byte.. 4기가 저장 가능, 가장 많이 사용
		int v1 = Integer.MAX_VALUE;
		System.out.println(v1);
		v1++; v1++;
		System.out.println(v1);
		
		System.out.println(Integer.bitCount(10));
	}

	private static void f3() {
		char v1 = 'A';
		char v2 = '가';
		char v3 = 65;			// A
		char v4 = 0x0041;		// 16 * 4 + 1 * 1 = 65
		char v5 = 44032;		// 가
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v5);
	}

	private static void f2() {
		short v1 = 32767;
		v1++;
		System.out.println(v1);
	}

	private static void f1() {
		// 변수 : 값은 변할수있다. 값을 저장하기 위한 저장공간 이름
		// 변수타입, 변수이름
		// 변수타입 : data의 성격 (기본형 data type : 정수, 실수, 논리값)
		// 정수 : byte, short, char, int, long
		// 실수 : float, double
		// 논리 : boolean
		// 나머지는 객체
		
		// 1. 변수선언(함수내의 있는 변수는 지역변수이다. 지역변수는 반드시 초기화 후 사용한다.
		// 초기화없이 사용하면 compile error
		byte v1;
		
		// 2. 값 할당
		v1 = 127;
		// 선언 + 할당
		byte v2 = -128;
		
		// 3. 값 사용
		v1--;
		System.out.println(v1);
		System.out.println(v2);
	}

}
