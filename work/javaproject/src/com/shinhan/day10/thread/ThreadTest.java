package com.shinhan.day10.thread;



// thread : 프로그램의 실행 흐름
// 단일 쓰레드
// 멀티 쓰레드
public class ThreadTest {
	
	public static void f1() {
		System.out.println("---------대문자출력---------");
	}
	public static void f2() {
		System.out.println("---------소문자출력---------");
	}
	public static void f3() {
		System.out.println("---------숫자출력---------");
	}
	
	public static void main(String[] args) {
		System.out.println("main시작 thread이름 : " + Thread.currentThread().getName());
		
		// A~Z 출력
		f1();
		// a-z 출력
		f2();
		// 0~26 출력
		f3();
		
		UppercaseThread t1 = new UppercaseThread();
		Thread t2 = new Thread( new LowercaseThread());
		NumberRunnableClass r1 = new NumberRunnableClass();
		Thread t3 = new Thread(r1);
		
		// 익명구현class를 만들고 즉시 실행해보기
		(new Thread() {
			public void run() {
				String[] arr = {"자바","웹","프레임워크","자바스크립트","파이썬"};
				for(String subjuct:arr) {
					System.out.println("[" + currentThread().getName() + "]" + subjuct);
				}
			}
		}).start();
		
		
		// Runnable interface 익명구현class
		Thread t5 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				String[] arr = {"자바2","웹2","프레임워크2","자바스크립트2","파이썬2"};
				for(String subjuct:arr) {
					System.out.println("[" + Thread.currentThread().getName() + "]" + subjuct);
				}
			}
		});
		t5.start();
		
		
		// 람다표현식으로 Thread 만듦
		Thread t6 = new Thread( ()-> {
			String[] arr = {"자바6","웹6","프레임워크6","자바스크립트6","파이썬6"};
			for(String subjuct:arr) {
				System.out.println("[" + Thread.currentThread().getName() + "]" + subjuct);
			}
		} );
		t6.start();
		
		
		
		t1.start();
		t2.start();
		t3.start();
		
		for(int i = 100; i <= 110; i++) {
			System.out.println("[" + Thread.currentThread().getName() + "]" + i);
			
		}
		
		
		
		System.out.println("main끝");
	}
}
