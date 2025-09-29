package com.shinhan.day10.thread;

public class SafeStopExample {
	public static void main(String[] args) {
		PrintThread3 t1 = new PrintThread3();
		t1.start();
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		
	}
	
	public static void main2(String[] args) {
		PrintThread2 t1 = new PrintThread2();
		t1.start();
		
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
//		t1.stop();		// 안정적이지 않음...사용x
		t1.setStop(true);
	}
	
	

}
