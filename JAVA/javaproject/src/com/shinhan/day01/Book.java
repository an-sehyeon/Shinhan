package com.shinhan.day01;

//>java Book
//JVM이 class를 load하고  main시작
class Book {
	private static void f1() {
		System.out.println("Book class의 f1메서드이다.");

	}

	public static void main(String[] args) {
		System.out.println("Book class의 main method이다.");
		f1();
		System.out.println("===main END=====");

		new Cup().f1();

	}
}

/*
 * 여러줄 주석 하나의 .java안에 여러개의 class를 만들수있다. public class는 반드시 자신의 이름으로 저장해야한다. 하나의
 * class가 다른 class를 사용하려면 반드시 생성후 사용한다. 주석달기은 ctrl + / 주석해제 ctrl + / 여러줄은 ctrl
 * +shift + /
 */
class Cup {


	public void f1() {
		System.out.println("Cup class의 f1메서드이다.");

	}

	public static void main(String[] args) {
		System.out.println("Cup class의 main/*ㄴㄴㄴㄴㄴ*/");
	}
}
