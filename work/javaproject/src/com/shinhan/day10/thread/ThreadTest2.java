package com.shinhan.day10.thread;

public class ThreadTest2 {

	public static void main(String[] args) {
		call();
//		call2();
//		call_yield();
	}

	private static void call_yield() {
		WorkThread t1 = new WorkThread("워크1");
		WorkThread t2 = new WorkThread("워크2");
		t1.start();
		t2.start();
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		t1.work = false;	// 워크1이 양보, 워크 2만 실행
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		t1.work = true;
	}

	private static void call2() {
		BathRoom room = new BathRoom();
		
		BathThread t1 = new BathThread("김", room);
		BathThread t2 = new BathThread("박", room);
		BathThread t3 = new BathThread("양", room);
		
		t1.start();
		t2.start();
		t3.start();
		
	}

	private static void call() {
		Account sung = new Account("123", "성춘향", 2000);
		Account lee = new Account("124", "이몽룡", 1000);
		ShareArea shareArea = new ShareArea(sung, lee);

		PrintThread t1 = new PrintThread(shareArea);
		TransferThread t2 = new TransferThread(shareArea);
		t1.start();
		t2.start();
	}

}
