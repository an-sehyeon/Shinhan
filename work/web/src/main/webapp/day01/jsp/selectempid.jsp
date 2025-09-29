<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
EmpService eService = new EmpService();
List<EmpDTO> emplist = eService.selectAll();

String job = request.getParameter("job");
String job_name = null;
if(job.equals("detail")) {
	job_name = "조회";
} else if(job.equals("delete")) {
	job_name = "삭제";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직원 <%=job_name%></h1>
	<hr>
	<form action="emp<%=job%>.jsp">
		<%
			if(job_name.equals("삭제")) {
				out.print("<input type='hidden' name='job' value='update'>");
			}
		%>
		<fieldset>
			<label>직원ID: </label>
			<select name="emp_id">
				<%
					for(EmpDTO emp : emplist) {
						out.print("<option>" + emp.getEmployee_id() + "</option>");
					}
				%>
			</select>
			<input type="submit" value="<%=job_name%>">
			<input type="button" onclick="location.href='/webshop/day1/emp.html'" value="취소">
		</fieldset>
	</form>
</body>
</html>