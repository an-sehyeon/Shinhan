<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<div class="d-flex justify-content-center">
	<div class="container text-center border">
	<h1>부서목록조회</h1>
	<hr>
	<!-- Button to Open the Modal -->
	<button type="button" class="btn btn-primary" data-bs-toggle="modal"
		data-bs-target="#myModal" id="showInsertbtn">부서등록(모달)</button>
	
	<%-- <form action="${cpath}/dept/deptdelete" method="post">
		<input type="submit" value="선택삭제">
		<table border="1">
			<thead>
				<tr>
					<th>부서코드</th>
					<th>부서이름</th>
					<th>매니저번호</th>
					<th>지역코드</th>
					<th>삭제</th>
					<th>선택</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ deptListData }" var="dept">
					<tr>
						<td>
							<a href="deptdetail.do?deptid=${dept.department_id }">
							${dept.department_id }
							</a>
							<button type="button" class="btn btn-secondary" data-bs-toggle="modal"
								data-deptid="${dept.department_id }"
								data-deptname="${dept.department_name }"
								data-mid="${dept.manager_id }"
								data-loc="${dept.location_id }"
								data-bs-target="#myModal" id="showDetailbtn">상세보기(모달)</button>
						</td>
						<td>${dept.department_name }</td>
						<td>${dept.manager_id }</td>
						<td>${dept.location_id }</td>
						<td><a href="deptdelete.do?deptid=${dept.department_id }">🗑️</a></td>
						<td><input type="checkbox" name="del"
							value="${dept.department_id}">삭제</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>


	<!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">부서등록</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
				<form id="myfrm" action="${pageContext.request.servletContext.contextPath}/dept/deptinsert" method="post">
					<input type="hidden" name="job" value="insert">
					<fieldset>
						<label>부서코드: </label><input type="number" name="department_id" autofocus="autofocus"> <br>
						<label>부서이름: </label><input name="department_name"> <br>
						<label>매니저번호: </label><input name="manager_id" placeholder="존재하는 직원번호"> <br>
						<label>지역코드: </label><input name="location_id" placeholder="존재하는 지역코드"> <br>
					</fieldset>
				</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<input type="text" id="job" value="">
					<button type="button" class="btn btn-danger" id="savebtn">저장</button>
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
				</div>
				</div>
				</div>
			</div>
		</div>
	</div> --%>
	
 <form action="${cpath}/dept/deptdelete" method="post">
     <input class="btn btn-danger float-end" type="submit" value="선택삭제">
	 <table class="table striped">
	   <thead>
	     <tr>
	       <th>부서코드</th>
	       <th>부서이름</th>
	       <th>메니저번호</th>
	       <th>지역코드</th>
	       <th>삭제</th>
	       <th>선택</th>
	     </tr>
	   </thead>
	   <tbody>
	      <c:forEach items="${deptListData}" var="dept">
	         <tr>
	           <td>
		            <a href="${cpath}/dept/deptdetail.do?deptid=${dept.department_id}">
		             ${dept.department_id}
		            </a>
		            <button type="button" class="btn btn-secondary" data-bs-toggle="modal" 
            			data-deptid="${dept.department_id}"
            			data-deptname="${dept.department_name}"
            			data-mid="${dept.manager_id}"
            			data-loc="${dept.location_id}"
            			data-bs-target="#myModal" id="showDetailBtn">상세보기(모달)</button>
	           </td>
	           <td>${dept.department_name}</td>
	           <td>${dept.manager_id}</td>
	           <td>${dept.location_id}</td>
	           <td>
	              <a href="deptdelete?deptid=${dept.department_id}">
	                     <img src="../images/delete.png"/>
	              </a>
	           </td>
	           <td>
	              <input type="checkbox" name="del" value="${dept.department_id}" >삭제
	           </td>
	         </tr>
	      </c:forEach>
	   </tbody>
	 </table>	 
 </form>
 </div>
 </div>
 


