package com.shinhan.day02;

import java.util.Scanner;

public class LAB1 {

	public static void main(String[] args) {
		hokeyGraphics( '$', 4, false);
		hokeyGraphics( '#', 10, true);
		
		//char a = '@'; int b=5; boolean c= false;
		//hokeyGraphics(a, b, c);
        
		f5();
	}
	private static void f5() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    	System.out.print("직각 역삼각형을 출력할 줄 수:");
    	/*
    	 * 1  : 1~10
    	 * 2  : 1~9
    	 * 3  : 1~8
    	 * 10 : 1~1
    	 */
    	int size = sc.nextInt();
    	for(int row=1;row<=size;row++) {
			for(int col=1;col<=size+1-row;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
    	sc.close();
    	
	}
	//함수정의시 매개변수는 변수를 정의하는 것이다.
	//함수호출시 매개변수(argument, parameter)는 값이다. 
	public static void hokeyGraphics(char cell, int size, boolean isRect)
    {
        //특정 도형을 출력하는 메소드 구현
		if(isRect) {
			for(int row=1;row<=size;row++) {
				for(int col=1;col<=size;col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		}else {
			for(int row=1;row<=size;row++) {
				for(int col=1;col<=row;col++) {
					System.out.print(cell);
				}
				System.out.println();
			}
		}
    }
	
	
	/*
	 * 문제3. 숫자를 입력 받아서 아래와 같은 실행결과가 나타나도록 SumTest 클래스의 main 메쏘드를 완성하십시오. 
		a. 입력 받은 숫자가 홀수인 경우에는, 0 부터 입력 값까지 홀수의 합을 출력합니다.
		- 예제 : 입력이 7 이면 16을 출력 ( 1 + 3 + 5 + 7 = 16 ) 
		b. 입력 받은 숫자가 짝수인 경우에는, 0 부터 입력 값까지 짝수의 합을 출력합니다.
		- 예제 : 입력이 10 이면 30을 출력 ( 2 + 4 + 6 + 8 + 10 = 30 )
		
		숫자를 입력하세요. : 7
		결과 값 : 16


	 */
	private static void f3() {
		int total = 0;
		int start ;
		Scanner sc = new Scanner(System.in);
    	System.out.print("숫자를 입력하세요.:");
    	
    	int su = sc.nextInt();
    	start = su%2==0?0:1;
    	for(int i=start;i<=su;i+=2) {
    		total += i;
    	}
    	System.out.println("결과 값 : " + total);
    	sc.close();
		
	}
	/*
	 * 문제2. 문자열을 입력 받아서 아래와 같은 실행결과가 나타나도록 ForTest클래스의 main 메쏘드를 완성하십시오. 
	 * 입력 받은 문자열을 한 글자씩 증가시키며 출력하는 프로그램입니다. (단, 대문자로 출력해야 합니다.)
	 * 문자열을 입력하세요. : Bat Man
		B   0<= <1
		BA  0<= <2
		BAT
		BAT 
		BAT M
		BAT MA
		BAT MAN

	 */
    private static void f2() {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("문자열을 입력하세요. :");
    	String data = sc.nextLine().toUpperCase();
    	
    	int len = data.length();
    	for(int i=0;i<len;i++) {
    		System.out.println(data.substring(0, i+1));
    	}
        sc.close();
		
	}
	/*
     * 문제1. 초기 값, 마지막 값, 증가분을 입력 받아서, 초기값부터 마지막 값까지, 증가분씩 값을 증가시키면서 각 값들의 총합을 구하는 프로그램을 작성하세요. 단, 합을 구한 결과가 1000을 넘으면, 결과에 2000을 한번 더 더하여 출력합니다
     */
	private static void f1() {
		//1.변수선언 + 변수초기화
		Scanner sc = new Scanner(System.in);
		
		System.out.print("초기값을 정수로 입력하세요. :");
		int start = sc.nextInt();
		System.out.print("마지막 값을 정수로 입력하세요. :");
		int last = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요. :");
		int step = sc.nextInt();
		int total = 0; 
		
		for(int i=start;i<=last;i+=step) {
			total +=i;
		}
		
		System.out.printf("총합은 %d 입니다.",total);
		sc.close(); //자원반납 
		
	}

}









