package com.shinhan.day03;

import java.util.Arrays;

public class ArrayTest2 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4(); 						
//		f5(); 		
//		f6();
//		f_sort();
		int[][] arr1 = {{30,30,30,30}, {40,40,40,40}, {50,50,50,50}};
		int[][] arr2 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		int[][] arr3 = new int[arr1.length][arr1[0].length];
		int[][] arr4 = new int[arr1.length][arr1[0].length];
		
		arr4 = sub(arr1, arr2, arr3);
		sub(arr1, arr2, arr3);
		
		prn(arr1);
		prn(arr2);
		prn(arr3);
//		prn(arr4);
		
	}
	

	// 반드시 return 해야됨
	public static int[][] sub(int[][] a, int[][] b, int[][] c){
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		
		return null;
	}
	
	// void : return 필요없음
	public static void prn(int[][] arr2) {
		System.out.println("==========================");
		
		for(int[] arr1 : arr2) {
			System.out.println(Arrays.toString(arr1));
		}
		
	}


	private static void f_sort() {
		int[] arr = new int[] {3,24,1,55,17,43, 5};
		System.out.println("before : " + Arrays.toString(arr));
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					// 자리 바꾸기
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("after : " + Arrays.toString(arr));
	}


	private static void f6() {
		int[] arr = new int[] {10, 20, 30};
		int[] arr2 = arr; 		// 같은 주소를 가리킴
		arr2[0] = 99;
		
		int[] arr3 = new int[arr.length];
		System.arraycopy(arr, 0, arr3, 0, arr3.length);		// (원본, 원본시작, 대상, 대상 시작, 대상 길이)
		
		arr2[0] = 99; 		// arr3은 영향을 받지 않음
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		
	}

	private static void f5() {
		String[][] arr1 = new String[][] {{"A","B"}, {"java","web"}};
		
		for(int row = 0; row < arr1.length; row++) {
			for(int col = 0; col < arr1[row].length; col++) {
				System.out.printf("%10s",arr1[row][col]);
			}
			System.out.println();
		}
		
		
	}

	private static void f4() {
		boolean[][] arr1 = new boolean[][] {{true, false, true},{true, false}};
		for(int row = 0; row < arr1.length; row++) {
			for(int col = 0; col < arr1[row].length; col++) {
				System.out.printf("%10s",arr1[row][col]);
			}
			System.out.println();
		}
	
		System.out.println("=================================");
		
		for(boolean[] chArr:arr1) {
			for(boolean ch:chArr) {
				System.out.printf("%3s",ch);
			}
			System.out.println();
		}
	}

	private static void f3() {
		// f2()의 향상된 코드
		char[][] arr1 = new char[][] {{65,66,67,68},{'가','나','다','라'},{'H','e','l','I'}};
		
		for(char[] chArr:arr1) {
			for(char ch:chArr) {
				System.out.printf("%3s",ch);
			}
			System.out.println();
		}
	}

	private static void f2() {
		char[][] arr1 = new char[][] {{65,66,67,68},{'가','나','다','라'},{'H','e','l','I'}};
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr1[i].length; j++) {
				System.out.printf("%3s",arr1[i][j]);
			}
			System.out.println();
		}
		
		
	}

	private static void f1() {
		// 2차원 배열 : 배열의 배열
		// 1. 배열 참조 변수 선언
		// 2. 배열 생성
		// 3. 배열 사용
		int[][] arr1;
		int[] arr2[] = new int[4][];
		int arr3[][];
		
		arr1 = new int[3][4];		// 배열의 길이(arr1.length) > 3, arr1[0].length > 4
		System.out.println("배열의 길이 : " + arr1.length);
		System.out.println("배열의 배열 길이 : " + arr1[0].length);
		System.out.println("값 : " + arr1[0][0]);		// 다른 언어 : [0,0]
		System.out.println("----------------arr2----------------------");
		arr2[0] = new int[] {10,20,30};
		arr2[1] = new int[] {1,2,3,4,5,6,7,8};
		arr2[2] = new int[] {7,8,9,3};
		arr2[3] = new int[6];
//		System.out.println(arr2[2][4]);
		for(int row = 0; row < arr2.length; row++) {
			for(int col = 0; col < arr2[row].length; col++) {
				System.out.printf("%3d",arr2[row][col]);
			}
			System.out.println();
		}
	}

}
