<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>주택청약접수 메인 페이지</title>
<link rel="stylesheet" type="text/css" href="${cpath}/auth/login.css">
<script src="${cpath}/auth/login.js"></script>
<script>
	var urlParams = new URLSearchParams(window.location.search);
	var message = urlParams.get("message");
	var keyerror_msg = urlParams.get("keyerror_msg");
	if (keyerror_msg) {
		alert(decodeURIComponent(keyerror_msg));
	}
	if (message) {
		alert(decodeURIComponent(message));
	}

</script>
</head>
<body>
	<h1>주택청약 접수처</h1>
	<div id="here"></div>
	<div class="cotn_principal">
		<div class="cont_centrar">

			<div class="cont_login">
				<div class="cont_info_log_sign_up">
					<div class="col_md_login">
						
						<div class="cont_ba_opcitiy">
							<h2>로그인</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
							<button class="btn_login" onclick="change_to_login()">로그인</button>
						</div>
						
					</div>
					<div class="col_md_sign_up">
						<div class="cont_ba_opcitiy">
							<h2>회원가입</h2>


							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>

							<button class="btn_sign_up" onclick="change_to_sign_up1()">사용자 회원가입</button>
							<button class="btn_sign_up" onclick="change_to_sign_up2()">관리자 회원가입</button>
						</div>
					</div>
				</div>


				<div class="cont_back_info">
					<div class="cont_img_back_grey">
						<img
							src="https://images.unsplash.com/42/U7Fc1sy5SCUDIu4tlJY3_NY_by_PhilippHenzler_philmotion.de.jpg?ixlib=rb-0.3.5&q=50&fm=jpg&crop=entropy&s=7686972873678f32efaf2cd79671673d"
							alt="" />
					</div>

				</div>
				<div class="cont_forms">
					<div class="cont_img_back_">
						<img
							src="https://images.unsplash.com/42/U7Fc1sy5SCUDIu4tlJY3_NY_by_PhilippHenzler_philmotion.de.jpg?ixlib=rb-0.3.5&q=50&fm=jpg&crop=entropy&s=7686972873678f32efaf2cd79671673d"
							alt="" />
					</div>
					<div class="cont_form_login">
						<a href="#" onclick="hidden_login_and_sign_up()"><i
							class="material-icons">&#xE5C4;</i></a>
						<h2>로그인</h2>
						<input type="text" placeholder="Email" /> <input type="password"
							placeholder="Password" />
						<button class="btn_login" onclick="change_to_login()">로그인</button>
					</div>

					<div class="cont_form_sign_up_user cont_form_sign_up">
						<a href="#" onclick="hidden_login_and_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
						<h2>사용자 회원가입</h2>
						<form action="userinfoinsert" method="post">
						<input type="text" name="name" placeholder="이름" /> 
						<input type="text" name="id"  placeholder="아이디" /> 
						<input type="password" name="password"  placeholder="비밀번호" /> 
						<input type="password" name="password"  placeholder="비밀번호 확인" />
						<input type="text" name="reg_no"  placeholder="주민등록번호" /> 
						<input type="text" name="phone"  placeholder="핸드폰번호" /> 
						<br>
						<select name="address" style="width: 220px;">
								<option selected disabled>지역</option>
							<c:forEach items="${addresslist}" var="address">
								<option value="${address.address}">
									${address.address}
								</option>	
							</c:forEach>
						</select>
						<br>
						<select name="dependent_count" style="width: 220px;">
								<option selected disabled>부양가족 수</option>
							<c:forEach items="${dependentList}" var="dependent">
								<option value="${dependent.dependent_count}">
									${dependent.dependent_count}
								</option>	
							</c:forEach>
						</select>
						<br>
						<select name="non_home_start_date" style="width: 220px;">
								<option selected disabled>무주택기간</option>
							<c:forEach items="${nonhomeList}" var="nonhome">
								<option value="${nonhome.non_home_start_date}">
									${nonhome.non_home_start_date}
								</option>	
							</c:forEach>
						</select>
						<br>
						<select name="account_open_date" style="width: 220px;">
								<option selected disabled>통장개설연도</option>
							<c:forEach items="${accountList}" var="account">
								<option value="${account.account_open_date}">
									${account.account_open_date}
								</option>	
							</c:forEach>
						</select>
						<br>
						<select name="is_married" style="width: 220px;">
							<option selected disabled >결혼유무</option>
							<option>Y</option>
							<option>N</option>
						</select>
						<br>
						<select name="housing_area" style="width: 220px;">
								<option selected disabled>평수선택</option>
							<c:forEach items="${areaList}" var="area">
								<option value="${area.housing_area}">
									${area.housing_area}
								</option>	
							</c:forEach>
						</select>
						<button type="submit" class="btn_sign_up" onclick="change_to_sign_up1()">회원가입</button>
						</form>					
					</div>
					<div class="cont_form_sign_up_admin cont_form_sign_up">
						<a href="#" onclick="hidden_login_and_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
						<h2>관리자 회원가입</h2>
						<form action="admininfoinsert" method="post">
						<input type="text" name="name" placeholder="이름" /> 
						<input type="text" name="id"  placeholder="아이디" /> 
						<input type="password" name="password"  placeholder="비밀번호" /> 
						<input type="password" name="password"  placeholder="비밀번호 확인" />
						<input type="text" name="reg_no"  placeholder="주민등록번호" /> 
						<input type="text" name="phone"  placeholder="핸드폰번호" /> 
						<input type="text" name="adminkey"  placeholder="관리자코드" /> 
						<button type="submit" class="btn_sign_up" onclick="change_to_sign_up2()">회원가입</button>
						</form >
					</div>

				</div>
			</div>
		</div>
	</div>
	<br><br><br><br>
</body>
</html>