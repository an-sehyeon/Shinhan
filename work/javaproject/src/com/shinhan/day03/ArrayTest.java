package com.shinhan.day03;

import java.util.Arrays;

// 명령행 매개변수 : 명령줄에서 실행시 해당 프로그램에 들어오는 argument
// args에 매개변수 주는 방법 : run > run configurations > argument 값 입력

public class ArrayTest {

	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("매개변수로 2개의 정수를 입력하세요>>");
			return;			// 자바 가상 머신으로 리턴, 프로그램 종료
		}
		
		// 명령행 매개변수로 두 정수를 입력받아 4칙연산 수행
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		System.out.printf("%d + %d = %d\n", num1, num2, num1+num2);
		System.out.printf("%d - %d = %d\n", num1, num2, num1-num2);
		System.out.printf("%d x %d = %d\n", num1, num2, num1*num2);
		System.out.printf("%d / %d = %d\n", num1, num2, num1/num2);
		
//		f1();
//		f2();
//		f3();
//		f4();
	}

	private static void f4() {
		String[] arr = {"자바", "데이터베이스", "웹", "프레임워크"};		// new String[] 생략가능
		
		System.out.println(arr.length); 							// 배열의 길이는 length 속성 이용
		
		System.out.println(Arrays.toString(arr));
		
		// 향상 for, 확장 for => 배열, Collection(List, set, Map)
		for(String s:arr) {	System.out.println(s); }				// 반복자(iterator)를 이용
			
	}

	private static void f3() {
		// 선언 + 생성 + 초기화
		int[] arr = {100,90,60,40,80};		// 배열의 개수를 적지 않아야 함.
		int[] arr2;
		arr2 = new int[] {100,90,60,40,80};	// new int[]부분은 생략불가
		for(int i = 0; i < arr.length; i++) {
			System.out.println(i + "번째 = " + arr[i]);
		}
		
		
	}

	private static void f2() {
		// 선언 + 생성
		int[] arr1 = new int[5];			// {0,0,0,0,0}
		
		// 배열 사용
		arr1[0] = 100;
		for(int i = 0; i < arr1.length; i++) {
			System.out.println(i + "번째 = " + arr1[i]);
		}
		
		
	}

	private static void f1() {
		// 배열 : 같은 타입, 값 여러개, 연속공간, 접근은 첨자 이용
		// 1. 배열 참조 변수 선언
		int[] arr1 = null;
		char arr2[];
		double[] arr3 = new double[3];		// 선언 + 생성
		boolean[] arr4 = new boolean[4];
		
		// 2. 배열 생성(생성하지 않으면 사용불가), 반드시 배열의 갯수 지정
		arr1 = new int[3];					// 3개의 int타입의 연속 공간 생성, 자동 초기화 됨.
											// 정수 > 0, char > ' ', 실수 > 0.0, boolean > false
		arr2 = new char[3];
		
		// 3. 배열 사용
		System.out.println(arr1[0]);
		System.out.println("*" + arr2[0] + "*");
		System.out.println(arr3[0]);
		System.out.println(arr4[0]);
	}

}
