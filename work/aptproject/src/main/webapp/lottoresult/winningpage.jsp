<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>당첨자 페이지</title>
<link rel="stylesheet" type="text/css" href="${cpath}/lottoresult/winningpage.css">
<script src="https://cdn.jsdelivr.net/npm/canvas-confetti@1.6.0/dist/confetti.browser.min.js"></script>
</head>
<body>
  <div class="message">
  	<br><br><br><br><br><br><br><br>
    <h1>🎉 ${office.name}님 축하합니다!</h1>
    <p>청약에 당첨되셨습니다.</p>
    <br><br><br>
    <form action="${cpath}/paymentplan" method="post">
    <input type="hidden" name="bno" value="${office.bno}"/>
    <button class="button" type="submit">분양금 납부 일정</button>
    </form>
    <br><br><br><br><br><br><br><br>
  </div>
  <script>
    confetti({
      particleCount: 150,
      spread: 70,
      origin: { y: 0.6 }
    });
  </script>
</body>
</html>