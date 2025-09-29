package com.shinhan.day10.thread;

public class WaitNotifyExample {

	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();
		
		Thread b = new ThreadB(workObject);
		Thread a = new ThreadB(workObject);
		
		a.start();
		b.start();
	}

}
