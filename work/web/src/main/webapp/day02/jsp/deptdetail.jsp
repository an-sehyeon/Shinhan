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
	#dept_id_input { background-color: #E1F6FA }
</style>
</head>
<body>
	<h1><%=dept.getDepartment_name()%> 부서 상세보기</h1>
	<hr>
	<form action="/web/day02/jsp/deptupdate.jsp">
		<input type="hidden" name="job" value="update"><br>
		<fieldset>
			<label>부서코드: </label><input id="dept_id_input" readonly="readonly" type="number" name="department_id" value="<%=dept.getDepartment_id()%>"> <br>
			<label>부서이름: </label><input name="department_name" value="<%=dept.getDepartment_name()%>"> <br>
			<label>매니저번호: </label><input name="manager_id" value="<%=dept.getManager_id()%>"> <br>
			<label>지역코드: </label><input name="location_id" value="<%=dept.getLocation_id()%>"> <br>
		</fieldset>
		<fieldset>
			<input type="button" onclick="location.href='/web/day02/dept.html'" value="확인">
			<input type="submit" value="수정">
		</fieldset>
	</form>
</body>
</html>