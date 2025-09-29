package com.shinhan.day09;

import java.util.HashSet;

public class ObjectTest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
		f7();
		
		
	}

	private static void f7() {
		
		String str1 = "신한DS 소프트아카데미";
//		PersonVO p1 = new PersonVO();
//		PersonVO p2 = new PersonVO();
		PersonVO p1 = new PersonVO("A",1,null);
		PersonVO p2 = new PersonVO("B",1,null);
		
		System.out.println(p1.equals(p2));
		
		System.out.println(str1);
		System.out.println(str1.toString());
		System.out.println(p1); 	// toString 재정의 했기 때문에 문자열 출력
		System.out.println(str1.hashCode());
		System.out.println(p1.hashCode());
		
	}

	private static void f6() {
		PersonVO p1 = new PersonVO("홍길동", 20, "학생");
		PersonVO p2 = new PersonVO("홍길동", 20, "학생");
		System.out.println(p1.toString());
		System.out.println(p1.getJob());
		p1.setAge(22);
		System.out.println(p1.toString());
		System.out.println(p1.equals(p2));
		
		
	}

	private static void f5() {
		
		HashSet<Coffee> data = new HashSet<Coffee>();
		data.add(new Coffee("A", 1000));
		data.add(new Coffee("A", 1000));
		data.add(new Coffee("A", 4000));
		data.add(new Coffee("B", 4000));
		for(Coffee s:data) {
			System.out.println(s);
		}
		
	}

	private static void f4() {
		// Collection : List, Set(순서없고 중복불가, 키로 사용함), Map
		// Set Interface를 구현한 class : HashSet
		
		HashSet<String> data = new HashSet<String>();
		data.add("월요일");
		data.add("화요일");
		data.add("수요일");
		data.add("수요일");
		for(String s:data) {
			System.out.println(s);
		}
		
		
	}

	private static void f3() {
		Coffee obj1 = new Coffee("아메리카노",3000);
		Coffee obj2 = new Coffee("아메리카노",3000);
		
		System.out.println(obj1);
		System.out.println(obj1.toString());		// 재정의없으면 Object의 toString() : 주소return
		System.out.println(obj1.hashCode());
		
		System.out.println(obj2);
		System.out.println(obj2.toString());
		System.out.println(obj2.hashCode());		
		
		System.out.println(obj1 == obj2?"주소가 같다" : "주소가 다르다");
		// 재정의없으면 Object의 equals() : 주소비교
		System.out.println(obj1.equals(obj2)?"내용이 같다" : "내용이 다르다");  // 재정의, 내용비교
		System.out.println(obj1.equals("라라라"));

		
		
	}

	private static void f2() {
		String obj1 = new String("자바");
		String obj2 = new String("자바");
		
		System.out.println(obj1);
		System.out.println(obj1.toString());		// 재정의 -> 문자 자신이 return됨
		System.out.println(obj1.hashCode());
		
		System.out.println(obj2);
		System.out.println(obj2.toString());
		System.out.println(obj2.hashCode());		
		
		System.out.println(obj1 == obj2?"내용이 같다" : "내용이 다르다");
		System.out.println(obj1.equals(obj2)?"내용이 같다" : "내용이 다르다");  // 재정의, 내용비교
		
		
	}

	private static void f1() {
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		System.out.println(obj1);
		System.out.println(obj1.toString());
		System.out.println(obj1.hashCode());
		
		System.out.println(obj2);
		System.out.println(obj2.toString());
		System.out.println(obj2.hashCode());
		
		System.out.println(obj1 == obj2?"주소가 같다" : "주소가 다르다");
		System.out.println(obj1.equals(obj2)?"주소가 같다" : "주소가 다르다");
		
		
		
	}

}
