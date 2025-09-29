package com.shinhan.day13;

import java.util.Arrays;

public class Test {
	private static Student[] students = {
			new Student("홍길동",90,60),
			new Student("신용권",95,80) };

	public static void main(String[] args) {
		double englishAvg = avg(s -> s.getEnglishScore());
		System.out.println("영어 평균 점수 : " + englishAvg);
		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("수학 평균 점수 : " + mathAvg);
		
		double engAvg = Arrays.stream(students)
				.mapToInt(st->st.getEnglishScore())
				.average().getAsDouble();
		double mathAvg2 = Arrays.stream(students)
				.mapToInt(st->st.getMathScore())
				.average().getAsDouble();
		System.out.println("engAvg = " + engAvg);
		System.out.println("mathAvg2 = " + mathAvg2);
		
		Arrays.stream(students)
		.map(st->st.getName())
		.forEach(name->System.out.println(name));
		
				
		
	}

	private static double avg(Funtion<Student> f) {
		double result = 0;
		for(Student st:students) {
			result += f.apply(st);
		}
		return result/students.length;
	}

}
