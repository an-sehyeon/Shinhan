package com.shinhan.day03;

import java.util.Arrays;


//명령행 매개변수 .....명령줄에서 실행시 이 프로그램에 들어오는 argument 
//>java ArrayTest 100 200 

public class ArrayTest {

	
	public static void main(String[] args) {
		printSeason(Integer.parseInt(args[0]));
	}
	
	
	
	
	private static void printSeason(int month) {
		String season="";
		switch(month) {
			case 3,4,5->{season = "봄";}
			case 6,7,8->{season = "여름";}
			case 9,10,11->{season = "가을";}
			case 12,1,2->{season = "겨울";}
			default->{System.out.println("1~12 사이의 숫자만 입력하셔야 합니다."); return;}
		}
		System.out.println(season + "에 태어나셨네요");
	}




	public static void main2(String[] args) {
		
		if(args.length !=2 ) {
			System.out.println("매개변수로 2개의 정수를 입력하세요");
			return; //자바가상머신으로 돌아간다. 프로그램종료
		}
		
		//명령행 매개변수로 두 정수를 입력받아 4칙연산 수행
		int su1 = Integer.parseInt(args[0]);
		int su2 = Integer.parseInt(args[1]);
		
		System.out.printf("%d + %d = %d\n", su1, su2, su1+su2);
		System.out.printf("%d - %d = %d\n", su1, su2, su1-su2);
		System.out.printf("%d * %d = %d\n", su1, su2, su1*su2);
		System.out.printf("%d / %d = %d\n", su1, su2, su1/su2);
		
	}

	private static void f4() {
		String[] arr = new String[]{"자바","데이터베이스","웹", "프레임워크"};//new String[] 생략가능 
		
		System.out.println(arr.length);  //배열의 길이는 length속성을 이용한다. 
		
		System.out.println(Arrays.toString(arr));
		
		
		//향상for, 확장for...배열, Collection(List, set, Map)
		for(String s:arr) {  //반복자(iterator)를 이용한다.
			System.out.println(s);
		}
	}

	private static void f3() {
		//선언+생성+초기화
		//int[] arr = new int[] {100,90,60,40,80}; //배열의 개수를 적지않아야한다. 
		int[] arr = {100,90,60,40,80}; 
		int[] arr2;
		arr2 =  new int[] {100,90,60,40,80}; // new int[]부분은 생략불가하다.
		for(int index=0;index<arr2.length;index++) {
			System.out.println(index + "번째==>" + arr2[index]);
		}
	}

	private static void f2() {
		//선언+생성
		int[] arr1=new int[5]; //{0,0,0,0,0}
		//사용
		arr1[0] = 100;
		for(int index=0;index<arr1.length;index++) {
			System.out.println(index + "번째==>" + arr1[index]);
		}
		
	}

	private static void f1() {
		//배열:같은타입,값여러개,연속공간,접근은 첨자이용
		//1.배열참조변수선언
		int[] arr1=null;
		char arr2[];
		//선언+생성
		double[] arr3 = new double[3];
		boolean[] arr4 = new boolean[3];
		
		//2.배열생성....필수(생성하지않으면 사용불가), 반드시 배열의 갯수를 정한다. 
		arr1 = new int[3]; //3개의 int저장가능한 연속공간을 만든다. 자동초기화된다. 
		arr2 = new char[3];
		//정수->0 char->' '  실수->0.0 boolean->false
		//3.배열사용
		System.out.println(arr1[0]);
		System.out.println("*" + arr2[0] + "*");
		System.out.println(arr3[0]);
		System.out.println(arr4[0]);
		
	}

}
