<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//자바땅, 스크립트릿 문법 사용가능, WAS가 해석
//내장객체를 제공 : 요청(request)
String name1 = request.getParameter("username1");
String name2 = request.getParameter("username2");
String password = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>파라메터1 : <%=name1 %></p>
	<p>파라메터2 : <%=name2 %></p>
	<p>파라메터3 : <%=password %></p>
</body>
</html>