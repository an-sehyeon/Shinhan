package com.shinhan.day10;

import lombok.AllArgsConstructor;

class Person {
}

class Worker extends Person {
}

class Student extends Person {
}

class HighStudent extends Person {
}

class MiddleStudent extends Person {
}

// 제네릭 class
@AllArgsConstructor
class Applicant<T> {
	T kind;
	
}

// 와일드카드 타입 파라메터
// ? : 아무거나 가능(Object)
// ? extends Student : Student와 Student를 상속받은 하위만 가능
// ? super Worker : Worker와 Worker의 상위
class Course {
	public static void registerCourse(Applicant<?> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "...registerCourse");
	}

	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "...registerCourse2");
	}

	public static void registerCourse3(Applicant<? super Worker> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "...registerCourse3");
	}
}

public class GenericTest2 {
	public static void main(String[] args) {
		Applicant<Person> app1 = new Applicant<>(new Person());
		Applicant<Worker> app2 = new Applicant<>(new Worker());
		Applicant<Student> app3 = new Applicant<>(new Student());
		Applicant<HighStudent> app4 = new Applicant<>(new HighStudent());
		Applicant<MiddleStudent> app5 = new Applicant<>(new MiddleStudent());
		
		
		// ? super Worker : Worker, Person
		Course.registerCourse3(app1);
		Course.registerCourse3(app2);
//		Course.registerCourse3(app3);
//		Course.registerCourse3(app4);
//		Course.registerCourse3(app4);
		
		
		// ? enxtends Student : Student, HighStudent, MiddleStudent
//		Course.registerCourse2(app1);
//		Course.registerCourse2(app2);
//		Course.registerCourse2(app3);
//		Course.registerCourse2(app4);
//		Course.registerCourse2(app4);
		
		/*
		Course.registerCourse(app1);
		Course.registerCourse(app2);
		Course.registerCourse(app3);
		Course.registerCourse(app4);
		Course.registerCourse(app4);
		*/
	}
}
