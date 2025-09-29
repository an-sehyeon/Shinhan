package com.shinhan.day05.lab;

public class Test {

	public static void main(String[] args) {
//		Member user1 = new Member("홍길동","hong");
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "1345");
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout();
		}else {
			System.out.println("id또는 password가 올바르지 않습니다.");
		}
	}
}
