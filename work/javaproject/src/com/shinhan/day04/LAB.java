package com.shinhan.day04;

import java.util.Scanner;

public class LAB {

	// 1. field(속성, 특징, 변수) = 해당 class의 모든 메서드에서 공유하는 변수
	static Scanner sc = new Scanner(System.in);

	// 모든 함수에서 사용하기 위한 변수 생성
	static String[] nameArr; // 이름
	static int[] scoreArr; // 점수
	static Grade[] gradeArr; // 학점

	public static void main(String[] args) {

		boolean isEnd = true;

		while (isEnd) {
			menuDisplay();
			int job = sc.nextInt();
			switch (job) {
			case 1 -> {f_insert();}
			case 2 -> {f_select();}
			case 3 -> {f_MaxScore();}
			case 4 -> {f_getAverage();}
			case 5 -> {f_targetScore();}
			case 6 -> {isEnd = false;}
			default -> {System.out.println("지원되지 않는 기능입니다.(준비중)");}
			}

		}
		System.out.println("========프로그램 종료=========");
	}

	private static void f_targetScore() {
		int score = numberCheck("기준 점수를 입력하세요 : ");
		
		System.out.printf("=== %d점 이상 학생 목록 ===\n",score);	
		
		for (int i = 0; i < scoreArr.length; i++) {
			
			if(scoreArr[i] >= score) {
				studentDisplay(i);
			}
		}
	}

	private static void studentDisplay(int i) {
		System.out.printf("이름 : %s - 점수 : %d - 등급 : %s\n", nameArr[i], scoreArr[i], gradeArr[i]);
	}

	private static void f_getAverage() {
		if (!nullcheck())return;
		double sum = 0;

		for (int i = 0; i < scoreArr.length; i++) {
			sum += scoreArr[i];
		}
		System.out.printf("전체 학생의 평균 점수 : %.2f\n", sum / scoreArr.length);

	}

	private static void f_MaxScore() {
		if (!nullcheck())return;
		String maxName = null;
		int maxScore = -1;
		for (int i = 0; i < nameArr.length; i++) {
			if (scoreArr[i] > maxScore) {
				maxScore = scoreArr[i];
				maxName = nameArr[i];
			}
		}
		System.out.printf("최고 점수를 받은 학생 : %s (%d)점\n", maxName, maxScore);
	}

	private static void f_select() {
		if (!nullcheck())return;
		System.out.println("=== 학생 성적 목록 ===");
		for (int i = 0; i < nameArr.length; i++) {
			studentDisplay(i);
		}
	}
	
	private static void f_insert() {
		int count = numberCheck("학생수를 입력하세요");
		

		// 배열 생성 후 사용가능
		nameArr = new String[count];
		scoreArr = new int[count];
		gradeArr = new Grade[count];
		sc.nextLine(); 		// next(학생수입력)와 nextLine(학생이름 + 점수 입력)이 섞이기 때문에 학생수 입력후 enter는 버림.
		for (int i = 0; i < count; i++) {
			System.out.printf("%d번째 학생 이름과 점수를 입력하세요 > ", i + 1);
			String data = sc.nextLine();		// 단어를 읽는다. 기본은 공백으로 구분
			String[] arr = data.split(",");
			nameArr[i] = arr[0];
			scoreArr[i] = Integer.parseInt(arr[1].trim());
			gradeArr[i] = getGrade(scoreArr[i]);
		}

	}

	private static boolean nullcheck() {
		if (nameArr == null) {
			System.out.println("학생정보가 아직 입력되지 않아서 본 서비스 제공 불가합니다.");
			return false;
		}
		return true;
	}

	private static int numberCheck(String message) {
		int count = 0;
		while (true) {
			System.out.print(message);
			if (sc.hasNextInt()) {
				count = sc.nextInt();
				break;
			}
			System.out.println("반드시 숫자로 입력하세요");
			sc.next();
		}

		return count;
	}


	private static Grade getGrade(int score) {
		Grade result = null;
		switch (score / 10) {
		case 9, 10 -> result = Grade.A;
		case 8 -> result = Grade.B;
		case 7 -> result = Grade.C;
		case 6 -> result = Grade.D;
		default -> result = Grade.F;
		}

		return result;
	}

	// 함수는 문장들의 묶음, 재사용
	private static void menuDisplay() {
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("1.학생수(이름,점수입력)  2.성적목록  3.최고 점수를 받은 학생 찾기  4.평균 점수  5.특정 점수 이상 학생  6.종료");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.print("선택 >> ");
	}
}
