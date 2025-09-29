package com.shinhan.day05;

public class StudentTest {

	public static void main(String[] args) {
//		f1();
		f2();
			
	}

	private static void f2() {
		Student st5 = new Student("홍길동4", "경제학과", 80, true);
		Student st2 = new Student("홍길동");
//		System.out.println(st5.grade);
		st2.print();
		st5.print(); 	// 기능 생성
	}

	private static void f1() {
		System.out.println("before 학생수 : " + Student.getCount());
		System.out.println("before 학생수 : " + Student.studentCount);
		
		Student st1 = new Student();
		Student st2 = new Student("홍길동");
		Student st3 = new Student("홍길동2", "컴공");
		Student st4 = new Student("홍길동3", "식품영양", 100);
		Student st5 = new Student("홍길동4", "경제학과", 80, true);
		
		System.out.println("after 학생수 : " + Student.studentCount);
		System.out.println("after 학생수 : " + Student.getCount());
	}

}
