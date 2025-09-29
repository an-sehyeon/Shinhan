<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(()=>{
	$("#s_btn").on("click",f_search);
	$("#reset").on("click",f_reset);
	
	// 초기화버튼
	function f_reset(){
		// 모든 테이블 행을 가져옴
	    var rows = document.querySelectorAll("tr");

	    // 각 행의 배경색을 초기화
	    /* rows.forEach((row) => {
	        row.style.backgroundColor = ""; // 원래 색으로 복원
	    }); */

	    // 입력창의 값을 초기화
	    document.getElementById("s_input").value = "";
	    
	    // div영역의 결과도 초기화
	    document.getElementById("s_list").innerHTML = "";
	};
	
	
	// #s_btn 클릭시 값 전송
	function f_search(){
		var selectedValue = $("#c_select").val();
	    var inputValue = $("#s_input").val();
	    
	    // 키워드 값 변경
	    var columnName = convertToColumnName(selectedValue);
	    
	    $.ajax({
	    	url: "${pageContext.request.contextPath}/office/search",
	    	type: "get",
	    	data: {
	    		columnName: columnName,
	    		inputValue: inputValue
	    	},
	    	success: function(response){
	    		$("#s_list").html(response);
	    	},
	    	error: function(){
	    		alert("존재하는 데이터가 없습니다.");
	    	}
	    	
	    });
	}
	
	
	// 키워드 값 변경 로직
	function convertToColumnName(selectedValue){
		switch(selectedValue){
	    case "접수번호": return "bno";   
	    case "이름": return "name";
	    case "주민등록번호": return "reg_no";
	    case "전화번호": return "phone";
	    case "지역": return "address";
	    case "평수": return "housing_area";
	    default: return "";
	    }
	}
	
	
	
	// 선택하는 키워드에 따라 input type 설정
	$(document).ready(function(){
		$("#c_select").change(function(){
			var selectedValue = $(this).val();
			var input = $("#s_input");
			
			switch(selectedValue) {
			case "접수번호":
				input.attr({type: "number", placeholder: "접수번호 입력"});
				break;
			case "이름":
				input.attr({type: "text", placeholder: "이름 입력"});
				break;
			case "주민등록번호":
				input.attr({type: "text", placeholder: "주민등록번호 입력"});
				break;
			case "전화번호":
				input.attr({type: "text", placeholder: "전화번호 입력"});
				break;
			case "지역":
				input.attr({type: "text", placeholder: "지역 입력"});
				break;
			case "평수":
				input.attr({type: "number", placeholder: "평수 입력"});
				break;
			}
		});
	});
	
	
	
	
	
});
</script>
<script>
$(()=>{
	//평형수에 따른 사용자 색상 지정
	var rows = document.querySelectorAll("tbody tr");
		
		rows.forEach(row =>{
			var cell = row.querySelector("td[data-area_id]");
			if(cell){
				var id = cell.getAttribute("data-area_id");
				id = parseInt(id);
				if(id == 24){
					row.style.backgroundColor = "#FF000078";
				}else if(id == 34){
					row.style.backgroundColor = "#EA00FFFF";
				}else if(id == 48){
					row.style.backgroundColor = "#15FF00A3";
				}
			}
	});
});		
</script> 
<meta charset="UTF-8">
<style>
	thead {
		background-color: orange;
	}
	h1 { text-align: center; margin-top: 20px; 
		 margin: 40px 0 25px;
	}
	table {
		border: 1px solid black;
	    width: 100%;               
	    border-collapse: collapse; 
	}
	th, td {
		border: 1px solid black;
		border-collapse: collapse;
		padding: 8px 12px;
		text-align: center;
	}	
	therd tr { background: #EADCF8; border-bottom: 2px solid black; }
	/* tbody tr:nth-child(2n){ background-color: #DFF5E1;}
	tbody tr:nth-child(2n+1) { background-color: #FFE5EC; } */
	#container {
		width: 1000px;
		margin: 0 auto;
	}	
	.box-size {
	  display: inline-block;
	  padding: 4px 8px;
	  margin-right: 10px;
	  color: #000;
	  font-size: 14px;
	  border-radius: 4px;
	}
	.color-24 {background-color: #FF000078; }
	.color-34 {background-color: #EA00FFFF; }
	.color-48 {background-color: #15FF00A3; }
	
</style>
<title>preReg_all_list</title>
</head>
<body>
	<div id="container">
		<h1>접수자 목록 조회</h1>
		<br><br>
		<hr>
		<label>조회할 키워드</label>
		<select id="c_select">
			<option selected="selected">접수번호</option>
			<option>이름</option>
			<option>주민등록번호</option>
			<option>전화번호</option>
			<option>지역</option>
			<option>평수</option>
		</select>
		<input id="s_input" type="number" placeholder="접수번호입력">
		<button id="s_btn">조회</button>
		<button id="reset">초기화</button>
		<br><br>
		<div id="s_list">
		</div>
		<br><br>
			<p class="box-size color-24">24평</p>
			<p class="box-size color-34">34평</p>
			<p class="box-size color-48">48평</p>
			<hr>
			<br>
		<table>
			<thead>
				<tr>
					<th>접수번호</th>
					<th>이름</th>
					<th>주민등록번호</th>
					<th>전화번호</th>
					<th>지역</th>
					<th>신청평수</th>
					<th>총합계</th>
					<th>해당 평수내 순위</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userinfolist}" var="office">
					<tr>
						<td>${office.bno}번</td>
						<td>${office.name}</td>
						<td>${office.reg_no}</td>
						<td>${office.phone}</td>
						<td>${office.address}</td>
						<td data-area_id="${office.housing_area}">${office.housing_area}평</td>
						<td>${office.total_score}점</td>
						<td>${office.area_rank}위</td>
						<td><a href="">🗑️</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>