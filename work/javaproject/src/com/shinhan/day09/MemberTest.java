package com.shinhan.day09;

public class MemberTest {

	public static void main(String[] args) {
		
		Member m1 = new Member("1", "김");
		Member m2 = new Member("2","박",10);
			
		Member m3 = Member.builder()
				.id("3")
				.name("최")
//				.age(20)
				.build();
			
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
	}

}
