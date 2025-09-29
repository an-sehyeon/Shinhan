package com.shinhan.day13;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@RequiredArgsConstructor
@ToString
class Member {
	private final String name;
	private final int age;
	private String job;
}




public class Example {
	public static void main(String[] args) {
		// 8번문제
		List<Member> list = Arrays.asList(
					new Member("홍길동",1, "개발자"),
					new Member("김나리",2, "디자이너"),
					new Member("신용권",3, "개발자")
				 );
				 Map<String, List<Member>> groupingMap = 
						 list.stream()
						 .collect(Collectors.groupingBy(data -> data.getJob()));
				 for(Entry<String, List<Member>> data:groupingMap.entrySet()) {
					 System.out.println("key : " + data.getKey());
					 System.out.println("Value : " + data.getValue());
				 }
						 
			
				 }
	
	
	public static void main4(String[] args) {
		// 7번문제
			 List<Member> list = Arrays.asList(
				new Member("홍길동",1, "개발자"),
				new Member("김나리",2, "디자이너"),
				new Member("신용권",3, "개발자")
			 );
			 list.stream()
					 .filter(m->m.getJob().equals("개발자"))
					 .collect(Collectors.toList())
					 .forEach(st->System.out.println(st));
					 
					 
//				 developers.stream()
//				 .forEach(m -> System.out.println(m.getName()));
			 }
		
		// GroupingBy : Map<String, List<Member>>
	
	
	
	
	
	
	
	public static void main3(String[] args) {
		// 6번문제
		
			 List<Member> list = Arrays.asList(
					 new Member("홍길동", 30),
				 new Member("신용권", 40),
				 new Member("감자바", 26)
			 );
			 double avg = list.stream()			// original stream
					 .mapToInt(m->m.getAge())	// 중간단계
					 .average()					// 최종단계			
					 .getAsDouble();
			 System.out.println("평균 나이: " + avg);
			 }


	public static void main2(String[] args) {
		// 5번문제
		List<String> list = Arrays.asList("This is a java book", "Lambda Expressions",
				"Java8 supports lambda expressions");
		list.stream() // original stream
				.filter(st -> st.toLowerCase().contains("java")) // 중간단계, 대소문자 상관없이 "java"문자가 들어간 문장출력
				.forEach(s -> { // 최종단계
					System.out.println(s);
				});

	}
}
