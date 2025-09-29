<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cpath}/auth/mainpage.css">
<script>
// 관리자 접속
$(function(){
	var isCheck = false;
	
	$("#adminfrm").on("submit",function(event){
		event.preventDefault(); // 기본 제출 막기
		
		var input = $("input[name='admin_input']").val().trim();
		
		if(input === ""){
			$("#here1").html("관리자번호를 입력하세요.").css("color","red");
			$("input[name=admin_input]").focus();
			return;
		}
		$.ajax({
			url:"adminkeycheck?key=" + input,
			type:"post",
			success:function(response){
				if(response == -1){
					$("#here1").html("관리자번호가 일치하지 않습니다.").css("color","red");
					$("input[name=admin_input]").val("").focus();
					isCheck = false;
				}else{
					isCheck = true;
					$("#adminfrm")[0].submit();
				}
			}
		});
	});
});
</script>
<script>
// 접수자 접속
$(function(){

		$("#userfrm").on("submit",function(event){
			event.preventDefault();
			
			var bno = $("input[name='bno']").val();
			
			$.ajax({
				url:"lottoresult.do",
				type:"post",
				data: {bno:bno},
				success:function(response){
					if(response == -1){
						$("#here2").html("일치하는 사용자가 없습니다.").css("color","red");
						$("input[name='bno']").val("").focus();
					}else{
						$("#userfrm")[0].submit();
					}
				}
			})
			
		});
});
</script>
</head>
<body>
	<h1>주택 청약 페이지</h1>
	<form id="adminfrm" action="userlist">
		관리자키 : <input name="admin_input" type="password">
		<button id="adminbtn" type="submit">로그인</button>
		<div id="here1"></div>
	</form>
	<form id="userfrm" action="lottoresult.do" method="post">
		접수번호 : <input type="number" name="bno" required>
		<button type="submit">결과 조회</button>
		<div id="here2"></div>
	</form>

</body>
</html>