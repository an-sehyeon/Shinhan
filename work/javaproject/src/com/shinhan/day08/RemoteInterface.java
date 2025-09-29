package com.shinhan.day08;

// 람다 표현식 가능한지 체크하는 어노테이션, 함수가 1개일때만 가능
@FunctionalInterface		
public interface RemoteInterface {
	
	public abstract String buttonClick(int a, int b);
	
}
