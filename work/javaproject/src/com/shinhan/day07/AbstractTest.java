package com.shinhan.day07;

abstract class AnimalParent{
	// abstract : 자식이 반드시 구현해야됨.
	abstract void sound();
	void f1() {
		System.out.println("AnimalParent f1()");
	}
}

abstract class Animal extends AnimalParent{
	// 부모가 정의한 추상클래스를 반드시 구현 해야하지만
	// 구현을 하지 않았으므로 이 클래스도 추상클래스
	void f2(){
		System.out.println("Animal f2()");
	}
}

class Dog extends Animal{
	
	void sound() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal{
	
	void sound() {
		System.out.println("야옹");
	}
	
}
public class AbstractTest {
	public static void main(String[] args) {
		work(new Dog());
		work(new Cat());
	}

	private static void work(Animal ani) {
		ani.sound();
		
	}

}
