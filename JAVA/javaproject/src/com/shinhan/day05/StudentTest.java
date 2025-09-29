package com.shinhan.day05;

public class StudentTest {
 
	public static void main(String[] args) {
		f2();

	}

	private static void f2() {
		Student st5 = new Student("홍길동4", "경제", 80, true);
		System.out.println("$$$$$$$$학생정보$$$$$$$$$$$$");
		System.out.println("이름:" + st5.name);
		System.out.println("전공:" + st5.major);
		System.out.println("점수:" + st5.score);
		System.out.println("학점:" + st5.grade);
		System.out.println("학기중:" + st5.isWorking);
		System.out.println("$$$$$$$$$$$$$$$$");
		st5.print();
		
	}

	private static void f1() {
		System.out.println("before 학생수:" + Student.getCount());
		System.out.println("before 학생수:" + Student.studentCount);
		
		
		Student st1 = new Student();
		Student st2 = new Student("홍길동");
		Student st3 = new Student("홍길동2", "컴공");
		Student st4 = new Student("홍길동3", "식품영양", 100);
		Student st5 = new Student("홍길동4", "경제", 80,  true);
		
		System.out.println("after 학생수:" + Student.getCount());
	}

}
