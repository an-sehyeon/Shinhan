package com.shinhan.day04;

import java.util.Arrays;
import java.util.Scanner;

//>java LAB
//loader에 의해 메서드영역에 올라온다. static영역으로 static변수,상수들이 올라간다. 
//main시작된다. 
public class LAB {

	//1.field(속성, 특징, 변수)...이 class의 모든 메서드에서 공유하는 변수이다. 
	static Scanner sc = new Scanner(System.in); //표준(키보드)입력을 받아서 효율적으로 사용하기 위해 Scanner util사용
	static String[] namEArr;
	static int[] scoreArr;
	static Grade[] gradeArr;
	
	public static void main(String[] args) {
        boolean isContinue = true;
		while(isContinue) {
			menuDisplay();
			int job = sc.nextInt();
			switch(job) {
				case 1->{f_insert();}
				case 2->{f_select();}
				case 3->{f_selectMax();}
				case 4->{f_getAverage();}
				case 5->{f_upperScore();}
				case 6->{
					isContinue = false;
				}
				default->{
					System.out.println("지원되지않는 기능입니다.(준비중)");
				}
			}
		}
		System.out.println("=========프로그램 종료==============");
	}
	
	private static void f_upperScore() {
		int score = numberCheck("기준 점수를 입력하세요");
		
		System.out.printf("=== %d점 이상 학생 목록 ===\n", score);
		
		for(int i=0;i<scoreArr.length;i++) {
			  if(scoreArr[i]>=score) {
				  studentDisplay(i);
			  }
		}
	}
 
	
	private static void studentDisplay(int i) {
		 System.out.printf("이름:%10s - 점수:%3d, 등급:%3s\n", namEArr[i], scoreArr[i], gradeArr[i]);
		
	}

	private static void f_getAverage() {
		// 전체 학생의 평균 점수: 84.0
		if(!nullCheck()) return;
		double sum = 0;
		for(int i=0;i<scoreArr.length;i++) {
			 sum += scoreArr[i]; 
		}
		System.out.printf("전체 학생의 평균 점수: %4.1f \n", sum/scoreArr.length);
	}

	private static void f_selectMax() {
		// 최고 점수를 받은 학생: 이영희 (95점)
		if(!nullCheck()) return;
		String maxName=null;
		int maxScore=-1;
		for(int i=0;i<namEArr.length;i++) {
			 if(scoreArr[i]>maxScore) {
				 maxScore = scoreArr[i];
				 maxName = namEArr[i];
			 }
		}
		System.out.printf("최고 점수를 받은 학생: %s (%d점)\n",maxName , maxScore);
	}
	private static void f_select() {
		if(!nullCheck()) return;
		
		System.out.println("=== 학생 성적 목록 ===");
		for(int i=0;i<namEArr.length;i++) {
			studentDisplay(i);
		}
	}
	private static boolean nullCheck() {
		if(namEArr == null) {
			System.out.println("****학생정보가 아직 입력되지않아서 본 서비스 제공불가합니다.***");
			return false;
		}
		return true;
	}

	
	private static int numberCheck(String message) {
		int count = 0;
		while(true) {
			System.out.print(message);
			if(sc.hasNextInt()) {
				count = sc.nextInt();break;	
			}
		    System.out.println("!!!반드시 숫자로 입력해야한다.!!!");
		    sc.next();//입력된 문자는 버린다. 
		}
		return count;
	}
	
	
	private static void f_insert() {
		int count = numberCheck("학생 수를 입력하세요:");
		//배열은 생성후 사용가능하다.
		namEArr = new String[count];
		scoreArr = new int[count];
		gradeArr = new Grade[count];
		sc.nextLine(); //학생수 입력후 enter는 버린다. 
		for(int i=0;i<count;i++) {
			System.out.printf("%d번째 학생 이름,점수>", i+1);
			String data = sc.nextLine();  //단어를 읽는다. 기본은 공백으로 구분  aa,99  aa, 99
			String[] arr = data.split(",");		
			namEArr[i] = arr[0];			
			scoreArr[i] = Integer.parseInt(arr[1].trim()); //" 99"->"99"
			gradeArr[i] = getGrade(scoreArr[i]);
		}
	}

	private static Grade getGrade(int score) {
		Grade result = null;
		switch(score/10) {
			case 9,10->result=Grade.A;
			case 8->result = Grade.B;
			case 7->result = Grade.C;
			case 6->result = Grade.D;
			default->result = Grade.F;
		}
		return result;
	}

	//함수는 문장들의 묶음, 모듈화,  재사용
	private static void menuDisplay() {
		System.out.println("-----------------------------------------------------");
		System.out.println("1.학생수(이름,점수입력)  2.성적목록  3.최고 점수를 받은 학생 찾기");
		System.out.println("4.평균 점수  5.특정 점수 이상 학생  6.종료");
		System.out.println("-----------------------------------------------------");
		System.out.print("선택>");
	}

}
