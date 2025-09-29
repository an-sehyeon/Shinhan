package com.shinhan.day01;

public class OperationPromotionExample {

	public static void main(String[] args) {
		//int = 정수 연산자 정수
		//큰타입 = 작은타입값 연산자 큰타입값
		
		byte v1 = 10;
		byte v2 = 20;
		byte v3 = (byte)(v1 + v2);
		int v4 = v1 + v2;
		
		long v5 = 1000L;
		long result = v1 + v4 +v5;

		char v6 = 'A';
		char v7 = 1;
		int v8 = v6 + v7;
		
		int v9 = 10;
		int v10 = 3;
		double v11 = (double)v9/ v10;
		System.out.println(v11);
		
		double v12 = v9 / (v10*1.0);
		System.out.println(v12);
		
	}

}





