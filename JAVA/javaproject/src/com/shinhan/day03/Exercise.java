package com.shinhan.day03;

public class Exercise {

	public static void main(String[] args) {
		f6();

	}

	private static void f6() {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int count=0;
		int sum = 0;
		for(int[] arr:array) {
			for(int score:arr) {
				count++;
				sum += score;
			}
		}
		System.out.println("총점:" + sum);
		System.out.println("평균:" + (double)sum/count);
	}

	private static void f5() {
		int[] array = { 1, 5, 3, 8, 2 };
		int max = array[0];

		for (int i = 1; i < array.length; i++) {
			// if(max < array[i]) max = array[i];
			max = Math.max(max, array[i]);
		}
		System.out.println(max);

	}

	private static void f4() {
		int[][] array = new int[][] { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		System.out.println(array.length);
		System.out.println(array[2].length);

	}

	private static void f3() {
		int[] array1 = { 1, 2, 3 }; // 선언+생성+할당을 같이하는 경우는 new int[]문장 생략가능

		int[] array2;
		array2 = new int[] { 1, 2, 3 }; // 선언과 생성을 따로하는 경우는 반드시 new int[]작성한다.

		int[] array3 = new int[3]; // 자동초기화
		int[][] array4 = new int[3][2];// 자동초기화

	}

	private static void f2() {
		// 값을 literal
		// literal이 같으면 주소가 같다.
		String s1 = "ABC";
		String s2 = "ABC";

	}

	private static void f1() {
		int a = 100; // 기본형은 statck에 메모리에 저장된다.
		// int b = null; 기본형은 null을 할당불가
		String s = "자바"; // 참조변수는 statck에 메모리에 저장된다., 생성된 객체는 heap에 만들어진다.
		String s2 = null; // 객체참조변수는 null로 초기화가능
		Integer c = null;

		System.gc(); // 메모리정리 ...불필요하다.
	}

}
