<%@page import="com.shinhan.emp.DateUtil"%>
<%@page import="java.sql.Date"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
EmpService eService = new EmpService();
EmpDTO emp = EmpDTO.builder().build();

//get방식으로 주소창에 parameter가 넘어오면 자동으로 data가 encoding → 읽을 때 다시 decoding.
//(공백: %2- | 한그리 %???)
//post방식은 요청문서의 body에 encoding이 없어 한글깨짐 → 읽기 전에 encoding 설정하고 읽음
request.setCharacterEncoding("UTF-8");

int employee_id = Integer.parseInt(request.getParameter("employee_id"));
String first_name = request.getParameter("first_name");
String last_name = request.getParameter("last_name");
String email = request.getParameter("email");
double salary = Double.parseDouble(request.getParameter("salary"));
int department_id = Integer.parseInt(request.getParameter("department_id"));
double commission_pct = Double.parseDouble(request.getParameter("commission_pct"));
int manager_id = Integer.parseInt(request.getParameter("manager_id"));
String phone_number = request.getParameter("phone_number");
String job_id = request.getParameter("job_id");
Date hire_date = DateUtil.converToSQLDate(DateUtil.converToDate(request.getParameter("hire_date")));

emp.setEmployee_id(employee_id);
emp.setFirst_name(first_name);
emp.setLast_name(last_name);
emp.setEmail(email);
emp.setSalary(salary);
emp.setDepartment_id(department_id);
emp.setCommission_pct(commission_pct);
emp.setManager_id(manager_id);
emp.setPhone_number(phone_number);
emp.setJob_id(job_id);
emp.setHire_date(hire_date);

String job = request.getParameter("job");
String job_name = null;
if(job.equals("insert")) {
	job_name = "입력";
	eService.empInsert(emp);
} else if(job.equals("update")) {
	job_name = "수정";
	eService.empUpdate(emp);	
} else if(job.equals("delete")) {
	job_name = "삭제";	
} else {
	return;
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
		text-align: center;
	}
	th, td { padding: 3px; }
</style>
</head>
<body>
	<h1><%=emp.getEmployee_id()%>번 직원 <%=job_name%>완료</h1>
	<hr>
		<table>
		<thead>
			<tr>
				<th>직원번호</th>
				<th>성</th>
				<th>이름</th>
				<th>이메일</th>
				<th>급여</th>
				<th>부서</th>
				<th>커미션</th>
				<th>매니저</th>
				<th>전화번호</th>
				<th>직책</th>
				<th>입사일</th>
			</tr>
		</thead>
		<%
			out.print("<tr>");
			out.print("<td>"+ emp.getEmployee_id() + "</a></td>");
			out.print("<td>"+ emp.getFirst_name() + "</td>");
			out.print("<td>"+ emp.getLast_name() + "</td>");
			out.print("<td>"+ emp.getEmail() + "</td>");
			out.print("<td>"+ emp.getSalary() + "</td>");
			out.print("<td>"+ emp.getDepartment_id() + "</td>");
			out.print("<td>"+ emp.getCommission_pct() + "</td>");
			out.print("<td>"+ emp.getManager_id() + "</td>");
			out.print("<td>"+ emp.getPhone_number() + "</td>");
			out.print("<td>"+ emp.getJob_id() + "</td>");
			out.print("<td>"+ emp.getHire_date() + "</td>");
			out.print("</tr>");
			
			if(job.equals("delete")) {
				eService.empDeleteById(employee_id);
			}
		%>
	</table>
	<br>
	<button onclick="location.href='empAll.jsp'">목록보기</button>
</body>
</html>