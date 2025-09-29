package com.shinhan.day09;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpressionTest {

	public static void main(String[] args) {
//		f1();
//		f2();
		f3();
//		f4();
	}

	private static void f4() {
		// TODO Auto-generated method stub
		
	}

	private static void f3() {
		// 한글로 시작(^) 정규표현식, ($) : 끝난다
		String regExp = "(^[가-힣])\\w+([가-힣])$";
		String data = "홍길동입니다.asdfasfadadfa하";
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(data);
		while(matcher.find()) {
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println("------------------------");
		}
		
	}

	private static void f2() {
		// + : 0개이상, * : 0개이상, ? : 0,1개이상
		String regExp = "[0-9A-Za-z]+@(\\w+)\\.\\w+";
		String data = "web0406@daum.net";
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		
		// 중복 허용 안함
		HashSet<String> hs = new HashSet<String>();
		
		data = "이메일은 web0406@daum.net 입니다. 추가 이메일은 web0406@naver.com로 보내주세요";
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(data);
		while(matcher.find()) {
			System.out.println(matcher.group());
			hs.add(matcher.group(1));
			System.out.println("------------------------");
		}
		System.out.println(hs.size()+"가지 이메일의 종류를 사용중입니다.");
	}

	private static void f1() {
		
		// [] : 선택
		// - : 범위
		// {3} : 3자리수 {3,4} : 3자리이거나 4자리수 
//		String regExp = "[01]{3}-[0-9]{3,4}-[0-9]{4}";
//		String data = "010-1234-5678";
//		boolean result = Pattern.matches(regExp, data);
//		System.out.println(result);
		
		String regExp = "[01]{3}-[0~9]{3,4}-[0~9]{4}";
		String data = "010-1234-5678";
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		
		String regExp2 = "([01]{3})-([0-9]{3,4})-([0-9]{4})";
		data = "asdfafadsfafafadf 010-1242-1234 adfafadfadfaf 011-235-9999";
		Pattern pattern = Pattern.compile(regExp2);
		Matcher matcher = pattern.matcher(data);
		
		while(matcher.find()) {
			System.out.println(matcher.group());	// 전체
			System.out.println(matcher.group(1));	// 첫번째 group
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
			System.out.println("-----------------");
		}
		
	}

}
