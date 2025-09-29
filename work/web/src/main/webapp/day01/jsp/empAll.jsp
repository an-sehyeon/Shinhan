<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
EmpService eService = new EmpService();
List<EmpDTO> emplist = eService.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="empAll.js"></script>
<script>
$(()=>{
	// ()=> {} 화살표함수에서 this는 window, bind()함수로 object를 bind()하여 this설정가능
	$("#search").on("keyup",function(){
		var inputData = $(this).val();
		console.log(inputData);
		$("tbody tr").hide();
		$(`td:contains(\${inputData})`).parent().show();		// <tr><td>aa</td></tr>
	});
	
	
});
</script>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<title>emp_all_list</title>
<style>
	h1 { text-align: center; margin-top: 20px; }
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
		text-align: center;
	}
	
	h2 { text-align: center; }
	
	th, td { padding: 3px; }
	
	thead tr { background: #EADCF8; border-bottom: 2px solid black; }
	
	tbody tr:nth-child(2n){ background-color: #DFF5E1;}
	tbody tr:nth-child(2n+1) { background-color: #FFE5EC; }
	
	/* td[first_name *= 'e'] { background-color: #FFE65A; }
	
	td[email ^= 'S'] { background-color: #BEF5BE; }
	
	td[dept_id *= '60'] { background-color: skyblue; }
	
	td[salary_over_8000 = 'true'] { background-color: pink; }  */
	
	#container {
		width: 1000px;
		margin: 0 auto;
	}
	
</style>
</head>
<body>
  <div id="container">
	<h1 class="title">직원목록 조회</h1>
	<button type="button" onclick="location.href='/web/day01/jsp/empinsert.jsp'" class="btn btn-success">신규직원등록</button>
	<button type="button" onclick="location.href='/web/index.html'" class="btn btn-info">컴백홈</button>
	<hr>
	급여: <input type="number" id="salaryInput">이상
	<button id="selectbtn">직원찾기(스타일변경)</button>
	<button id="resetbtn">초기화</button>
	<br>
	찾을문자 <input type="text" id="search">
	
	<br><br>
	<hr>
	<div id="s_list"></div>
	<br><br>
	<table>
		<thead>
			<tr>
				<th>NO</th>
				<th>직원번호</th>
				<th>이름</th>
				<th>성</th>
				<th>이메일</th>
				<th>급여</th>
				<th>부서</th>
				<th>커미션</th>
				<th>매니저</th>
				<th>전화번호</th>
				<th>직책</th>
				<th>입사일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		<%
			int cnt = 1;
			for(EmpDTO emp : emplist) {
				out.print("<tr>");
				out.print("<td>"+ cnt++ + "</td>");
				out.print("<td><a href='empdetail.jsp?emp_id=" + emp.getEmployee_id() + "'>" + emp.getEmployee_id() + "</a></td>");
				out.print("<td first_name='" + emp.getFirst_name() + "'>"+ emp.getFirst_name() + "</td>");
				out.print("<td>"+ emp.getLast_name() + "</td>");
				out.print("<td email='" + emp.getEmail() + "'>"+ emp.getEmail() + "</td>");
				out.print("<td class='salary' salary_over_8000='" + (emp.getSalary()>8000?"true":"false") + "'>"+ emp.getSalary() + "</td>");
				out.print("<td dept_id='" + emp.getDepartment_id() + "'>"+ emp.getDepartment_id() + "</td>");
				out.print("<td>"+ emp.getCommission_pct() + "</td>");
				out.print("<td>"+ emp.getManager_id() + "</td>");
				out.print("<td>"+ emp.getPhone_number() + "</td>");
				out.print("<td>"+ emp.getJob_id() + "</td>");
				out.print("<td>"+ emp.getHire_date() + "</td>");
				out.print("<td><button type='button' class='btn btn-danger' onclick=\"location.href='empdelete.jsp?emp_id="
					    + emp.getEmployee_id()
					    + "'\">🗑</button></td>");
				out.print("</tr>");
			}
		%>
	</tbody>	
	</table>
  </div>
</body>
</html>