<%@page import="com.shinhan.job.JobDAO"%>
<%@page import="com.shinhan.job.JobDTO"%>
<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int emp_id = Integer.parseInt(request.getParameter("emp_id"));

EmpService eService = new EmpService();
EmpDTO emp = eService.selectById(emp_id);

DeptService dService = new DeptService();
List<DeptDTO> deptlist = dService.selectAll();

List<JobDTO> joblist = new JobDAO().getAllJobs();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#emp_id_input { background-color: #E1F6FA }
</style>
</head>
<body>
	<h1> <%=emp_id %>번 직원 상세보기</h1>
	<hr>
	<form action="empupdate.jsp" method="post">
		<input type="hidden" name="job" value="update">
		<fieldset>
			<label>직원번호: </label><input id="emp_id_input" readonly="readonly" type="number" name="employee_id" value="<%=emp.getEmployee_id()%>"><br>
			<label>성: </label><input type="text" name="first_name" value="<%=emp.getFirst_name()%>"><br>
			<label>이름: </label><input type="text" name="last_name" value="<%=emp.getLast_name()%>"><br>
			<label>이메일: </label><input name="email" value="<%=emp.getEmail()%>"><br>
			<label>급여: </label><input type="number" name="salary" value="<%=emp.getSalary()%>"><br>
			<label>부서: </label>
			<select name="department_id">
				<%
					for(DeptDTO dept : deptlist) {
						out.print("<option "); 
						if(emp.getDepartment_id() == dept.getDepartment_id()) {
							out.print("selected='selected' ");
						}
						out.print("value='" + dept.getDepartment_id() + "'>");
						out.print(dept.getDepartment_name());
						out.print("</option>");
					}
				%>
			</select><br>
			<label>커미션: </label><input type="number" name="commission_pct" value="<%=emp.getCommission_pct()%>"><br>
			<label>매니저: </label><input type="number" name="manager_id" value="<%=emp.getManager_id()%>"><br>
			<label>전화번호: </label><input name="phone_number" value="<%=emp.getPhone_number()%>"><br>
			<label>직책: </label>
			<select name="job_id">
				<%
					for(JobDTO job : joblist) {
						out.print("<option ");
						if(emp.getJob_id().equals(job.getJobId())) {
							out.print("selected ");
						}
						out.print("value='" + job.getJobId() + "'>");
						out.print(job.getJobId());
						out.print("</option>");
					}
				%>
			</select><br>
			<label>입사일: </label><input type="date" name="hire_date" value="<%=emp.getHire_date()%>"><br>
		</fieldset>
		<fieldset>
			<input type="button" onclick="location.href='/webshop/day1/emp.html'" value="확인">
			<input type="submit" value="수정">
		</fieldset>
	</form>
</body>
</html>