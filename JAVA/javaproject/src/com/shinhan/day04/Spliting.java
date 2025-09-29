package com.shinhan.day04;

import java.util.Arrays;

public class Spliting{
	public static void main(String[] args) {
		Spliting p = new Spliting();
		String addr = "서울시,강남구,역삼동,삼성SDS멀티캠퍼스";
		String[] addrArr = p.split(addr, ',');
		System.out.println("배열 크기 : " + addrArr.length);
		for(int i=0; i<addrArr.length; i++){
			System.out.print(addrArr[i] + " ");
		}		
	}

	public String[] split(String str, char separator){
		String[] result = null;
		//배열은 반드시 개수를 알아야 만들수있다....separator의 문자가 문자열에 몇개있는지 개수+1크기로 배열을 만든다.   
		//구분자가 나올때까지 문자들을 누적해서 문자열을 만들고 배열에 넣는다. 
		int count=0;
		for(int i=0; i<str.length() ;i++) {
			if(str.charAt(i)==separator) count++;
		}
		result = new String[count+1];
		
		String word = "";
		int index=0;
		//서울시,강남구,역삼동,삼성SDS멀티캠퍼스
		for(int i=0; i<str.length() ;i++) {
			if(str.charAt(i)==separator) {
				result[index++] = word; word = ""; 
			}else {
				word += str.charAt(i);
			}
		}
		result[index++] = word;
//		for(String s:result) {
//			System.out.println(s);
//		}
		return result;
		
	}
}
