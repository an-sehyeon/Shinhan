<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int emp_id = Integer.parseInt(request.getParameter("emp_id"));
EmpService eService = new EmpService();
EmpDTO emp = eService.selectById(emp_id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#delete_button { color: red }
</style>
</head>
<body>
	<h1><%= emp.getFirst_name() + (emp.getFirst_name().matches("^[가-힣]+$") ? "" : " ") + emp.getLast_name() %> 직원 삭제</h1>
	<hr>
	<form action="empupdate.jsp">
		<input type="hidden" name="job" value="delete">
		<fieldset>
			<label>직원번호: </label><input readonly="readonly" type="number" name="employee_id" value="<%=emp.getEmployee_id()%>"> <br>
			<label>성: </label><input readonly="readonly" name="first_name" value="<%=emp.getFirst_name()%>"> <br>
			<label>이름: </label><input readonly="readonly" name="last_name" value="<%=emp.getLast_name()%>"> <br>
			<label>이메일: </label><input readonly="readonly" name="email" value="<%=emp.getEmail()%>"> <br>
			<label>급여: </label><input readonly="readonly" name="salary" value="<%=emp.getSalary()%>"> <br>
			<label>부서: </label><input readonly="readonly" name="department_id" value="<%=emp.getDepartment_id()%>"> <br>
			<label>커미션: </label><input readonly="readonly" name="commission_pct" value="<%=emp.getCommission_pct()%>"> <br>
			<label>매니저: </label><input readonly="readonly" name="manager_id" value="<%=emp.getManager_id()%>"> <br>
			<label>전화번호: </label><input readonly="readonly" name="phone_number" value="<%=emp.getPhone_number()%>"> <br>
			<label>직책: </label><input readonly="readonly" name="job_id" value="<%=emp.getJob_id()%>"> <br>
			<label>입사일: </label><input readonly="readonly" name="hire_date" value="<%=emp.getHire_date()%>"> <br>
		</fieldset>
		<fieldset>
			<input id="delete_button" type="submit" value="삭제">
			<input type="button" onclick="location.href='/web/day01/jsp/empAll.jsp'" value="취소">
		</fieldset>
	</form>
</body>
</html>