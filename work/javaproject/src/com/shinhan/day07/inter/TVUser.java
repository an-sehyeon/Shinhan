package com.shinhan.day07.inter;

public class TVUser {
	public static void main(String[] args) {
		f1();
//		f2();
	}

	private static void f1() {
		TV tv = new LgTV();
		tv.powerOn();
		tv.powerOff();
		tv.active();
		System.out.println(TV.KBS);
		TV.staticMethod();
		
		if(tv instanceof SamsungTV sam) {
			sam.samsungInfo();
		}
		if(tv instanceof LgTV lg) {
			lg.display();
		}
		
	}

	
		
}

