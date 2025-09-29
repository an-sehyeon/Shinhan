<%@page import="com.shinhan.dept.DeptDAO"%>
<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int deptid = Integer.parseInt(request.getParameter("dept_id"));
DeptService dService = new DeptService();
DeptDTO dept = dService.selectById(deptid);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#delete_button { color: red; }
</style>
</head>
<body>
	<h1><%=dept.getDepartment_name()%> 부서 삭제</h1>
	<hr>
	<form action="/web/day02/jsp/deptupdate.jsp">
		<input type="hidden" name="job" value="delete">
		<fieldset>
			<label>부서코드: </label><input readonly="readonly" type="number" name="department_id" value="<%=dept.getDepartment_id()%>"> <br>
			<label>부서이름: </label><input readonly="readonly" name="department_name" value="<%=dept.getDepartment_name()%>"> <br>
			<label>매니저번호: </label><input readonly="readonly" name="manager_id" value="<%=dept.getManager_id()%>"> <br>
			<label>지역코드: </label><input readonly="readonly" name="location_id" value="<%=dept.getLocation_id()%>"> <br>
		</fieldset>
		<fieldset>
			<input id="delete_button" type="submit" value="삭제">
			<input type="button" onclick="location.href='/web/day02/dept.html'" value="취소">
		</fieldset>
	</form>
</body>
</html>