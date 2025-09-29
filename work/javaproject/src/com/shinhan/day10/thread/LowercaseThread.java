package com.shinhan.day10.thread;

// 멀티쓰레드 가능 -> Ruuable인터페이스 구현하면 멀티쓰레드 가능
public class LowercaseThread extends Object implements Runnable{
	
	@Override
	public void run() {
		for(char ch = 'a'; ch <= 'z'; ch++) {
			System.out.println("[" + Thread.currentThread().getName() + "]" + ch);
		
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
