package com.shinhan.day04;

import java.util.Arrays;

public class Converter {
	public static void main(String[] args) {
		System.out.println("문자열에 특정문자 변경하는 테스");
		System.out.println("-------------Sample 1 --------------");
		String str1=myReplace("hello world",'l','*');
		System.out.println(str1);
		
		System.out.println("-------------Sample 2 --------------");
		String str2=myReplace("hello world",' ','-');
		System.out.println(str2);
		
		System.out.println("-------------Sample 3 --------------");
		String str3=myReplace("hello world",'a','*');
		System.out.println(str3);
		

	}
	
	public static String myReplace(String str, char oldChar, char newChar){
		// 이 부분을 구현하시오.
		String result = str.replaceAll(oldChar+"", newChar+"");
 
		
		return result;
			 
	}
	
	
	public static String myReplace3(String str, char oldChar, char newChar){
		// 이 부분을 구현하시오.
		String result = "";
		char[] charArr = str.toCharArray();
		//System.out.println(Arrays.toString(charArr));
        for(int i=0;i<str.length();i++) {
         	if(str.charAt(i) == oldChar) {
         		charArr[i] =  newChar;
        	}else {
        		charArr[i] =  str.charAt(i); 
        	}
        }
        //System.out.println(Arrays.toString(charArr));
        result = new String(charArr);
		return result;
			 
	}
	
	public static String myReplace2(String str, char oldChar, char newChar){
		// 이 부분을 구현하시오.
		String result = "";
        for(int i=0;i<str.length();i++) {
        	//System.out.println(str.charAt(i));
        	if(str.charAt(i) == oldChar) {
        		result += newChar;
        	}else {
        		result +=str.charAt(i);
        	}
        }
		return result;
			 
	}
}









