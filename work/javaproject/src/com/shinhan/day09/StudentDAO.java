package com.shinhan.day09;

// DB로직
// DAO(Data Access Object)
public class StudentDAO {

	StudentDTO[] arr = new StudentDTO[5];
	
	{	// instance block -> new시에 자동실행
		arr[0] = new StudentDTO("12345", "홍길동");
		arr[1] = new StudentDTO("12346", "옹기동","컴동",4);
		arr[2] = new StudentDTO("12347", "공길동");
		arr[3] = new StudentDTO("12348", "종길동","컴동",3);
		arr[4] = new StudentDTO("12349", "송길동");
	}
	
	
	public StudentDTO[] selectAll() {

		return arr;
	}
	
	public StudentDTO selectById(String stdId) {
		for(StudentDTO st : arr) {
			if(st.getStdId().equals(stdId)) return st;
		}
		System.out.println("학번에 해당하는 학생이 존재하지 않습니다.");
		return null;
	}
	
}
