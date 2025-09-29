<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 2페이지입니다.</h1>
	<%
	String name="자바";
	%>
	<h2>2.jsp페이지에서 Bean값 얻기</h2>
	<jsp:useBean id="dept" class="dept.DeptDTO" scope="session"/>
	부서번호 : <jsp:getProperty property="department_id" name="dept"/>
	부서이름 : <jsp:getProperty property="department_name" name="dept"/>
</body>
</html>

