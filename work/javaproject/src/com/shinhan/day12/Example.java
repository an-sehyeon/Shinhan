package com.shinhan.day12;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.ToString;

public class Example {

	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("홍길동", "개발자"),
				new Member("김나리", "디자이너"),
				new Member("신용권", "개발자")
				);
	list.stream().filter(s->s.getJob().equals("개발자"))
	.collect(Collectors.toList());
	list
	.forEach(st->{
		System.out.println(st);
	});
		
	}
}
@ToString
class Member{
	private String name;
	private String job;
	
	public Member(String name, String job) {
		this.name = name;
		this.job = job;
	}
	
	String[] strArray = {"홍길동","신용권","김미나"};
	Stream<String> strStream = Arrays.stream(strArray);
	
	
	
	public String getName() {return name;}
	public String getJob() {return job;}
}
