<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>    
<%
	// 자바..> _jspService()내의 지역변수
	String localVar = "Local변수";
	System.out.println(subject);
	System.out.println(localVar);
%>

<%!
	/* 자바주석 */
	// 선언문
	// 멤버변수(field)
	String subject = "Servelt&JSP";
	String f1(){
		System.out.println(subject);
		return "100";
	}
%>
<%=subject %>
<%=f1() %>
<%-- JSP주석 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML주석 ${loginEmp} -->
</body>
</html>