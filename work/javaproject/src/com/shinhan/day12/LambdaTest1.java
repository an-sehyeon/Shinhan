package com.shinhan.day12;

import lombok.AllArgsConstructor;
import lombok.ToString;

interface MyInterface1 {
	int add(int x, int y);
}

interface MyInterface2 {
	String get(int x);
}

interface Calculable {
	public double calc(double x, double y);

}

class Person {
	double action(Calculable calculable) {
		double result = calculable.calc(10, 4);
		return result;
	}
}

class Computer {
	static double staticMethod(double x, double y) {
		return x + y;
	}

	double instanceMethod(double x, double y) {
		return x + y;
	}
}

@ToString
@AllArgsConstructor
class Student {
	String name;
	int age;

}

interface Creatable {
	Student make(String name, int age);
}

public class LambdaTest1 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();

	}

	

	private static void f6() {
		Creatable f = (a, b) -> new Student(a, b);
		Student st = f.make("홍길동", 20);
		System.out.println(st);
		
		Creatable f2 = Student::new;
		Student st2 = f2.make("김", 30);
		System.out.println(st2);

	}

	private static void f5() {
		Person p1 = new Person();
		Calculable cal1 = (x, y) -> x + y + 1000;
		double result = p1.action(cal1);
		System.out.println("result1 = " + result);

		double result2 = p1.action(Computer::staticMethod);
		System.out.println("result2 : " + result2);

		Computer computer = new Computer();
		double result3 = p1.action(computer::instanceMethod);
		System.out.println("result3 : " + result3);
	}

	private static void f4() {
		Calculable v1 = (a, b) -> a + b;
		double result = v1.calc(1, 2);
		System.out.println(result);

	}

	private static void f3() {
		MyInterface2 a1 = (xx) -> xx + "문자";
		MyInterface2 a2 = xx -> xx + "문자";
		MyInterface2 a3 = xx -> {
			System.out.println("--------------");
			return xx + "문자";
		};
		String s = a3.get(100);
		System.out.println(s);

		String result2 = (new MyInterface2() {
			public String get(int x) {
				return x + "문자2";
			}
		}).get(200);

		System.out.println(result2);

	}

	private static void f2() {
		MyInterface1 a1 = (xx, yy) -> xx + yy;
		MyInterface1 a2 = (int xx, int yy) -> xx + yy;
		MyInterface1 a3 = (var xx, var yy) -> xx + yy;
		MyInterface1 a4 = (xx, yy) -> {
			System.out.println("2개를 parameter로 받고 int를 return 함");
			return xx + yy;
		};

		int result = a4.add(10, 20);
		System.out.println(result);

	}

	private static void f1() {
		// 1. 구현class
		MyInterface a = new MyImpl();

		// 2. 익명class
		MyInterface a2 = new MyInterface() {

			@Override
			public void work() {
				System.out.println("2. 익명구현class");
			}
		};

		// 3. 람다식
		MyInterface a3 = () -> {
			System.out.println("3. 람다식-A");
		};
		MyInterface a4 = () -> {
			System.out.println("3. 람다식-B");
		};
		test(a);
		test(a2);
		test(a3);
		test(a4);

	}

	public static void test(MyInterface aa) {
		aa.work();

	}
}
