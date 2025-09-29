<%@page import="com.shinhan.job.JobDAO"%>
<%@page import="com.shinhan.job.JobDTO"%>
<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
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
	label {
		display: inline-block;
		width: 75px;
		text-align: center;
		padding: 1px;
	}
	select, input#calender {
		text-align: center;
		width: 170px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src ="empinsert.js"></script>
<script>
$(function(){
	$("#btn1").on("click",f5);
});
function f5(){
	var arr = [	{name:"네이버", link:"http://www.naver.com"},
				{name:"다음", link:"http://www.daum.com"},
				{name:"구글", link:"http://www.google.com"}
		];
	// JSP문법 : \${aa}....aa에 저장된 값을 출력 getAttribute()
	// back tick : \${bb}....bb에 저장된 값을 출력, 서버해석막기
	var bb = 200;
	var s =`--------------------${bb}---------------------`;
	console.log(s);
	var ss =`--------------------\${bb}---------------------`;
	console.log(ss);
	
	var str ="<ul>";
	$.each(arr, function(index, item){
		str += `<li><a href="\${item.link}">\${item.name}</a></li>`;
	});
	$("#here").html(str + "</ul>");
};

</script>

</head>
<body>
	<button id="btn1">jQuery연습</button>
	<div id="here">여기
	</div>
	<h1>직원등록</h1>
	<button id="btnAjax">직원입력(Ajax)</button>
	
	<hr>
	<form action="/web/day01/jsp/empupdate.jsp">
		<input type="hidden" name="job" value="insert">
		<fieldset>
			<label>직원번호: </label><input type="number" name="employee_id" autofocus="autofocus"><br>
			<label>성: </label><input type="text" name="first_name""><br>
			<label>이름: </label><input type="text" name="last_name""><br>
			<label>이메일: </label><input name="email""><br>
			<label>급여: </label><input type="number" name="salary""><br>
			<label>부서: </label>
			<select name="department_id">
				<%
					for(DeptDTO dept : deptlist) {
						out.print("<option value='" + dept.getDepartment_id() + "'>");
						out.print(dept.getDepartment_name());
						out.print("</option>");
					}
				%>
			</select><br>
			<label>커미션: </label><input type="number" name="commission_pct"><br>
			<label>매니저: </label><input type="number" name="manager_id"><br>
			<label>전화번호: </label><input name="phone_number"><br>
			<label>직책: </label>
			<select name="job_id">
				<%
					for(JobDTO job : joblist) {
						out.print("<option value='" + job.getJobId() + "'>");
						out.print(job.getJobId());
						out.print("</option>");
					}
				%>
			</select><br>
			<label>입사일: </label><input type="date" name="hire_date" id="calender"><br>
		</fieldset>
		<fieldset>
			<input type="submit" value="입력">
			<input type="reset" value="초기화">
			<input type="button" onclick="location.href='/web/day01/emp.html'" value="돌아가기">
		</fieldset>
	</form>
</body>
</html>