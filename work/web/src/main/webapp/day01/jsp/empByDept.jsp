<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int deptid = Integer.parseInt(request.getParameter("dept_id")); 
DeptService deptService = new DeptService();
DeptDTO deptDTO = deptService.selectById(deptid);
String dept = deptDTO.getDepartment_name();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= dept %> 부서의 직원 List</title>
</head>
<body>

	<h1> <%= dept %> 부서의 직원 List</h1>
	<hr>
	<%
	EmpService empService = new EmpService();
    List<EmpDTO> emplist = empService.selectByDept(deptid);
	out.println("<ol>");
	for(EmpDTO emp : emplist) {
		out.println("<li>" + emp.getFirst_name() + "</li>");
	}
	%>
</body>
</html>