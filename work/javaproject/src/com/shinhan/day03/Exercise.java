package com.shinhan.day03;

import java.util.Scanner;

public class Exercise {

	public static void main(String[] args) {

//		f1();
//		f2();
//		f3();
//		f4();
//		f7();
//		f8();
		f9();

	}

	// 문제9) 학생들의 점수를 입력받고 분석하는 프로그램
	// 		 최고점수 및 평균 점수를 출력
	private static void f9() {
		Scanner sc = new Scanner(System.in);
		int[] scoreArr = null;					// 
		
		boolean isEnd = false;					// 반복문 종료하기위한 변수 생성
		while(!isEnd) {							// ture인 동안 반복
			menuDisplay();						// 메뉴 함수 호출
			int job = sc.nextInt();				// 메뉴 번호 선택 입력
			switch(job) {	
			case 1 ->{							// 사용자가 1번을 누른다면 실행
				System.out.print("학생 수 >>");
				int num = sc.nextInt();			// num 변수에 입력값 저장
				scoreArr = new int[num];		// 자동으로 0으로 초기화 됨
			}
			case 2 ->{							// 사용자가 2번을 누르면 실행
				for(int i = 0; i < scoreArr.length; i++) {	// 배열의 크기 만큼 반복하며 각 배열 공간에 입력값(점수) 저장
					System.out.printf("scores[%d] >>",i);	
					scoreArr[i] = sc.nextInt();	
				}
			}
			case 3 ->{							// 사용자가 3번을 누르면 실행
				for(int i = 0; i < scoreArr.length; i++) {	// 배열에 담긴 각각의 점수 출력
					System.out.printf("scoreArr[%d] : %d\n",i,scoreArr[i]);
				}
			}
			case 4 ->{							// 사용자가 4번을 누르면 실행
				int sum = 0;					// 합계 담을 변수 초기화
				int maxScore = -1;				// 최대값을 담을 변수
				for(int i = 0; i < scoreArr.length; i++) {
					sum += scoreArr[i];			// 반복하며 배열의 누적 합계(총 합)
					maxScore = maxScore < scoreArr[i] ? scoreArr[i] : maxScore;	// 최대값을 추적
				}
				System.out.printf("최고 점수 : %d\n", maxScore);
				System.out.printf("평균 점수 : %3.1f\n",(double)sum/scoreArr.length );
			}
			case 5 ->{isEnd = true;}			// 사용자가 5번을 누르면 isEnd가 true로 설정되고 
			}									// 다시 처음으로 돌아가 !isEnd로 인해 fasle가 되며 반복문 종료
		}
		
	}

	private static void menuDisplay() {
		System.out.println("=============================================");
		System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 |5.종료");
		System.out.println("=============================================");
		System.out.print("선택>>>");
		
	}

	// 문제8) 배열 항목의 전체 합과 평균을 구해 출력(중첩for문)
	private static void f8() {
		int[][] array = { {95, 86}, {83, 92, 96}, {78, 83, 93, 87, 88} };
		int total = 0;
		int count = 0;
		double ave = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				total += array[i][j];
				count++;
			}
		}
		ave = (double)total / count;
		System.out.println("총 합 : " + total);
		System.out.printf("평균 : %.1f", ave);
		
		
	}

	// 문제7) 배열 항목에서 최대값을 출력(for문)
	private static void f7() {

		int[] array = { 1, 5, 3, 8, 2 };
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("배열의 최대값 : " + array[array.length-1]);

	}

	// 문제6) 배열 길이 출력
	private static void f4() {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		System.out.println(array.length);
		System.out.println(array[0].length);

	}

	private static void f3() {
		int[] array1 = { 1, 2, 3 }; // 선언 + 생성 + 할당을 같이하는 경우는 new int[]문장 생략가능

		int[] array2;
		array2 = new int[] { 1, 2, 3 }; //

		int[] array3 = new int[3]; //
		int[][] array4 = new int[3][2]; //

	}

	private static void f2() {
		// 값을 literal
		// literal이 같으면 주소가 같음
		String s1 = "ABC";
		String s2 = "ABC";
		System.out.println(s1.equals(s2));

	}

	private static void f1() {
		int a = 100; // 기본형은 stack에 메모리에 저장된다.
//		int b = null;		// 기본형은 null 할당 불가
		String s = "자바"; // 참조변수는 stack 메모리에 저장, 생성된 객체는 heap에 만들어짐
		String s1 = null; // 객체 참조 변수는 null로 초기화 가능
		Integer c = null;

		System.gc(); // 메모리 정리, 불필요

	}

}
