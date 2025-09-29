<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%> 
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />
    <c:forEach items="${ emplist }" var="emp" varStatus="status">
				<tr>
					<td>${status.index}<span>👍👍</span>${status.count}
						<span>${status.first?"처음":"" }</span>
						<span>${status.last?"마지막":"" }</span>
					</td>
					<td>
					<c:if test="${loginEmp.employee_id==emp.employee_id}">
						<span class="login">로그인중</span>
					</c:if>
					<c:if test="${loginEmp.employee_id!=emp.employee_id}">
						<span class="logout">직원</span>
					</c:if>
					</td>
					<td><a href="${cpath}/emp/empdetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
					<td>${emp.first_name}</td>
					<td>${emp.last_name}</td>
					<td>${emp.email}</td>
					<td>${emp.phone_number}</td>
					<td>
						<fmt:formatDate pattern="yyyy-mm-dd hh:mm:ss" value="${emp.hire_date}"/>
					</td>
					<td>${emp.job_id}</td>
					<td>
						<fmt:formatNumber type="currency" currencySymbol="$" groupingUsed="true" value="${emp.salary}"></fmt:formatNumber>
					</td>
					<td>${emp.commission_pct}</td>
					<td>${emp.manager_id}</td>
					<td>${emp.department_id}</td>
					<td><a href="${cpath}/emp/empdelete.do?empid=${emp.employee_id}">
						<c:if test="${status.index%2==0}">
							🗑					
						</c:if>
						<c:if test="${status.index%2==1}">
							❤️					
						</c:if>
					</a>
					</td>
					
				</tr>
			</c:forEach>