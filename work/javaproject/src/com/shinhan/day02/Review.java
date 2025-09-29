package com.shinhan.day02;


// 변수 + 메서드
// cmd > java Review
// JVM이 Review 클래스를 load
// main 시작... main 끝에서 종료
public class Review {
	public static void main(String[] args) {
		System.out.println("main시작");
		f1();		// 함수호출
		System.out.println("main끝");
		
	}
	public static void f1() {
		// 변수 : 변하는 값을 저장하기 위한 저장장소 이름
		System.out.println("f1시작");
		
		// 1. 변수선언 -> 저장하고자 하는 data의 성격
		// 정수 : byte(1), short(2), char(2), int(4), long(8)
		// 실수 : float(4), double(8)
		// 논리 : boolean(1)
		int v1;
		long v2;
		
		// 2. 변수 초기화 -> 지역변수는 반드시 초기화 필요
		v1 = 100;
		
		// 3. 변수사용
		v1++;
		
		v2 = v1;			// 자동 형변환
		v1 = (int)v2;		// 강제 형변환	
		System.out.println(v1);
		System.out.println(v2);
		
		
		System.out.println("f1끝");
	}
	
}


class Hello{
	
}