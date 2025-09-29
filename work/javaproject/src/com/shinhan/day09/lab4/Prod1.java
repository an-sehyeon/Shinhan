package com.shinhan.day09.lab4;

public class Prod1 {
	public static void main(String[] args) {
		String str = "everyday we have is one more than we deserve";
		
		char[] arr = str.toCharArray();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ' ') continue;
			if(arr[i] + 3 > 122) {
				arr[i] = (char)(arr[i] + 3 -123);
			}else {
				arr[i] = (char)(arr[i] + 3);
			}
		}
		String result = new String(arr);
		
		System.out.println("암호화할 문자열 : " + str);
		System.out.println("암호화된 문자열 : " + result);
		
	}
}
