package com.shinhan.day02;

// 반복문
public class LoopingTest {

	public static void main(String[] args) {
//		f1();		// for
//		f2();		// while
//		f3();		//  do
//		f4();		// 조건 반복문
//		f5();		// switch
//		f6();		
//		f7();		// switch(statement방식)
//		f8();		// switch(expression방식)
//		f9();		// 연습문제 (1부터 100까지 중 3의 배수 총합 계산)
//		f10();		// 연습문제 
//		f11();		// 연습문제 (랜덤한 두 개의 수의 합이 5가 나오면 멈추는 문제)
//		f12();		// 연습문제 (랜덤한 두 개의 수의 합이 5가 나오면 멈추는 문제)
//		f13();		// 연습문제 
//		f14();		// 연습문제 (별 출력)
		f15();		// 연습문제 (별 반대로 출력)

	}

	
	private static void f15() {
		for(int i = 1; i <= 5; i++) {
		}
	}


	private static void f14() {
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 6-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------------------------");
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}


	private static void f13() {
		
		labelx: for(int x= 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				if(4 * x >= 60) break labelx;
				
				if(5 * y >= 60) break;
				
				if (4 * x + 5 * y == 60) System.out.printf("(%d, %d)\n",x,y);
				
			}
		}
			
		
	}


	private static void f12() {
		// 로또번호 생성 1 <= 45
		int aa = (int) (Math.random()*45) + 1;
		System.out.println(aa);
		
	}


	/*
	 * while 문과 Math.random() 메소드를 이용해서 두 개의 주사위를 던졌을 때 나오는 눈을 (눈1, 눈2) 형태로 출력하고, 눈의
	 * 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추 는 코드를 작성해보세요. 눈의 합이 5가 되는 경우는 (1, 4),
	 * (4, 1), (2, 3), (3, 2)입니다.
	 */
	private static void f11() {

		while (true) {
			int dice1 = (int) (Math.random() * 6) + 1;
			int dice2 = (int) (Math.random() * 6) + 1;
			System.out.printf("(%d, %d)\n", dice1, dice2);
			if (dice1 + dice2 == 5) { break;
			}
		}

	}

	private static void f10() {
		double su = Math.random() * 6; // 0 <= 실수 < 1 , 0 <= 실수 < 6보다 작은 실수 값
		int su2 = (int) Math.floor(su) + 1;
		System.out.println(su2);
	}

	// 1부터 100까지 중 3의 배수의 총합 계산
	private static void f9() {

		int total = 0;
		for (int i = 3; i <= 100; i += 3) {
			System.out.println(i);
		}
	}

	// expression방식
	private static void f8() {
		String grade = "B";

		int score1 = 0;
		switch (grade) {
		case "A" -> {
			score1 = 100;
		}
		case "B" -> {
			int result = 100 - 20;
			score1 = result;
		}
		default -> {
			score1 = 60;
		}
		}

	}

	// statement방식
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

	}

	private static void f6() {
		// switch 문에서 사용할 수 있는 변수의 타입은 int, double이 될 수 없다.
		int data = 10;
		switch (data) {
		case 10:
			System.out.println("합격 축하");
			break;

		default:
			System.out.println("불합격 수고");
			break;
		}

	}

	private static void f5() {

		for (int i = 1; i < 10; i++) {
			for (int dan = 2; dan < 10; dan++) {
				int rs = dan * i;
				if (dan == 4)
					continue;
				System.out.printf("%d X %d = %d\t", dan, i, rs);
			}
			System.out.println();
		}
		System.out.println("----------------------------");

		labelA: for (int i = 1; i < 10; i++) {
			for (int dan = 2; dan < 10; dan++) {
				int rs = dan * i;
//				if(dan==4) continue labelA;
				if (dan == 4)
					break labelA;
				System.out.printf("%d X %d = %d\t", dan, i, rs);
			}
			System.out.println();
		}

	}

	private static void f4() {
		// ;(세미콜론), :(콜론), ,(콤마), ~(틸드), ^(캐럿)
		for (int i = 1; i <= 10; i++) { // 1부터 10까지 반복, 조건식이 참일동안 반복
//			if(i%5 == 0) break;				// 조건이 맞으면 반복 중단
			if (i % 5 == 0)
				continue; // 아래 문장 무시하고 반복은 계속
			System.out.println("i = " + i);
			System.out.println("--------------");

		}
		System.out.println("f4 END");
	}

	private static void f3() {
		// for, while, do~while
		int su = 1;
		int total = 0;
		do {
			total += su;
			su++;
		} while (su <= 10);
		System.out.println("su = " + su);
		System.out.println("while문 종료 후 su= " + su);
	}

	private static void f2() {

		int su = 1;
		int total = 0;
		while (su <= 10) {
			System.out.println("su = " + su);
			total += su;
			su++;
		}
		System.out.println("total : " + total);
		System.out.println("while문 종료 후 su= " + su);
	}

	private static void f1() {
		// for, while, do~while
		int su;
		int total = 0;
		for (su = 1; su <= 10; su++) {
			System.out.println("su = " + su);
			total += su;
		}
		System.out.println("total : " + total);
		System.out.println("for문 종료 후 su= " + su);
	}

}
