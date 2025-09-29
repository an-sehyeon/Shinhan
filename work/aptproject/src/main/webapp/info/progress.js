$(() => {

	$("#gobtn").on("click", f_gobtn);
	$("#stopbtn").on("click", f_stopbtn);

	var userdata = userdata_list;


	function f_stopbtn() {
		var str = "계약포기";
		var text = prompt("계약을 포기하시려면 입력창에 [계약포기]를 입력해주세요", "");

		if (text === null) {

		} else if (text === str) {
			var q = confirm("정말로 계약을 포기하시겠습니까?");
			if (q = true) {
				$.ajax({
					url: contextPath + "/cancel",
					type: "post",
					data: {
						bno: userdata_list.bno,
						name: userdata_list.name,
						reg_no: userdata_list.reg_no
					},
					success: function(response) {
						window.location.href = contextPath + "/info/progress_cancel.jsp";
					},
					error: function(xhr, status, error){
						console.log("서버 응답 메시지 : " + xhr.responseText);
						alert("계약이 정상적으로 취소되지 않았습니다. 다시 시도해주세요.")
					}
				});
			} return;
		} else {
			prompt("다시한번 정확하게 입력해주세요", "");
		}
	}



	function f_gobtn() {
		var str = "계약진행";
		var text = prompt("계약진행을 원하시면 입력창에 [계약진행]을 입력해주세요", "");

		if (text === null) {
		} else if (text === str) {
			$.ajax({
				url: contextPath + "/success",
				type: "post",
				data: {
					bno: userdata_list.bno,
					name: userdata_list.name,
					reg_no: userdata_list.reg_no,
					phone: userdata_list.phone,
					address: userdata_list.address,
					housing_area: userdata_list.housing_area
				},
				success: function(response) {
					window.location.href = contextPath + "/info/progress_success.jsp";
				}
			});
		} else {
			prompt("다시한번 정확하게 입력해주세요", "");
		}
	}
});