<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">부서등록</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
         <form id="myfrm"  > 
				 <label>부서코드 :</label> 
				 <input  type="number" name="department_id" required="required"   autofocus="autofocus" > <br>
				 <label>부서이름 :</label> 
				 <input name="department_name" required="required"> <br>
				 <label>메니저번호 :</label> 
				 <input type="number" name="manager_id" placeholder="존재하는 직원" > <br>
				 <label>지역코드 :</label> 
				 <input type="number" name="location_id" placeholder="존재하는 지역코드" > <br>
				  
				 <br>
			</form>
      </div>
      <!-- Modal footer -->
      <div class="modal-footer">
        <input type="hidden" id="job" value="">
        <button type="button" class="btn btn-success" id="saveBtn">저장</button>
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
	<script>
	/* $(function(){
		
		$("#showInsertbtn").on("click",function(){
			$(".modal-title").text($(this).text());
			$("#job").val("insert");
		});
		
		$("#showDetailbtn").on("click",function(){
			$(".modal-title").text($(this).text());
			$("#job").val("update");
		});
		
		// 모달이 보여지는 사건이 발생하면 받은 데이터를 body의 input에 넣기
		$("#myModal").on("show.bs.modal",function(event){
			var deptid = $(event.relatedTarget).data("deptid");
			var deptname = $(event.relatedTarget).data("deptname");
			var mid = $(event.relatedTarget).data("mid");
			var loc = $(event.relatedTarget).data("loc");
			
			$("[name='department_id']").val(deptid);
			$("[name='department_name']").val(deptname);
			$("[name='manager_id']").val(mid);
			$("[name='location_id']").val(loc);
		});
		
		
		$("#savebtn").on("click",function(){
			$.ajax({
				url:"deptinsert.do",
				type:"post",
				data:{"job":$("#job").val(),
					  "department_id" : $("[name='department_id']").val(),
					  "department_name" : $("[name='department_name']").val(),
					  "manager_id" : $("[name='manager_id']").val(),
					  "location_id" : $("[name='location_id']").val()
				},
				success:function(response){
					// 입력건수받기
					if(response > 0){
						alert("DB저장성공");
					}else{
						alert("DB저장실패");
					}
					$("#myModal").hide();
					location.reload();
				}
			});
		});
		
	}); */
	$(function(){	   
		   $("#showDetailBtn").on("click", function(){
			   $(".modal-title").text( $(this).text() );
			   $("#job").val("update");
		   });
		   
		   $("#showInsertBtn").on("click", function(){
			   $(".modal-title").text( $(this).text() );
			   $("#job").val("insert");
		   });
		   
		   //모달이 보여지는 사건이 발생하면 받은 data를 body의 input에 넣기 
		   $("#myModal").on("show.bs.modal", function(event){
			   var deptid = $(event.relatedTarget).data("deptid");
			   var deptname = $(event.relatedTarget).data("deptname");
			   var mid = $(event.relatedTarget).data("mid");
			   var loc = $(event.relatedTarget).data("loc");
			   
			   $("[name='department_id']").val(deptid);
			   $("[name='department_name']").val(deptname);
			   $("[name='manager_id']").val(mid);
			   $("[name='location_id']").val(loc);		   
		   });
		   
		   
		   
		   $("#saveBtn").on("click",f_display);
		   
	   });

	   function f_display(){
		   
		   var dataObj = {"job":$("#job").val(),
				     "department_id" : $("[name='department_id']").val(),
				     "department_name" : $("[name='department_name']").val(),
				     "manager_id" : $("[name='manager_id']").val(),
				     "location_id" : $("[name='location_id']").val()
		             };
		   
		   
		   $.ajax({
			   url:"deptinsertAjax.do",
			   type:"post",
			   data: dataObj,
			   success: f_saveSuccess
		   });
	   };
	   
	   function f_saveSuccess(responseData){
		   //입력건수받기 
		   if(responseData>0){
			   alert("DB저장성공");
		   }else{
			   alert("DB저장실패"); 
		   }
		   $("#myModal").hide();
		   location.reload();
	   }
	</script>
</body>
</html>
