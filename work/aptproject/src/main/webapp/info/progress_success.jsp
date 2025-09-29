<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계약완료 페이지</title>
<link rel="stylesheet" type="text/css" href="${cpath}/info/progress_success.css">
<script src="${cpath}/info/progress_success.js"></script>
<script src="https://cdn.jsdelivr.net/npm/canvas-confetti@1.6.0/dist/confetti.browser.min.js"></script>
</head>
<body>
  <div class="celebration">
    <div class="overlay">
      <h1>🎉 ${sessionScope.name}님, 계약이 성공적으로 완료되었습니다!</h1>
      <p>이제 새로운 보금자리가 기다리고 있습니다.</p>
      <p class="subtext">앞으로의 여정에 행복이 가득하시길 바랍니다.</p>
      <br><br>
      	<p>접수번호: ${sessionScope.bno}번</p>
		<p>이름: ${sessionScope.name}</p>
		<p>주민번호: ${sessionScope.reg_no}</p>
		<p>전화번호: ${sessionScope.phone}</p>
		<p>주소: ${sessionScope.address}</p>
		<p>신청 평수: ${sessionScope.housing_area}평</p>
      <a href="${cpath}/main" class="home-btn">내정보 수정하기</a>
    </div>
  </div>
</body>
</html>




