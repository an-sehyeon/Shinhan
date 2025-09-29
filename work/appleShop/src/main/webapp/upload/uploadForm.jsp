<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp" %>    
<%-- <jsp:include page="../common/header.jsp"></jsp:include> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload Test</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="${cpath}/upload.do" method="post" enctype="multipart/form-data">
	 제목 : <input type="text" name="title" value="신한DS"><br>
	 내용 : <textarea rows="5" cols="80" name="content"></textarea><br>
	 작성자 : <input type="text" name="writer" value="길동"><br>
	 첨부파일1 : <input type="file" name="pic1"><br>
	 첨부파일2 : <input type="file" name="pic2"><br>
	 <input type="submit" value="게시글등록">
	</form>
</body>
</html>