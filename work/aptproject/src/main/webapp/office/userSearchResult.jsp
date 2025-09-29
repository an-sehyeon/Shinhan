<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
					row.style.backgroundColor = "#A8E6CF";
				}else if(id == 34){
					row.style.backgroundColor = "#D1C4E9";
				}else if(id == 48){
					row.style.backgroundColor = "#FFCCBC";
				}
			}
	});
});		
</script>
</head>
<body>
	<table>
    <thead>
        <tr>
            <th>접수번호</th>
            <th>이름</th>
            <th>주민번호</th>
            <th>전화번호</th>
            <th>주소</th>
            <th>평수</th>
            <th>총점</th>
            <th>순위</th>
            <!-- <th>삭제</th> -->
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${userinfolist}" var="office">
            <tr>
                <td>${office.bno}</td>
                <td>${office.name}</td>
                <td>${office.reg_no}</td>
                <td>${office.phone}</td>
                <td>${office.address}</td>
                <td data-area_id="${office.housing_area}">${office.housing_area}평</td>
                <td>${office.total_score}</td>
                <td>${office.area_rank}</td>
                <!-- <td><a href="#">🗑️</a></td> -->
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>