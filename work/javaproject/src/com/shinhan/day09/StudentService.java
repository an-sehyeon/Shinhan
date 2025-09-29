package com.shinhan.day09;

// 비지니스 로직 처리
public class StudentService {
	
	StudentDAO dao;
	
	StudentService(StudentDAO dao){
		this.dao = dao;
	}

	
	public StudentDTO[] findAll() {
		System.out.println("===모든 학생 조회서비스입니다.===");
		return dao.selectAll();
	}
	
	public StudentDTO findById(String id) {
		System.out.println("===특정 학생 조회서비스입니다.===");
		return dao.selectById(id);
	}
}
