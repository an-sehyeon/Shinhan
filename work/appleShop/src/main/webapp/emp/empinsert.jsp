<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jsp 정적,동적 자원 실습 -->
<!-- 정적자원, jsp를 합쳐서 컴파일한다.(.java) -> class -> jsp실행 -->
<%@ include file="../common/header.jsp" %>
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
	<!-- 동적자원, 각각의 jsp를 컴파일후에 함친다. JSTL은 자동으로 contextpath인식 -->
	<%-- <c:import url="/common/header.jsp"></c:import> --%>
	<!-- HTML tag는 자동으로 contextpath인식못함 -->
	<br>
	<img src="${cpath}/images/healing.jpg" width="100" height="100"/>
	<h1>신규 직원 등록</h1>
	<input type="button" onclick="location.href='${cpath}/emp/emplist.do'" value="돌아가기">
	<br>
	<hr>
	<form id="myfrm" action="${cpath}/emp/empinsert.do" method="post">
		<input type="hidden" name="job" value="update">
		<fieldset>
			<label>직원번호: </label>
			<input id="emp_id_input" type="number" name="employee_id">
			<span id="here">?????</span><br>
			<label>성: </label><input type="text" name="first_name"><br>
			<label>이름: </label><input type="text" name="last_name"><br>
			<label>이메일: </label><input name="email"><br>
			<label>급여: </label><input type="number" name="salary"><br>
			<label>커미션: </label><input type="number" name="commission_pct"><br>
			<label>매니저:</label>
			<select name="manager_id">
				<c:forEach items="${managerId}" var="mid">
					<option value="${mid}">
						${mid}
					</option>
				</c:forEach>
			</select><br>
			<label>전화번호: </label><input name="phone_number"><br>
			<label>부서: </label>
			<select name="department_id">
				<c:forEach items="${deptlist}" var="dept">
					<option value = "${dept.department_id}" ${dept.department_id == emp.department_id?"selected":""}>
						${dept.department_name}
					</option>
				</c:forEach>
			</select><br>
			<label>직책: </label>
			<select name="job_id">
				<c:forEach items="${joblist}" var="job">
					<option ${job.jobId == emp.job_id?"selected":""}>${job.jobId}</option>
				</c:forEach>
			</select><br>
			<label>입사일: </label><input type="date" name="hire_date"><br>
		</fieldset>
		<fieldset>
			<input type="submit" value="등록">
		</fieldset>
	</form>
<script>
 $(function(){
	 var isSave = true;
	 
	 $("#myfrm").on("submit",function(event){
		if(!isSave){
			alert("직원번호 입력확인!!!");
			$("input[name='employee_id']").focus();
			event.preventDefault();		// default이벤트 취소
			return;
		} 
	 });
	 
	 $("input[name='employee_id']").on("change",function(){
		 var input_empid = $(this).val();
		 
		 $.ajax({
			url:"getEmpById.do?empid=" + input_empid,
			success: function(response){
				// response = 0이면 없음(가능), -1이면 있음(불가능)
				if(response==0){
					$("#here").html("가능한 아이디입니다.");
					$("#here").css("color","blue");
					isSave = true;
				}else{
					$("#here").html("불가능한 아이디입니다.");
					$("#here").css("color","red");
					$(this).val("");
					$(this).focus();
					isSave = false;
				}
			}
		 });
	 });
	 
 });
</script>	
</body>
</html>