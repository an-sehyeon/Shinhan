package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User2Thread extends Thread{
	
	Calculator calculator;
	User2Thread(String name, Calculator calculator){
		setName(name);
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}

}
