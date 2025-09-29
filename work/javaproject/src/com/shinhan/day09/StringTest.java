package com.shinhan.day09;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
		
	}


	private static void f7() {
		String data = "100";
		int i = Integer.parseInt(data);
		double d = Double.parseDouble(data);
	}

	private static void f6() {
		
		// 기본형타입 : 값저장, 연산, 비교
		// 참조형 : 기본형 + 기능 ==> Wrapper class(포장class)
		int a = 100;
		Integer b = new Integer(200); //deprecate 권장하지 않음, 더 좋은 방법있음
		Integer c = 300;		// new Integer(300) AutoBoxing
		
		System.out.println(c.intValue());
		System.out.println(c);		// UnBoxing
		
		char v1 = 'a';
		System.out.println("소 -> 대 " + (char)(v1-32));
		System.out.println(Character.toUpperCase(v1));
		
		System.out.println(a+100>200?"yes":"no");
		
		
	}

	private static void f5() {
		String str = "이것이 자바다 데이터베이스,웹 리엑트js";
		StringTokenizer st = new StringTokenizer(str, ", ");
		System.out.println(st.countTokens());
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

	private static void f4() {
		String str = "이것이 자바다 데이터베이스,웹 리엑트js";
		char[] arr = str.toCharArray();
		System.out.println(str.charAt(0));
		System.out.println(Arrays.toString(arr));
		
		String[] arr2 = str.split("[,| ]");
		System.out.println(Arrays.toString(arr2));
		
	}

	private static void f3() {
		// 고정문자열, 수정불가, 연결연산자 사용가능(+)
		String s1 = "자바";
		// 가변문자열, 연결연산자 불가능
		StringBuilder sb = new StringBuilder("자바");
		StringBuffer sb2 = new StringBuffer("자바");
		
		System.out.println(s1.replace("자", "Java"));
		System.out.println(System.identityHashCode(s1));
		s1 = s1.replace("자", "Java");
		System.out.println(System.identityHashCode(s1));
		
		s1 = s1 + "프로그램";
		sb.replace(0, 1, "Java");
		sb2.append("프로그램");
		
		System.out.println(s1);
		System.out.println(sb);
		System.out.println(sb2);
		
		
		
	}

	private static void f2() {
		String s = "자바";
		try {
			byte[] arr = s.getBytes("UTF-8");		// Encoding, UFT-8 : 한글자는 3byte
			System.out.println(Arrays.toString(arr));	
			String s2 = new String(arr, "UTF-8");	// Decoding
			System.out.println(s2);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void f1() {
		String s1 = "자바";
		String s2 = "자바";
		String s3 = new String("자바");
		char[] arr = new char[] {'자','바'};
		String s4 = new String(arr);
		System.out.println(s4.equals(s3));
		
		
		byte[] arr2 = new byte[] {-112, 20};
		
//		System.out.println((byte)'자');
//		System.out.println((byte)'바');
		String s5;
		try {
			s5 = new String(arr2, "UTF-8");
			System.out.println(s5);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
}
