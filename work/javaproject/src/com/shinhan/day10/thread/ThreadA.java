package com.shinhan.day10.thread;

public class ThreadA extends Thread{
	WorkObject workObject;
	
	ThreadA(WorkObject workObject){
		this.workObject = workObject;
		setName("스레드A");
}
	public void run() {
		for(int i = 1; i<= 10; i++) {
			workObject.methodA();
		}
	}
}
