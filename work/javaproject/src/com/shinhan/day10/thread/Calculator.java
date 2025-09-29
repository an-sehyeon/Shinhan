package com.shinhan.day10.thread;

import lombok.Getter;

@Getter
public class Calculator {

	int memory;

	// 동기화 메서드(lock걸기)
	synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
	
	

	void setMemory2(int memory) {

		synchronized (this) {

			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : " + this.memory);
		}
	}
}
