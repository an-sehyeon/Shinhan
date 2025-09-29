package com.shinhan.day10.thread;

public class WorkObject {
	
//	synchronized에서만 wait, notify 사용가능
//	current thread is not owner
	synchronized void methodA() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": WorkObject methodA()");
		notify();
		try{
			wait();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
	synchronized void methodB() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": WorkObject methodB()");
		notify();
		try{
			wait();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
