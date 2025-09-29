<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<script src="loginExternal.js">

</script>
<title>로그인</title>
</head>
<body>
	<h1>현재 접속자수 : ${activeSessions}</h1>
	<h1>로그인</h1>
	<div class="container mt-3">
		<!-- default path : http://localhost:9090 -->
		<h2>contextPath : ${cpath} </h2>
		<form action="${cpath}/auth/login" method="post" id="myfrm">
			<div class="mb-3 mt-3">
				<label for="email">사용자아이디(직원번호):</label> 
				<input type="number" class="form-control" id="email" placeholder="id 입력" name="userid">
			</div>
			<div class="mb-3">
				<label for="pwd">Password:</label> 
				<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
			</div>
			<div class="form-check mb-3">
				<label class="form-check-label"> 
				<input class="form-check-input" type="checkbox" value="ok" name="remember">
					Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">로그인</button>
			
			<h2>parameter test하기</h2>
			<label class="form-check-label"> 
				<input class="form-check-input" type="checkbox" name="subject" value="java">자바
			</label>
			<label class="form-check-label"> 
				<input class="form-check-input" type="checkbox" name="subject" value="db">데이터베이스
			</label>
			<label class="form-check-label"> 
				<input class="form-check-input" type="checkbox" name="subject" value="web">웹
			</label>
		</form>
		<script>
			var message = "${info}";
			if(message != ""){
				alert(message);
			} 
		</script>
		<c:set var="info" value="" scope="session"/>
		<%--session.setAttribute("info","") 와 같은 의미 --%>
	</div>
</body>
</html>