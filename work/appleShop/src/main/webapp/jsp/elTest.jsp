<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL(expression Language)</h1>
	<%String subject = "자바"; 
	  pageContext.setAttribute("data", subject);	
	%>
	<pre>
	1.Script Let 표현식 : <%=subject %>
	2.EL표현식(변수접근불가) : ${subject==null?"값이없음":subject }
	3.EL표현식(getAttribute) : ${data }
	4.EL의 내장객체도있음 : ${sessionScope.dept}
	5.data type : ${100} ${"문자"} ${10>20} ${10+20} ${"100" + 1}
	${"100"+"1"} ${"100"}점
	6.eq : ${100==100}
	6.eq : ${"100"=="100"}
	6.eq : ${"100" eq "100"}
	6.eq : ${data eq "자바"}
	6.eq : ${data eq "자바!!"}
	7.논리연산자 : ${data eq "자바!!" || "100" eq "100" }
	7.논리연산자 : ${data eq "자바!!" or "100" eq "100" }
	7.논리연산자 : ${data eq "자바!!" and "100" eq "100" }
	7.논리연산자 : ${data eq "자바!!" && "100" eq "100" }
	<%
	ArrayList<String> datas = new ArrayList<>();
	datas.add("자바");
	pageContext.setAttribute("datalist", datas);
	pageContext.setAttribute("lunch", "");
	%>
	8.empty : ${empty datalist }	<!-- empty : 데이터가 비어있는지 확인 -->
	8.empty : ${empty lunch }	<!-- empty : 데이터가 비어있는지 확인 -->
	8.empty : ${not empty lunch }
	9.EL의 내장객체 : scope(pageScope, requestScope, sessionScope, applicationScope)
	9.EL의 내장객체(param) : ${param.name}
	9.EL의 내장객체(param) : ${paramValues.myage}
	9.EL의 내장객체(header) : ${header.user-agent}
	<c:forEach items="${paramValues.myage}" var="age">
		<p>${age}</p>
	</c:forEach>
	
	scriptlet Expression 이용 : <%=request.getParameter("name") %>
	</pre>
</body>
</html>