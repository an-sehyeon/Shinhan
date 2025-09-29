package com.shinhan.day06;

public class MemberService {

	boolean login(String id, String password) {
		// DB학습후 데이터베이스에 가서 id, pasword에 맞는 Member가 있는지 화인할 예정이다.
		if ((id+"!").equals("hong!") && password.equals("12345")) {
		//if (id+"!" == "hong!" && password == "12345") {
			return true;
		} else {
			return false;
		}
	}

	void logout(String id) {
		System.out.println(id + "님이 logout되었습니다.");
	}

	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
		if (result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}
}
