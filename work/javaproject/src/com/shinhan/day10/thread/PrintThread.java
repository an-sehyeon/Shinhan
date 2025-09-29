package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PrintThread extends Thread {
	ShareArea shareArea;

	public void run() {
		// 12번 sung -> lee 100만원씩 이체
		for (int i = 1; i <= 3; i++) {

			// 방법1) synchronized 블럭 사용하기
//			synchronized (shareArea) {
//				int a = shareArea.getSung().getBalance();
//				int b = shareArea.getLee().getBalance();
//				System.out.println("[잔액합계] " + (a + b));
//			}
			
			// 방법2) 공유 영역에 method를 만들고 synchronize
			shareArea.print();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
