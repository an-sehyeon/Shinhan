<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="cpath" value="${pageContext.servletContext.contextPath}"/>   


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<h1>카트에 저장된 상품정보(session)</h1>
	<table>
		<tr>
			<th>상품명</th>
			<th>갯수</th>
		</tr>	
		<c:forEach items="${cart}" var="entry">
			<tr>
				<td>${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</table>
	<a class ="btn btn-success" href="${cpath}/removecart.do">장바구니 비우기</a>
	<a class ="btn btn-danger" href="${cpath}/addcart2.do">장바구니 담기</a>
</body>
</html>