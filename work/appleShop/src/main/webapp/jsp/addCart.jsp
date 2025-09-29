<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품고르기</h1>
	<form action="addcart.do" method="post">
		<input type="radio" name="product" value="no">상품없음
		<input type="radio" name="product" value="tv" checked="checked">텔레비젼
		<input type="radio" name="product" value="notebock">노트북
		<input type="radio" name="product" value="pc">PC
		<br>
		<input type="number" name="count" value="10">
		<input type="submit" value="장바구니담기">
		<input type="button" onclick="location.href='viewcart.do'" value="장바구니보기">
	</form>
</body>
</html>