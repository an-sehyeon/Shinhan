<%@page import="com.shinhan.application_office.OfficeDTO"%>
<%@page import="com.shinhan.application_office.OfficeService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
OfficeService oService = new OfficeService();
List<OfficeDTO> officelist = oService.selectAll();
%>    
 List<OfficeDTO>officelist = oService.selectAll();
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(()=>{
	$("#s_btn").on("click",f_search);
	
	
	function f_search(){
		
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
			case "주소":
				input.attr({type: "text", placeholder: "주소 입력"});
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
	//평형수에 따른 사용자 색상 지정
	var rows = document.querySelectorAll("tbody tr");
		
		rows.forEach(row =>{
			var cell = row.querySelectorAll("td[area_id]");
			if(cell){
				var id = cell.getAttribute("area_id");
				id = parseInt(id);
				
				if(id == 24){
					row.style.backgroundColor = "#FF000078";
				}else if(id == 34){
					row.style.backgroundColor = "#EA00FFFF";
				}else{
					row.style.backgroundColor = "#FF5500FF";
				}
			}
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
			<option>주소</option>
			<option>평수</option>
		</select>
		<input id="s_input" type="number" placeholder="접수번호입력">
		<button id="s_btn">조회</button>
		<br><br>
		<div id="s_list">
		</div>
		<br><br>
		<table>
			<thead>
				<tr>
					<th>NO</th>
					<th>접수번호</th>
					<th>이름</th>
					<th>주민등록번호</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>신청평수</th>
					<th>총합계</th>
					<th>해당 평수내 순위</th>
				</tr>
			</thead>
			<tbody>
			<%
				int cnt = 1;
				for(OfficeDTO office : officelist){
					out.print("<tr>");
					out.print("<td>"+ cnt++ + "</td>");
					out.print("<td a href=''>" + office.getBno() + "</td>");
					out.print("<td>" + office.getName() + "</td>");
					out.print("<td>" + office.getReg_no() + "</td>");
					out.print("<td>" + office.getPhone() + "</td>");
					out.print("<td>" + office.getAddress() + "</td>");
					out.print("<td area_id='" + office.getHousing_area() + "'>" + office.getHousing_area() + "</td>");
					out.print("<td>" + office.getTotal_score() + "</td>");
					out.print("<td>" + office.getArea_rank() + "</td>");
					out.print("</tr>");
				}
			%>
			</tbody>
		</table>
	</div>
</body>
</html>