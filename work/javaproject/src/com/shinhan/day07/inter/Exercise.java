package com.shinhan.day07.inter;

interface FirstZone {
	void call();
}

abstract class AbstractFirst{
	
}

// 구현 클래스
class FirstZoneImpl implements FirstZone{
	public void call() {
		
	}
}

interface A{}
class B implements A{}
class C implements A{}
class D implements A{}
class E implements A{}
		

	

public class Exercise {
	
	TV aa = new SamsungTV();
	
	public static void main(String[] args) {
		call();

		f1();
		f3();
	}

	private static void call() {
		method(new B());
		method(new C());
		method(new D());
	}

	private static void method(A aa) {
		// TODO Auto-generated method stub
		
	}

	private static void f3() {
		TV tv = new SamsungTV();
		f4(new SamsungTV());
		
		TV[] arr = new TV[3];
		arr[0] = new SamsungTV();
		
		TV tv2 = new SamsungTV();
		TV tv3 = tv2;
		
		
		
	}

	private static void f4(TV tv) {
		tv.powerOn();
	}

	private static void f1() {
		
		// interface는 instance생성불가
//		FirstZone fir = new FirstZone();
		// 추상화 클래스는 instance생성불가
//		AbstractFirst a = new AbstractFirst();
		
		FirstZoneImpl a = new FirstZoneImpl();
	}
}
