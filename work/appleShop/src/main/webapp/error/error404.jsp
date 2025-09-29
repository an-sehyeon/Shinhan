<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:red;">존재하지 않는 주소입니다.</h1>
	<p>${request.Context.request.servletContext.contextPath}</p>
	<div id="here"></div>
<script>
	// 사용자가 잘못 작성한 주소 출력
	here.innerHTML = location.href
</script>
</body>
</html>