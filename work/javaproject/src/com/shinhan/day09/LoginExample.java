package com.shinhan.day09;


// Exception
// 1) Runtime Exception(Unchecked Exception) : 컴파일시 check안됨
// 2) 일반 Exception(checked Exception) : 컴파일시 check

// Exception
// 1)내가처리	 try~catch~finally
// 2) 떠넘긴다. throws

// Exception 발생방법
// 1)자동 : JVM이 정해진 규칙을 지키지 않으면 오류발생, EX)정수를 0으로 나눌수없다...
// 2)강제 : throw new Exception 이름()
class NotExistIDException extends Exception {
	public NotExistIDException() {
		super("존재하지 않는 ID입니다.");
	}

	public NotExistIDException(String message) {
		super(message);
	}
}

 class WrongPasswordException extends Exception {
	public WrongPasswordException() {
		super("비밀번호 오류");
	}

	public WrongPasswordException(String message) {
		super(message);
	}
}

public class LoginExample {
	public static void main(String[] args) {
		try {
			login("blue", "123456");
			System.out.println("로그인 성공");
		} catch (NotExistIDException|WrongPasswordException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("반드시 수행할 작업을 기술한다.");
		}
		

		
	}

	public static void login(String id, String password) throws NotExistIDException, WrongPasswordException{ // 예외를 떠넘김
		// id가 blue가 아니라면 NotExistIDException을 발생시킴
		if (!id.equals("blue")) {
			throw new NotExistIDException();		// 예외를 발생시킴
		}
		
		// password가 12345가 아니라면 WrongPasswordException을 발생시킴
		if (!password.equals("12345")) {
			throw new WrongPasswordException("비밀번호가 잘못되었습니다.");
		}
	}
}