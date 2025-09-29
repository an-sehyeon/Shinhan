package com.shinhan.day10.thread;

public class SynchronizedExample {
	public static void main(String[] args) {
		call();
	}

	private static void call() {
		Calculator cal = new Calculator();
		
		User1Thread t1 = new User1Thread("User1Thread!!", cal);
		User2Thread t2 = new User2Thread("User2Thread##", cal);
		
		t1.start();
		t2.start();
		
	}
	
}
