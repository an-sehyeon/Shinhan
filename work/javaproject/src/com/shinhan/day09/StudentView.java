package com.shinhan.day09;

public class StudentView {

	public static void print(StudentDTO[] arr) {

		System.out.println("=======view(여러건)======");
		for (StudentDTO st : arr) {
			System.out.println(st);
		}
	}

	public static void print(StudentDTO st) {
		System.out.println("=======view(1건)======");
		System.out.println(st);
	}
}
