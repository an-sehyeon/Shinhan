package com.shinhan.day09;

/*
 * MVC2모델
 * Controller(C) 	-> 사용자와 소통(요청과 응답)
 * Service(Model)	-> 업무로직 (요청처리)
 * DAO(Model)		-> DB의 업무(CRUD작업)
 * DTO(Model)		-> Date Transfer 하기위한 설계
 * View(V)			-> display
 * */

public class StudentController {

	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAO();
		StudentService service = new StudentService(dao);
		
		StudentDTO[] arr = service.findAll();
		StudentView.print(arr);
		
		StudentView.print(service.findById("12345"));
		
		StudentDTO a =  new StudentDTO("12345", "홍길동");
		StudentDTO b = new StudentDTO("12345", "홍길동1");
		System.out.println(a.equals(b));
	}
}
