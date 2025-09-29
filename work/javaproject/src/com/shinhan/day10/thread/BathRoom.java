package com.shinhan.day10.thread;




// 공유영역
public class BathRoom {
	
	boolean isFirst = true;
	
	// synchronized : 여러 Thread가 공유 영역을 사용하는 경우, 하나의 thread가 점유시 다른 Thread는 접근 불가
	public synchronized void use(String name) {
		if(isFirst && name.equals("김")) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "님이 입장");
		System.out.println(name + "님이 사용");
		System.out.println(name + "님이 퇴장");
		System.out.println("=========================");
		isFirst = false;
		
		notifyAll();
		
	}
	
	
}
