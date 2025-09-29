<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#dept_id_input { background-color: #E1F6FA }
</style>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<h1>${ dept.department_id }번 ${ dept.department_name } 부서 상세보기</h1>
	<hr>
	<form action="${cpath}/dept/deptupdate.do" method="post">
		<input type="hidden" name="job" value="update"><br>
		<fieldset>
			<label>부서코드: </label>
			<input readonly="readonly" type="number" name="department_id" value="${ dept.department_id }"> <br>
			<label>부서이름: </label>
			<input name="department_name" value="${ dept.department_name }"> <br>
			<label>매니저번호: </label>
			<input name="manager_id" value="${ dept.manager_id }"> <br>
			<label>지역코드: </label>
			<input name="location_id" value="${ dept.location_id }"> <br>
		</fieldset>
		<fieldset>
			<input type="button" onclick="location.href='${cpath}/dept/deptlist.do'" value="확인">
			<input type="submit" value="수정">
		</fieldset>
	</form>
</body>
</html>