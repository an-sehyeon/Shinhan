package com.shinhan.day05;

public class OverloadingTest {
	public static void main(String[] args) {
		Calculator.add();
		Calculator.add(1,2,3);		// 매개변수 타입을 double 설정해도 자동 형변환
		Calculator.add(1.2f, 2.2f, 3.5);	
		Calculator.add('A', "BC", "자바");	
		Calculator.add(1,2);	
		Calculator.add(1,2,3,4,5,6,7,8,9,10);	
		
		System.out.printf("%d, %d\n",10,20);
		
		Calculator cal = new Calculator();
		int[] arr = {1,2,3,4,5};
//		cal.sum(new int[]{1,2,3,4,5});
		int result1 = cal.sum(new int[]{1,2,3,4,5});
		int result2 = cal.sum(arr);
		
		int aa = cal.display(10);
		System.out.println(aa);
		
		double bb = Math.ceil(3.1);		// 올림 후 정수
		System.out.println(bb);
		
		double cc = Math.floor(3.9);					// 소수 부분 버림
		System.out.println(cc);
		
		// non-static 사용법
		new Calculator().f1();
		
		// static 사용법
		Calculator.f2();
		
	}

}

class Calculator{
	
	// 인스턴스 필드(멤버변수)
	String company;
	String color;
	
	// static vield(class 변수)
	static int count;
	
	// instance 메소드
	void f1() {
		
	}
	
	// static 메소드
	static void f2() {
		
	}
	
	
	int display(int num) {
		if(num % 2 == 0) {
			System.out.println("짝수입니다.");
			return num+1;		// 이 함수를 호출한 곳으로 돌아간다. 위의 코드가 실행되면 아래의 코드들을 무시한다.
//			System.out.println("----------return아래문장 작성시 컴파일오류------------");
		}
		System.out.println("홀수입니다.");
		return num+2;
	}
	
	int sum(int...arr) {
		int total = 0;
		for(int su : arr) {
			total += su;
		}
		return total;
	}
	
	// 오버로딩 조건 : 함수이름 동일해야됨, 매개변수 타입과 개수가 다름, return타입은 상관없음.
	
	static void add() {
		System.out.println("add method ---매개변수 없음 ");
	}
	static int add(String s) {
		System.out.println("add method ---매개변수 1개있음 ");
		return 100;
	}
	static void add(double a, double b, double c) {
		System.out.println("double 3개 합계 : " + (a+b+c));
	}
	static void add(char a, String b, String c) {
		System.out.println("char1개 String2개 : " + (a+b+c));
	}
	static void add(int...arr) {
		int sum = 0;
		for(int num:arr) {
			sum += num;
		}
		System.out.println("합계 : " + sum);
	}
}