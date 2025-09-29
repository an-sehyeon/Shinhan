package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShareArea {
	private Account sung;
	private Account lee;
	
	// 이 함수를 점유하고 있는 Thread가 있다면 다른 Thread는 진입하지 않고 기다린다.
	// 실행중인 Thread가 lock을 건다.
	public synchronized void print() {
		int a = sung.getBalance();
		int b = lee.getBalance();
		System.out.println("[잔액합계] " + (a + b));
	}
	
	public  synchronized void transfer() {
		int amount = lee.withdraw(100);
		System.out.println("[출금(lee -> sung)] " + amount);
		sung.deposit(amount);
		System.out.println("[입금(sung)] " + amount);
		System.out.println("-----------------------------------");
	}
}
