<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String data = request.getParameter("manager_id");
Integer mgr_id = (data == null || data.trim().isEmpty())?0:Integer.parseInt(data);

data = request.getParameter("location_id");
Integer loc_id = (data == null || data.trim().isEmpty())?0:Integer.parseInt(data);

String dept_name = request.getParameter("department_name");
int dept_id = Integer.parseInt(request.getParameter("department_id"));
/* int mgr_id = Integer.parseInt(request.getParameter("manager_id"));
int loc_id = Integer.parseInt(request.getParameter("location_id")); */

DeptService dService = new DeptService();
DeptDTO dept = DeptDTO.builder()
				.department_id(dept_id)
				.department_name(dept_name)
				.manager_id(mgr_id)
				.location_id(loc_id)
				.build();

String job = request.getParameter("job");
String job_name = null;
if(job.equals("insert")) {
	dService.insertDept(dept);
	job_name = "입력";
} else if(job.equals("update")) {
	dService.updateDept(dept);
	job_name = "수정";
} else if(job.equals("delete")) {
	dService.deleteDept(dept_id);
	job_name = "삭제";
} else {
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, th, td { 
		border: 1px solid black;
		border-collapse: collapse;
		text-align: center;
	}
	th, td { padding: 3px; }
</style>
</head>
<body>
	<h1><%=dept_name%> 부서 <%=job_name%>완료</h1>
	<hr>
		<table>
		<thead>
			<tr>
				<th>부서코드</th>
				<th>부서이름</th>
				<th>매니저번호</th>
				<th>지역코드</th>
			</tr>
		</thead>
		<tbody>
			<%
				if(!job.equals("delete")) {
					out.print("<tr>");
					out.print("<td>" + dept.getDepartment_id() + "</td>");				
					out.print("<td>" + dept.getDepartment_name() + "</td>");				
					out.print("<td>" + dept.getManager_id() + "</td>");				
					out.print("<td>" + dept.getLocation_id() + "</td>");				
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>
	<br>
	<button onclick="location.href='/web/day02/jsp/deptlist.jsp'">목록보기</button>
	
</body>
</html>