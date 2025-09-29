<%@page import="job.JobDTO"%>
<%@page import="dept.DeptVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="emp.EmpService"%>
<%@page import="emp.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL / JSTL 연습</h1>
	<pre>
	<!-- 
		EmpDTO emp = session.getAttribute("loginEmp") 
		out.print(emp.getFirest_name())
	-->
	<%
	EmpDTO bean = new EmpDTO();
	bean.setFirst_name("스티븐");
	EmpService empService = new EmpService();
	EmpDTO bean2 = empService.selectById(101);
	List<EmpDTO> emplist = empService.selectByJob("AD_PRES");
	Map<String, Integer> studentmap = new HashMap<>();
	studentmap.put("김",100);
	studentmap.put("양",200);
	studentmap.put("박",300);
	
	Map<String, EmpDTO> empMap = new HashMap<>();
	empMap.put("대장",empService.selectById(100));
	empMap.put("부대장",empService.selectById(101));
	empMap.put("쫄병",empService.selectById(102));
	
	
	
	// has-a관계인경우
	DeptVO deptVo = new DeptVO();
	JobDTO job = new JobDTO("play","sleeping~~",1000,2000);
	deptVo.setDepartment_id(100);
	deptVo.setDepartment_name("개발부");
	deptVo.setJob(job);
	
	
	
	pageContext.setAttribute("empbean", bean);		
	pageContext.setAttribute("empbean2", bean2);		//DTO1건
	pageContext.setAttribute("empbean3", emplist);		//LIST
	pageContext.setAttribute("empbean4", studentmap);	//MAP
	pageContext.setAttribute("empbean5", empMap);		// 각 키 별 직원의 이름과 입사일 출력
	pageContext.setAttribute("empbean6", deptVo);		// has-a관계인경우	
	%>
	1. bean사용: ${empbean.first_name }
	2. bean사용: ${empbean2.first_name }
	3. bean사용(collection): ${empbean3[3].first_name }
	<c:forEach items="${empbean3 }" var="emp">
		${emp.first_name } ..... ${emp.salary} ..... ${emp.hire_date}
	</c:forEach>
	4. bean사용(map): ${empbean4["김"]}
	<c:forEach items="${empbean4}" var="student">
		${student.key } == ${student.value }
	</c:forEach>
	<hr>
	5.map에 저장된 data읽기 : 
	<c:forEach items="${empbean5 }" var="emp">
		${emp.key} ==> 이름: ${emp.value.first_name } 입사일 : ${emp.value.hire_date }
	</c:forEach>
	
	6.has-a:${empbean6.job.jobId } 
	6.has-a:${empbean6.job.jobTitle } 
	</pre>
	
	
</body>
</html>