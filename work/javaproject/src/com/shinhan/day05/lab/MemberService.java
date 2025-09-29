package com.shinhan.day05.lab;

public class MemberService {
	private String id;
	
//	public MemberService(String id, String password) {
//		super();
//		this.id = id;
//		this.password = password;
//	}
//	
//	public boolean login(String id, String password) {
//		boolean result = this.id.equals(id);
//		return result;
//	}
	
	public boolean login(String id, String password) {
		this.id = id;
		if(id.equals("hong") && password.equals("12345")) {
			return true;
		}else {
			return false;
		}
		
	}

	public void logout() {
		System.out.println(this.id + "님이 로그아웃 되었습니다.");
	}

	
	
}
