<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계약 포기 안내</title>
<link rel="stylesheet" type="text/css"
	href="${cpath}/info/progress_cancel.css">
<script src="${cpath}/info/progress_cancel.js"></script>
<link rel="stylesheet" href="${cpath}/info/contract_cancel.css">
</head>
<body>

	<canvas id="lightCanvas"></canvas>

	<div class="message-box">
		<h1>💫 힘든 결정이셨겠지만,</h1>
		<h2>${sessionScope.name}님,</h2>
		<p>앞으로 펼쳐질 더 좋은 미래를 응원합니다.</p>
		<p>지금은 잠시 멈춰서지만, 새로운 길은 언제나 열려있습니다.</p>
		<br>
		<p>계약은 정상적으로 <strong>포기 처리</strong>되었습니다.</p>
		<a href="${cpath}/main" class="home-btn">로그아웃</a>
	</div>
</body>
</html>


