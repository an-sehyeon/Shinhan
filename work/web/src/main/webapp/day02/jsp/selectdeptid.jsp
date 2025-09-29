<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
DeptService dService = new DeptService();
List<DeptDTO> deptlist = dService.selectAll();

String job = request.getParameter("job");
String job_name = null;
if(job.equals("detail")) job_name = "조회";
else if(job.equals("delete")) job_name = "삭제";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 <%=job_name%></h1>
	<hr>
	<form action="dept<%=job%>.jsp">
		<fieldset>
			<label>부서ID: </label>
			<select name="dept_id">
				<%
					for(DeptDTO dept : deptlist) {
						out.print("<option value='" + dept.getDepartment_id() + "'>" + dept.getDepartment_name() + "</option>");
					}
				%>
			</select>
			<input type="submit" value="<%=job_name%>">
			<input type="button" onclick="location.href='/web/day02/dept.html'" value="취소">
		</fieldset>
	</form>
</body>
</html>