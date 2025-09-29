package com.shinhan.day10.thread;

import lombok.Setter;

@Setter
public class PrintThread3 extends Thread{
	
	private boolean stop;
	
	public void run() {
		try {
		while(!stop) {
			System.out.println("PrintThread3...실행중");
				sleep(1);
			}
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("안정적으로 자원을 정리.. 파일닫기, 네트워연결끊기");
		System.out.println("PrintThread3.. 정상종료");
	}
}
