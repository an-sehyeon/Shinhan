package com.shinhan.day10.thread;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User1Thread extends Thread{
	
	Calculator calculator;
	User1Thread(String name, Calculator calculator){
		setName(name);
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(100);
	}

}
