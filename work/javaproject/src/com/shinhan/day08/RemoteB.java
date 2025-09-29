package com.shinhan.day08;

public class RemoteB implements RemoteInterface{

	@Override
	public String buttonClick(int a, int b) {
		
		
		return "구현class RemoteB = " + (a-b);
	}

}
