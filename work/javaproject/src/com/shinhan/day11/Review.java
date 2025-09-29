package com.shinhan.day11;

class MyThread1 extends Thread{
	public void run() {
		System.out.println(currentThread().getName() + " 쓰레드1");
	}
}
class MyThread2 extends Object implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 쓰레드2");
	}
}


// 프로그램 실행(실행중인 프로그램) : process
// 흐름(thread) : 1개(Single Thread)
// 흐름(thread) : 여려개(Multi Thread) -> Thread상속, Runnable구현
public class Review {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "시작");
		
		MyThread1 t1 = new MyThread1();
		Runnable r1 = new MyThread2();
		Thread t2 = new Thread(r1);
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for(int i = 1; i <= 100; i++) {
//			System.out.println(i);
//		}
		
		System.out.println(Thread.currentThread().getName() + "끝");
		
	}
}
