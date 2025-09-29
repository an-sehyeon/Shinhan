package com.shinhan.day04;

public class Calculator {

		String company;
		
		// 정수 2개를 받아서 합계를 return
		public int add(int a, int b) {
			return a+b;
		}
		
		// 함수의 오버로딩 : 함수이름 같고, 매개변수 사양이 다름
		double add(int i, int j, int k){
			return i + j + k;
		}
		
		String add(String a, String b) {
			return a+b;
		}
		
		int substract(int a, int b) {
			return a-b;
		}
}
