<%@page import="java.util.List"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String job = request.getParameter("job_title");
EmpService service = new EmpService();
List<EmpDTO> emplist = service.selectByJob(job);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=job %> 직책의 직원 List</title>
</head>
<body>
	<h1><%=job %> 직책의 직원 List</h1>
	<hr>
	<%
	out.println("<ol>");
	for(EmpDTO emp:emplist) {
		out.println("<li>" + emp.getFirst_name() + "</li>");
	}
	%>
</body>
</html>