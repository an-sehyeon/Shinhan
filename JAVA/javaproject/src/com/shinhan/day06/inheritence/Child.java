package com.shinhan.day06.inheritence;

//자바는 단일상속만 가능(부모1개)
//자식이 부모를 선택한다. 
public class Child extends Parent {
	
	//상속받은 추가가능 
	int salary;
	
	public Child() {
		//super()
		System.out.println("자식 default생성자");
	}
	
	public Child(String name, int age) {
		//super() //암시적으로 기본 생성자를 부른다.
		//this.name = name;
		//this.age = age;
		//명시적으로 부모의 생성자를 부른다.
		super(name, age);
		System.out.println("자식 arg2 생성자");
	}
	
	public Child(String name, int age, int salary) {
		super(name, age);
		this.salary = salary;
		System.out.println("자식 arg3 생성자");
	}
	
	//함수를 추가하거나 사용할수있다. 
	void display() {
		print();
		System.out.println("급여는 " + salary);
	}
	
	
	
}










