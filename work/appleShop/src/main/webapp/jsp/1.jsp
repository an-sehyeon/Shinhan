<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 1페이지입니다.</h1>
	<hr>
	
	<%-- Bean(객체) 만들기 
	DeptDTO dept = new c:\shinhanDS\work\appleShop\src\main\java\dept
	dept.setDepartment_id(123);
	dept.department_name("개발부");
	--%>
	<jsp:useBean id="dept" class="dept.DeptDTO" scope="session"/>
	<jsp:setProperty property="department_id" value="123" name="dept"/>	
	<jsp:setProperty property="department_name" value="개발부" name="dept"/>	
	
	<hr>
	<h2>1.jsp페이지에서 Bean값 얻기</h2>
	부서번호 : <jsp:getProperty property="department_id" name="dept"/>
	부서이름 : <jsp:getProperty property="department_name" name="dept"/>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!-- 표준(jsp로시작) 액션 태그
	include는 page를 컴파일 후 합친다.
	(그 페이지에 있는 변수 사용볼가)
	-->
	<%-- <jsp:include page="2.jsp"></jsp:include> --%>
	<jsp:forward page="2.jsp"></jsp:forward>
	<%-- <%@ include file="2.jsp" %> --%>
	<%-- <%=name %> --%>
</body>
</html>