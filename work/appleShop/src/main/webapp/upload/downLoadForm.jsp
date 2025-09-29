<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글목록</h1>
	<%@include file="../common/header.jsp"%>

	<table class="table striped">
		<tr>
			<th>번호</th>
			<th>title</th>
			<th>작성자</th>
			<th>내용</th>
			<th>이미지1</th>
			<th>이미지2</th>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.bno}</td>
				<td>${board.title}</td>
				<td>${board.writer}</td>
				<td>${board.content}</td>
				<td><a href="${cpath}/download.do?fileName=${board.pic1}">
						<img style="border: 5px dotted green;"
						src="${cpath}/uploadLocation/${board.pic1}" width="100"
						height="100"/></a>
				</td>
				<td><a href="${cpath}/download.do?fileName=${board.pic2}">
						<img style="border: 5px dotted green;"
						src="${cpath}/uploadLocation/${board.pic2}" width="100"
						height="100"/></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>