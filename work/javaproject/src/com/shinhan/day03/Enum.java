package com.shinhan.day03;

import java.util.Calendar;

public class Enum {

	// 상수 -> 변하지 않는 값
	static final int SUCCESS = 1;
	static final int FAIL = 0;
	static final int LIMIT_SCORE = 95;
	
	public static void main(String[] args) {
//		f1();
//		f3();	
//		f4();
		f5();
	}

	private static void f5() {
		JobResult result = call(90);
		if(result == JobResult.SUCCESS) {
			System.out.println("성공");
		}else if(result == JobResult.FAIL) {
			System.out.println("실패");
		}
		
	}
		
	private static JobResult call(int score) {
		
		
		return score >= LIMIT_SCORE ? JobResult.SUCCESS:JobResult.FAIL;
	}

	
	
	private static void f4() {
		Calendar cal = Calendar.getInstance();			// 객체를 얻어서 사용
//		System.out.println(cal);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONDAY);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		Week[] arr = Week.values();
		for(Week w : arr) {System.out.println(w.ordinal() + "-> " + w.name());
		
		// Week Enum 사용
		Week today = null;
		
		switch(week) {
		case 1 : today = Week.SUNDAY; break;
		case 2 : today = Week.MONDAY; break;
		case 3 : today = Week.TUESDAY; break;
		case 4 : today = Week.WEDNESDAY; break;
		case 5 : today = Week.TUESDAY; break;
		case 6 : today = Week.FRIDAY; break;
		case 7 : today = Week.SATURDAY; break;
		}
		
//		System.out.println("today : " + today);
		
//		System.out.println("year : " + year);
//		System.out.println("month : " + (month+1));
//		System.out.println("day : " + day);
//		System.out.println("week: : " + week);
		
		}
	}

	private static void f3() {
		// enum : 열거형, 한정적인 값들의 묶음, 관련있는 상수들을 묶음
		JobResult a = JobResult.SUCCESS;
		JobResult[] arr = JobResult.values();
		for(JobResult job : arr) {
			System.out.println(job);
		}
			
	}

	private static void f1() {
		// 어떤 작업의 결과가 성공인지(1), 실패인지(0) 판단하려면?
		int result = 1;
		if(result == SUCCESS) {
			System.out.println("성공");
		}else if(result == FAIL) {
			System.out.println("실패");
		}
		
	}

}
