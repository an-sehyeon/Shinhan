<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.DateTimeException"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<%
LocalDate down_payment = LocalDate.now().plusMonths(1);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

String[] planning = new String[8];

planning[0] = down_payment.format(formatter);

for(int i=0; i<=7;i++){
	planning[i] = down_payment.plusMonths(i*6).format(formatter);	// 6개월 간격
}

// 배열 저장
request.setAttribute("paymentdate", planning);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table Style</title>
<meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
<link rel="stylesheet" type="text/css" href="${cpath}/info/PaymentPlanTable.css">
<link rel="stylesheet" type="text/css" href="${cpath}/info/btn.css">
<script src="${cpath}/info/progress.js"></script>
<script>
var contextPath = "${cpath}";
var userdata_list = {
	    bno: "${userdata.bno}",
	    name: "${userdata.name}",
	    reg_no: "${userdata.reg_no}",
	    phone: "${userdata.phone}",
	    address: "${userdata.address}",
	    housing_area: "${userdata.housing_area}"
	};
</script>
</head>
<body>
	<div class="table-title">
		<h1>${paymentplan.name}님의 분양금 납부 계획 일정</h1>
		<h3 style="text-align: center;"><${paymentplan.housing_area}평></h3>
		<br>
	</div>
	<table class="table-fill">
		<thead>
			<tr>
				<th class="text-left">항목</th>
				<th class="text-left">금액</th>
				<th class="text-left">납부일자</th>
			</tr>
		</thead>
		<tbody class="table-hover">
			<tr>
				<td class="text-left">계약금</td>
				<td class="text-left">${paymentplan.down_payment}원</td>
				<td class="text-left">📅${paymentdate[0]}</td>
			</tr>
			<tr>
				<td class="text-left">중도금 1회차</td>
				<td class="text-left">${paymentplan.interim_payment}원</td>
				<td class="text-left">📅${paymentdate[1]}</td>
			</tr>
			<tr>
				<td class="text-left">중도금 2회차</td>
				<td class="text-left">${paymentplan.interim_payment}원</td>
				<td class="text-left">📅${paymentdate[2]}</td>
			</tr>
			<tr>
				<td class="text-left">중도금 3회차</td>
				<td class="text-left">${paymentplan.interim_payment}원</td>
				<td class="text-left">📅${paymentdate[3]}</td>
			</tr>
			<tr>
				<td class="text-left">중도금 4회차</td>
				<td class="text-left">${paymentplan.interim_payment}원</td>
				<td class="text-left">📅${paymentdate[4]}</td>
			</tr>
			<tr>
				<td class="text-left">중도금 5회차</td>
				<td class="text-left">${paymentplan.interim_payment}원</td>
				<td class="text-left">📅${paymentdate[5]}</td>
			</tr>
			<tr>
				<td class="text-left">중도금 6회차</td>
				<td class="text-left">${paymentplan.interim_payment}원</td>
				<td class="text-left">📅${paymentdate[6]}</td>
			</tr>
			<tr>
				<td class="text-left">잔금</td>
				<td class="text-left">${paymentplan.balace_payment}원</td>
				<td class="text-left">📅${paymentdate[7]}</td>
			</tr>
			<tr>
				<td class="text-left">총 금액</td>
				<td class="text-left">${paymentplan.total_price}원</td>
				<td class="text-left"></td>
			</tr>
		</tbody>
	</table>
	<div class="center-container">
		<button class="btn btn-primary btn-round btn-marquee" id="gobtn">
		  <span data-text="계약진행">계약진행</span>
		</button>
		<button class="btn btn-primary btn-round btn-marquee" id="stopbtn">
		  <span data-text="계약포기">계약포기</span>
		</button>
	</div>
</body>