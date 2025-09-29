<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	// default event에 대하여
	// 이미 제공되는 이벤트 핸들러가 존재
	window.onload = function(){
		var frmObj = document.querySelector("#myfrm");
		
		
		
		// 2)고전방식으로 이벤트와 이벤트 핸들러 연결
		frmObj.onsubmit = function(event){
			deptnameObj = document.querySelector('input[name="department_name"]');
			var deptname = deptnameObj.value;
			if(deptname.length<5){
				alert("부서이름은 5자리 이상입니다.");
				deptnameObj.focus();
				
				// default event를 취소하기
				// 1) return false;		
				// 2) preventDefault()
				event.preventDefault();
				return;
			}
			alert("서버에 전송!!");
		};
	};
// 1) inline방식으로 이벤트와 이벤트 핸들러 연결
function call(){
	deptnameObj = document.querySelector('input[name="department_name"]');
	var deptname = deptnameObj.value;
	if(deptname.length<5){
		alert("부서이름은 5자리 이상입니다.");
		deptnameObj.focus();
		
		// default event를 취소하기
		return false;		
		// 2) preventDefault()
		event.preventDefault();
		//return;
	}
	alert("서버에 전송!!");
};
</script>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<h1>부서입력</h1>
	<hr>
	<!-- onsubmit="return call();" -->
	<form id="myfrm" action="${pageContext.request.servletContext.contextPath}/dept/deptinsert" method="post">
		<input type="hidden" name="job" value="insert">
		<fieldset>
			<label>부서코드: </label><input type="number" name="department_id" autofocus="autofocus"> <br>
			<label>부서이름: </label><input name="department_name"> <br>
			<label>매니저번호: </label><input name="manager_id" placeholder="존재하는 직원번호"> <br>
			<label>지역코드: </label><input name="location_id" placeholder="존재하는 지역코드"> <br>
			<label>부서소개: </label><br> <textarea rows="5" cols="80"></textarea>
		</fieldset>
		<fieldset>
			<input type="submit" value="입력">
			<input type="reset" value="다시입력">
		</fieldset>
	</form>
</body>
</html>