package com.shinhan.day11;


// 1초마다 자동저장하기
public class AutoSaveThread extends Thread{

	void save() {
		System.out.println("1초마다 자동저장-------");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			save();
		}
	
	}

}
