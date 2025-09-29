window.onload = function(){
	// 객체의 이벤트속성에 이벤트 핸들러를 할당 
	
	// 1. 고전방식으로 이벤트 연결(많이 사용)
	document.getElementById("btn1").onclick = f1;
	document.getElementById("btn2").onclick = f2;
	document.getElementById("btn3").onclick = f3;
	
	// 2. 표준방식으로 이벤트 연결
	var imgObject = document.getElementById("img1");
	imgObject.addEventListener("click",f4, false);	// true:캡처링(부모->자식), false:버블링(자식->부모)
	
	var btn4Obj = document.querySelector("#btn4");
	btn4Obj.addEventListener("click",f5);
	
	document.querySelector("#btn5").addEventListener("click",f6);
	document.querySelector("#btn6").addEventListener("click",f7);
};

function f1(){
	//alert(this.innerHTML);
	document.getElementById("img1").src="../17/images/tree-5.jpg"
	document.getElementById("here").innerHTML = "";
};
function f2(){
	//alert(this.innerHTML);
	document.getElementById("img1")
		.setAttribute("src","../17/images/tree-4.jpg");
		document.getElementById("here").innerHTML = "";
};
function f3(){
	//alert(this.innerHTML);
	document.querySelector("div img:first-child")
		.setAttribute("src","../17/images/tree-6.jpg");
		document.getElementById("here").innerHTML = "";
};
function f4(e){
	var str = "타입 : "  + e.page 
			+ "x=" + e.pageX + ", y=" + e.pageY;
	document.getElementById("here").innerHTML = str;
	
	//e.stopPropagation();	// 이벤트 전달막기
}
function f5(){
	var h2Obj = document.createElement("h2");	// <h2></h2>
	var txtObj = document.createTextNode("동적으로 객체를 만드는 연습");
	h2Obj.appendChild(txtObj);	// <h2>동적으로 객체를 만드는 연습</h2>
	document.getElementById("here").appendChild(h2Obj);
};
function f6(){
	document.getElementById("here").innerHTML
		= "<h2>동적으로 객체를 만드는 연습</h2>";
};	
function f7(){
	// img1 삭제하기
	var imgObj = document.getElementById("img1");
	//imgObj.parentNode.removeChild(imgObj);
	
	imgObj.parentNode.parentNode.removeChild(imgObj.parentNode);
};


















