<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	application.setAttribute("score",100);
	session.setAttribute("score",200);
	request.setAttribute("score",300);
	pageContext.setAttribute("score",400);
	// pageContext > request > session > application

	out.print("<h1>당신의 점수</h1");
	
%>    

<%
// 오류 일으키기(TEST)
int a = 10/0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>점수1 : ${applicationScope.score}</p>
	<p>점수2 : ${sessionScope.score}</p>
	<p>점수3 : ${requestScope.score}</p>
	<p>점수4 : ${pageScope.score}</p>
	<p>점수5 : ${score}</p>
</body>
</html>