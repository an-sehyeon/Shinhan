package com.shinhan.day02;

//반복문
public class LoopingTest {

	public static void main(String[] args) {
		f8();

	}
	//expression방식 
	private static void f8() {
		String grade = "B";
		int score1 = 0;
		switch (grade) {
			case "A" -> {score1 = 100;}
			case "B" -> {int result = 100 - 20;score1 = result;}
			default -> {score1 = 60;}
		}
		System.out.println(score1);
	}
    //statement방식
	private static void f7() {
		String grade = "B";
		int score1 = 0;
		switch (grade) {
		case "A":
			score1 = 100;
			break;
		case "B":
			int result = 100 - 20;
			score1 = result;
			break;
		default:
			score1 = 60;
		}
		System.out.println(score1);
	}

	private static void f6() {
		// switch 문에서 사용할 수 있는 변수의 타입은 int, double이 될 수 있다.(X) double불가
		String data = "10";
		switch (data) {
		case "10":
			System.out.println("합격");
			break;

		default:
			System.out.println("불합격");
			break;
		}

	}

	private static void f5() {
		// 구구단

		labelA: for (int gop = 1; gop <= 9; gop++) {
			for (int dan = 2; dan <= 9; dan++) {
				// if(dan==4) continue;
				// if(dan==4) continue labelA;
				if (dan == 4)
					break;
				// if(dan==4) break labelA;
				System.out.printf("%d X %d = %d\t", dan, gop, dan * gop);
			}
			System.out.println();
		}
	}

	private static void f4() {
		// ;(세미콜론), :(콜론), ,(콤마), ~(틸드), ^(캐럿)
		for (int i = 1; i <= 10; i++) { // 1~10까지 반복 , i<=10조건식이 참인동안 반복한다.
			// if(i%5==0) break; //조건이 맞으면 반복중단
			if (i % 5 == 0)
				continue; // 아래문장들을 무시하고 반복은 계속한다.
			System.out.println("i=" + i);
			System.out.println("-----------------");
		}
		System.out.println("f4 END");

	}

	private static void f3() {
		int su = 1;
		int total = 0;
		// for, while, do~while
		do {
			System.out.println("su=" + su);
			total += su;
			su++;
		} while (su <= 10);
		System.out.println("do~while문 종료후 su=" + su);
		System.out.println("1~10 합계:" + total);

	}

	private static void f2() {
		int su = 1;
		int total = 0;
		// for, while, do~while
		while (su <= 10) {
			System.out.println("su=" + su);
			total += su;
			su++;
		}
		System.out.println("while문 종료후 su=" + su);
		System.out.println("1~10 합계:" + total);

	}

	private static void f1() {
		int su;
		int total = 0;
		// for, while, do~while
		for (su = 1; su <= 10; su++) {
			System.out.println("su=" + su);
			total += su;
		}
		System.out.println("for문 종료후 su=" + su);
		System.out.println("1~10 합계:" + total);

	}

}
