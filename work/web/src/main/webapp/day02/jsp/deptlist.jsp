<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //자바영역 ... (JSP: JAVA + HTML) 자바로 작성된 서버프로그램(WAS해석...결과는 HTML)
//MVC1모델...자바를 JSP에서 <-> MVC2모델...자바를 Servlet에서
DeptService dService = new DeptService();
List<DeptDTO> deptlist = dService.selectAll();
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
	<h1>부서목록 조회</h1>
	<hr>
	<button onclick="location.href='/web/day02/dept.html'">돌아가기</button>
	<table>
		<thead>
			<tr>
				<th>NO</th>
				<th>부서코드</th>
				<th>부서이름</th>
				<th>매니저번호</th>
				<th>지역코드</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<%
				int cnt = 1;
				for(DeptDTO dept : deptlist) {
					out.print("<tr>");
					out.print("<td>" + cnt++ + "</td>");
					out.print("<td><a href='deptdetail.jsp?dept_id=" + dept.getDepartment_id() + "'>" + dept.getDepartment_id() + "</a></td>");				
					out.print("<td>" + dept.getDepartment_name() + "</td>");				
					out.print("<td>" + dept.getManager_id() + "</td>");				
					out.print("<td>" + dept.getLocation_id() + "</td>");	
					out.print("<td><a href='deptdelete.jsp?dept_id=" + dept.getDepartment_id() + "'> 🗑 </a>" + "</td>");
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>
	<%
	for(DeptDTO dept : deptlist) {
		out.println();
	}
	%>
</body>
</html>