package com.shinhan.day10.thread;


// 멀티스레드 가능
public class UppercaseThread extends Thread{

	
	@Override
	public void run() {
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println("[" +  currentThread().getName() +"]"+ch);
			
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// run메서드 구현하면 다중흐름 가질 수 있다.
		// run()메서드 재정의해야한다.
	
	
	
}
