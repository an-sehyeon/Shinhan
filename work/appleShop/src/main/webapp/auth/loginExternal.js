window.onload=function(){
	
	var remember = localStorage.getItem("remember");
	if(remember){
		document.querySelector("#email").value = localStorage.getItem("email");
		document.querySelector("#pwd").value = localStorage.getItem("pwd");
		document.querySelector("input[name='remember']").checked = true;
	}
	
	// onsubnit : default이벤트 핸들러가 제공된다. 수행후 서버에 전송된다.
	document.querySelector("#myfrm").onsubmit = function(){
		
		var remember = document.querySelector("input[name='remember']").checked;
		// localStorage : 브라우저에 저장, 브라우저가 닫혀도 사라지지 않는다.
		if(remember){
			var email = document.querySelector("#email").value;
			var pwd = document.querySelector("#pwd").value;
			localStorage.setItem("email",email);
			localStorage.setItem("pwd",pwd);
			localStorage.setItem("remember",remember);
		}else{
			localStorage.removeItem("email");
			localStorage.removeItem("pwd");
			localStorage.removeItem("remember");
		}
		
		// 서버전송 취소시에만 사용해야됨
		//return false;
	};
	
};

