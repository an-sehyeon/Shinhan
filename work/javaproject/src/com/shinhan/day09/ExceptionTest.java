package com.shinhan.day09;

public class ExceptionTest {
	public static void main(String[] args) {
		f1();
	}
	
	
	private static void f1() {
		String[] strArray = new String[] {"10","20"};
		int value = 0;
		for(int i = 0; i<2; i++) {
			try {
				value = Integer.parseInt(strArray[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스를 초과했음");
			}catch(NumberFormatException e) {
				System.out.println("숫자로 변환할 수 없음");
			}finally {
				System.out.println(value);
				System.out.println("---------------");
			}
		}
	}

}
