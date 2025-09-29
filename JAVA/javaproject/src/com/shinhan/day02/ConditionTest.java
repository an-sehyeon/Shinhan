package com.shinhan.day02;

public class ConditionTest {

	public static void main(String[] args) {
		f4(100);

	}

	private static void f4(int score) {
		String grade;
		switch(score/10) {
		case 9,10->{grade = "A";}
		case 8->{grade = "B"; }
		case 7->{grade = "C"; }
		case 6->{grade = "D"; }
		default->{ grade = "F"; }
		}
		
		System.out.printf("!!!!!당신의 점수는 %d이고 학점은 %s이다",score, grade);
	}
	
	private static void f3(int score) {
		String grade;
		switch(score/10) {
	 
		case 9,10:	grade = "A"; break;   //8버젼은 item나열 불가 
		case 8:	grade = "B"; break;
		case 7:	grade = "C"; break;
		case 6:	grade = "D"; break;
		default: grade = "F";
		}
		
		System.out.printf("!!!!!당신의 점수는 %d이고 학점은 %s이다",score, grade);
	}
	
	private static void f2(int score) {
		String grade;
		switch(score/10) {
		case 10:
		case 9:	grade = "A"; break;
		case 8:	grade = "B"; break;
		case 7:	grade = "C"; break;
		case 6:	grade = "D"; break;
		default: grade = "F";
		}
		
		System.out.printf("!!!!!당신의 점수는 %d이고 학점은 %s이다",score, grade);
	}

	// 100~90 : A
	// 80~89 : B
	// 70~79 : C
	// 60~69 : D
	// 0~59 : F
	private static void f1(int score) {
		String grade;
		if(score>=90) {
			grade = "A";
		}else if(score>=80) {
			grade = "B";
		}else if(score>=70) {
			grade = "C";
		}else if(score>=60) {
			grade = "D";
		}else {
			grade = "F";
		}
		System.out.printf("!!!!!당신의 점수는 %d이고 학점은 %s이다",score, grade);
	}

}






