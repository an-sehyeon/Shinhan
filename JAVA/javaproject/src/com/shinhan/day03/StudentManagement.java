package com.shinhan.day03;

import java.util.Scanner;

public class StudentManagement {

	static Scanner sc = new Scanner(System.in);
	static int[] scoreArr;
	
	public static void main(String[] args) {
		
		boolean isEnd = false;
		while(!isEnd) {
			menuDisplay();
			int job = sc.nextInt();
			switch(job) {
			case 1->{
				System.out.print("학생수>");
				int su = sc.nextInt();
				scoreArr = new int[su]; //자동으로 초기화된다.0점 
			}
			case 2->{
				for(int i=0;i<scoreArr.length;i++) {
					System.out.printf("scores[%d]>", i);
					scoreArr[i] = sc.nextInt();
				}
			}
			case 3->{
				for(int i=0;i<scoreArr.length;i++) {
					System.out.printf("scores[%d]:%d\n", i, scoreArr[i]);
				}
			}
			case 4->{
				int sum = 0;
				int maxScore = -1;
				for(int i=0;i<scoreArr.length;i++) {
					sum += scoreArr[i];
					maxScore = maxScore < scoreArr[i]?scoreArr[i]:maxScore;
				}
				System.out.printf("최고점수:%d\n", maxScore);
				System.out.printf("평균점수:%3.1f\n", (double)sum/scoreArr.length);
			}
			case 5->{isEnd = true;}			
			}
			
		}
		sc.close();
		System.out.println("프로그램종료");
	}

	private static void menuDisplay() {
		System.out.println("-----------------------------------------------------");
		System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		System.out.println("-----------------------------------------------------");
		System.out.print("선택>");
	}

}
