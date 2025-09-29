<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
pageContext.setAttribute("score", 80);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL2.JSP 페이지입니다.</h1>
	<pre>
	1.${score1} ----- 2.${score2} ----- 3.${score3} ----- 4.${score4}  
	1.${score21} ----- 2.${score22} ----- 3.${score23} ----- 4.${score24}
	<c:choose>
		<c:when test="${score>90}">
			<p>A학점</p>
		</c:when>
		<c:when test="${score>80}">
			<p>C학점</p>
		</c:when>
		<c:when test="${score>70}">
			<p>D학점</p>
		</c:when>
		<c:otherwise>
			<p>F학점</p>
		</c:otherwise>
	</c:choose>
	
	<c:set var="total" value="0"/>
	<c:forEach begin="1" end="10" step="1" var="su" varStatus="status">
		${su}
		<c:set var="total" value="${total +su }"/>
	</c:forEach>
	합계: ${total}
	<%
	pageContext.setAttribute("fruits", "망고,바나나,사과,귤");
	%>
	<c:forTokens items="${fruits}" delims="," var="f" varStatus="status">
		${status.count} -- ${f}
	</c:forTokens>
	</pre>
	<h1>지금 JSTL               연습중</h1>
	<h1>지금&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSTL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;연습중</h1>
	<p>부서상세보기</p>
	<c:redirect url="/dept/deptdetail">
		<c:param name="deptid" value="60"></c:param>
	</c:redirect>
	
</body>
</html>