package com.shinhan.day08;

public class RemoteA implements RemoteInterface{

	@Override
	public String buttonClick(int a, int b) {
		
		
		return "구현class RemoteA = " + (a+b);
	}

}
