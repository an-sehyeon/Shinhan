package com.shinhan.day10.thread;

public class ThreadB extends Thread{
	WorkObject workObject;
	
	ThreadB(WorkObject workObject){
		this.workObject = workObject;
		setName("스레드B");
}
	public void run() {
		for(int i = 1; i<= 10; i++) {
			workObject.methodB();
		}
	}
}
