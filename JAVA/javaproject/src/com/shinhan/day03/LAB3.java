package com.shinhan.day03;

import java.util.Scanner;

//static은 static만 호출가능 

public class LAB3 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
//		int year = 2020, month = 2;
//		int lastDay = numDays(year, month); //인자, parameter, argument 
//		System.out.printf("%d년도의 %d월의 말일은 %d입니다.\n", year, month, lastDay);
//		
//		
//		f6(year, month);
		
		
		f8();
		
		
		 
		sc.close();
		System.out.println("---------Main END--------");
	}

	private static void f8() {
		sc.useDelimiter("[,\\s]"); //구분자를 ,로 한다.  10,5,    \\s:공백, enter, tab도 포함 
		//[]선택 , []안에 나열된 문자로 구분한다.
		 //기본은 구분자가 공백이다. 
		System.out.print("숫자를 입력>>");
		int su1 = sc.nextInt(); 
		int su2 = sc.nextInt();
		//int min = su1>su2?su2:su1; //작은수를 구한다.
		int min = Math.min(su1, su2);
		int result = 1;
		for(int i=min;i>=1;i--) {
			if(su1%i==0 && su2%i==0) {
				result = i; 
				System.out.println(result); break;
			}
		}
		System.out.println(result);
		
		/*
		 * 최대 공약수는 두 숫자를 공통된 숫자로 나누어도 나머지가 0이 되는 가장 큰 수를 의미합니다. 
		 * 예를 들어 2와 5의 최대 공약수는 1입니다.
		 *  왜냐하면, 1부터 2까지의 숫자중 공통으로 나눌 수 있는 숫자는 1 뿐이기 때문입니다. 
		 *  다른 예로, 5와 15의 최대 공약수는 5가 됩니다. 메소드의 이름은 gcd로 하며, 
		 *  매개변수는 두개의 정수를 받으며, 리턴 하는 타입 역시 정수입니다.

[입력값]
2, 5
5,15
250,30

[실행결과]
1
5
10

		 */
		
	}

	private static int numDays(int year, int month) {
		int lastDay;
		// 30, 31, 2월은 28(평년)이거나 29일(윤년)이다.

		switch (month) {
			case 1, 3, 5, 7, 8, 10, 12 -> {
				lastDay = 31;
			}
			case 4, 6, 9, 11 -> {
				lastDay = 30;
			}
			case 2 -> {
				lastDay = 28;
				if(year%4==0 && year%100!=0 || year%400 == 0) lastDay = 29;
			}
			default -> {
				System.out.println("월이 잘못입력되었습니다.");
				lastDay = 0;
			}
		}
		
		return lastDay;
	}

	private static void f6(int year, int month) {
	 
	 
		int lastDay = numDays(year, month);
		 
		System.out.printf("%d년도의 %d월의 말일은 %d입니다.\n", year, month, lastDay);

		/*
		 * [윤년의 조건] 
		 * 1) 4의 배수인 해는 윤년. 
		 * 2) * 4의 배수이면서 100의 배수인 해는 윤년이 아님. 
		 * 3) 100의 배수이면서 400의
		 * 배수인 해는 윤년.
		 * 
		 */

	}

	private static void f5() {
		int num1 = 1; // 각각의 수, 1부터시작함
		int num2 = 1; // 증가치
		int sum = 0;
		for (int i = 1; i <= 15; i++) {
			sum += num1;
			num1 += num2; // 증가치를 각각의 수에 더한다.
			num2++; // 증가치는 1씩 증가하고있다.
		}
		System.out.printf("15번째까지의 합 : %d\n", sum);

		/*
		 * • 수열 규칙 : 1부터 시작해서 두 항의 차이가 1씩 증가 • 예 시 : 1 + 2 + 4 + 7 + 11 + 16 + 22 + …………
		 * 위의 수열에서 15번째 항까지의 합을 구하는 프로그램을 작성하십시오
		 * 
		 * 
		 * [출력값] 15번째까지의 합 : 575
		 * 
		 */

	}

	private static void f4() {
		System.out.print("양의 정수를 입력하세요 :");
		int su = sc.nextInt();
		int count = 0;
		int total = 0;
		for (int i = su; i <= 1000; i += su) {
			count++;
			total += i;
		}
		System.out.printf("%d의 배수 개수 = %d\n", su, count);
		System.out.printf("%d의 배수 합 = %d\n", su, total);

		// TODO Auto-generated method stub
		/*
		 * [출력값] 양의 정수를 입력하세요 : 7 7의 배수 개수 = 142 7의 배수 합 = 71071
		 * 
		 */
	}

}
