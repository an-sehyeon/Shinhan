package com.shinhan.day05;

// 1. 현재 패키지에서 class를 찾음
// 2. import되어있는 class 찾음
// 3. import된 class가 아니라면 패키지이름과 class이름을 full로 작성

import java.util.Date;

public class ImportTest {
	public static void main(String[] args) {
		// 1. 오늘 날짜를 얻어라
		Date d1 = new Date();
		System.out.println(d1);
		
		// deprecated since version 1.2 -> 권장하지 않음. 다른방법 사용하라는 의미.
		java.sql.Date d2 = new java.sql.Date(2025,4,7);
		System.out.println(d2);
		
		java.sql.Date d3 = new java.sql.Date(d1.getTime());
		System.out.println(d3);
		
		com.shinhan.day05.Date d4 = new com.shinhan.day05.Date();
		System.out.println(d4);
		
		
		
		
	}

}
