package com.shinhan.day04.ch6;

public class KoreanTest {

	public static void main(String[] args) {
		// Korean이 5명
		// 1. 배열참조변수선언
		Korean[] arr = new Korean[5];
		
		// 2. 객체생성
		arr[0] = new Korean();
		arr[1] = new Korean("홍길동","12345");
		arr[2] = new Korean("이무기","52423");
		arr[3] = new Korean();
		arr[4] = new Korean();
		
		// 3. 객체사용
		for(Korean kor : arr) {
			kor.display();
		}
		
		
		
		
	}

}
