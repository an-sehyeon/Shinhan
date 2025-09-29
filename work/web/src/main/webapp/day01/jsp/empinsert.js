$(()=>{
		$("#btnAjax").on("click", f_insert);
	});
	
	function f_insert(){
		var arr = $("form").serializeArray();
		console.log(arr);
		var obj = {};
		
		$.each(arr,(index, item)=>{
			obj[item.name] = item.value;
		});
		$.ajax({
			url:"empupdate.jsp",
			data:obj,
			success:()=>{
				console.log("insert 성공");
			}
		});
}
	