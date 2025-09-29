<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="score1" value="100" scope="page"/>
<c:set var="score2" value="200" scope="request"/>
<c:set var="score3" value="300" scope="session"/>
<c:set var="score4" value="400" scope="application"/>
<%
pageContext.setAttribute("score21", 99);
request.setAttribute("score22", 98);
session.setAttribute("score23", 97);
application.setAttribute("score24", 96);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
	1.${score1} ----- 2.${score2} ----- 3.${score3} ----- 4.${score4}  
	2.${score21} ----- 2.${score22} ----- 3.${score23} ----- 4.${score24}
	
	</pre>
	<c:import url="jstlTest2.jsp"></c:import>
</body>
</html>