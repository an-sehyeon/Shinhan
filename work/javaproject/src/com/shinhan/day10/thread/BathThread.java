package com.shinhan.day10.thread;


public class BathThread extends Thread{
	BathRoom room;
	String myname;
	
	public BathThread(String myname, BathRoom room) {
		this.myname = myname;
		this.room = room;
	}

	

	@Override
	public void run() {
		// 1사람이 3번 사용한다.
		for(int i= 1; i<=3; i++) {
			room.use(myname);
		}
	}
	
	
	
}
