package com.shinhan.day07;

public class InheritenceTest {
	public static void main(String[] args) {
		
//		f1();
//		f2();
//		f3();
		call();
		
	}

	private static void call() {
		Circle v1 = new Circle(3);
		Rectangle v2 = new Rectangle(10,20);
		call2(v1);
		call2(v2);
		
		// 추상class는 instance를 만들 수 없다. 
//		Shape s = new Shape();
		Shape s = new Circle(3);
		
	}

	private static void call2(Shape shape) {
		shape.f1();
		double area = shape.getArea();
		System.out.println(shape.getClass().getSimpleName() + "면적 :" + area);
		
		
		
	}

	private static void f3() {
		Child1 v1 = new Child1(99, "홍길동");
		Child2 v2 = new Child2();
		
		f4(v1);
		System.out.println("******************");
		f4(v2);
		
	}

	// 자동형변환 : 부모의 타입 = 자식의 객체
	private static void f4(Parent p) {
		// field 접근 : 타입을 따름
		System.out.println(p.score);
		// 메서드는 instance를 따름
		
		// 사용법은 같으나 실행결과는 다름. (다형성)
		p.info();
		
	}

	private static void f2() {
		Child1 v2 = new Child1();
		v2.score = true;
		System.out.println(v2.score);
		v2.info();
		
	}

	private static void f1() {
		Child1 v1 = new Child1(100,"문자");
//		v1.score = 100;
//		v1.myname = "문자";
		System.out.println(v1.score);
		System.out.println(v1.myname);
		// 메서드 호출은 instance를 따른다.
		v1.info();
		v1.info("%%%%");
		v1.display();
		
	}

}
