/**
 * 
 */
window.onload = init;
 
function init(){
	var button1 = document.querySelector("#btn1");
	var button2 = document.querySelector("#btn2");
	var button3 = document.querySelector("#btn3");
	var button4 = document.querySelector("#btn4");
	var button5 = document.querySelector("#btn5");
	var button6 = document.querySelector("#btn6");
	var button7 = document.querySelector("#btn7");
	var button8 = document.querySelector("#btn8");
	var button9 = document.querySelector("#btn9");
	var button10 = document.querySelector("#btn10");
	var reset = document.querySelector("#resetbtn");
	
	button1.onclick = f1;
	button2.onclick = f2;
	button3.onclick = f3;
	button4.onclick = f4;
	button5.onclick = f5;
	button6.onclick = f6;
	button7.onclick = f7;
	button8.onclick = f8;
	button9.onclick = f9;
	button10.onclick = f10;
	reset.onclick = f_reset;
	
	f_add();
};

function f_reset(){
	document.getElementById("here").innerHTML="";
}
 
function f1(){
	var arr1 = [10,20,30];
	var arr2 = new Array("자바","웹","데이터베이스");
	var arr3 = arr1.concat(arr2);
	console.log(arr3);
	var s = arr3.join();		// 기본은 ,
	var s2 = arr3.join("*");
	console.log(s,s2); 
};
 
function f2(){
	var arr1 = [10,20,30];
	arr1.push("뒤에추가");
	arr1.unshift("앞에추가");
	console.log(arr1);
	
	console.log(arr1.pop());
	console.log(arr1);
}; 

function f3(){
	var arr1 = [10,20,30,40,50];
	var arr2 = arr1.splice(2);	// 3부터 끝까지
	console.log(arr1);			//10,20
	console.log(arr2);			//30,40,50
	var arr3 = arr2.splice(1,1);	// 40
	console.log(arr2);			//30,50
	console.log(arr3);			//40
	
	var arr4 = arr1.splice(1,1,"자르고추가");	//[10,"자르고추가"]
	console.log(arr4);		
	console.log(arr1);		
	
	// slice()는 원본 유지
	var arr1 = [10,20,30];
	var arr2 = arr1.slice(1);
	console.log(arr1); 
	console.log(arr2); 
	
};

function f4(){
	var d1 = new Date();
	var s = d1.toLocaleString();
	var s2 = d1.toISOString();
	var arr = s2.split("T");
	console.log(s);
	console.log(s2);
	console.log(arr[0]);	//년-월-일
	
};

function f5(){
	var str ="";
	for(let prop in window){
		// window["name"]
		str += "<br>" + prop + "==>" + window[prop];
	}
	document.querySelector("#here").innerHTML = str;
};

function f6(){
	var str ="";
	for(let prop in document){
		// window["name"]
		str += "<br>" + prop + "==>" + document[prop];
	}
	document.querySelector("#here").innerHTML = str;
};

function f7(){
	var str ="";
	for(let prop in location){
		// window["name"]
		str += "<br>" + prop + "==>" + location[prop];
	}
	document.querySelector("#here").innerHTML = str;
};

function f_location(){
	// 상대경로
	/*location.href="../day01/jsp/empAll.jsp";*/
	// 절대경로
	var host = location.origin;	 		// http://localhost:9090
	var pathname = location.pathname.split("/")[1];	// /web/day04/2.html
	location.href=host+pathname+"/day01/jsp/empAll.jsp";
};

function f8(){
	var str ="";
	for(let prop in navigator){
		// window["name"]
		str += "<br>" + prop + "==>" + navigator[prop];
	}
	document.querySelector("#here").innerHTML = str;
};

function f_navigator(){
	/*document.querySelector("#here").innerHTML = navigator.userAgent;*/
	var arr = ["Android","iPhone","iPad"];
	var data = navigator.userAgent;
	
	for(let i in arr){
		if(data.includes(arr[i])){
			document.querySelector("#here").innerHTML = "모바일";
			return;
		}
	}
	document.querySelector("#here").innerHTML = "당신이 접속한 기기는 데스크탑입니다."
};

function f9(){
	var str ="";
	for(let prop in screen){
		// window["name"]
		str += "<br>" + prop + "==>" + screen[prop];
	}
	document.querySelector("#here").innerHTML = str;
};

function f10(){
	var str ="";
	for(let prop in history){
		// window["name"]
		str += "<br>" + prop + "==>" + history[prop];
	}
	document.querySelector("#here").innerHTML = str;
};

function f_history_back(){
	window.history.back();
	//window.history.forward(); // 앞으로 가기
	//window.history.go(2);	// 원하는 페이지 수만큼 이동
	
};

function f_add(){
	document.querySelector("#btn_obj1").onclick = f_obj1;
	document.querySelector("#btn_obj2").onclick = f_obj2;
	document.querySelector("#btn_obj3").onclick = f_obj3;
	document.querySelector("#btn_obj4").onclick = f_obj4;
	document.querySelector("#btn_obj5").onclick = f_obj5;
	document.querySelector("#btn_obj6").onclick = f_obj6;
	document.querySelector("#btn_obj7").onclick = f_obj7;
	document.querySelector("#btn_obj8").onclick = f_obj8;
};

function f_obj1(){
	var obj = {
				"1 aa ** bb" : "값",
				location:"마포구",
				name:"홍길동", 
			   	age:20, 
			   	군필:false,
			   	study : function(){
					// this는 객체자신임
					console.log(this.name+"님은 야간까지 공부합니다.");
					console.log(this.location +"로 오시오~~~~");
			   	}
			   };
	console.log("속성과 값 : " + obj["1"]);		   
	console.log("이름 : " + obj.name);		   
	console.log("나이 : " + obj["age"]);		   
	console.log("군필여부 : " + obj["군필"]);	
	
	var prop1 = "age";
	console.log("속성접근:" + obj[prop1]);
	
	obj.study();	   
};

function f_obj2(){
	var obj = {
				"1 aa ** bb" : "값",
				location:"마포구",
				name:"홍길동", 
			   	age:20, 
			   	군필:false,
			   	study : function(){
					// this는 객체자신임
					console.log(this.name+"님은 야간까지 공부합니다.");
					console.log(this.location +"로 오시오~~~~");
			   	}
			   };
	var str ="";
	for(let prop in obj){
		// window["name"]
		str += "<br>" + prop + "==> " + typeof(obj[prop]) + "==> " +  obj[prop];
		if( typeof(obj[prop]) == "function"){
			obj[prop]();		// 값의 타입이 함수이면 실행하기
		}
	}
	document.querySelector("#here").innerHTML = str;		   
};

function f_obj3(){
	var student = {name:"가윤"};
	student.age = 20;
	student.major = "컴공";
	student.eat = function(){alert('과일이좋아');};
	student.toString = function(){
		return `나의 이름은 ${this.name} 전공은 ${this.major}`;
	};
	delete student.age;
	console.log(student);				
	document.querySelector("#here").innerHTML = student;
};

function f_obj4(){
	var arr = [];
	arr.push(new Student("김길동", 100, 100, 35));
	arr.push(new Student("이길동", 20, 80, 100));
	arr.push(new Student("박길동", 100, 66, 80));
	arr.push(new Student("강길동", 100, 35, 100));
	arr.push(new Student("최길동", 80, 90, 48));
	
	// 총점으로 desc sort
	// 총점이 같으면 이름으로 asc sort
	arr.sort((a,b)=>{
		var result1 = b.getSum() - a.getSum()
		console.log(result1);
		if(result1 == 0) return a.name.localeCompare(b.name);
		});
	
	var str = "";
	for(let i in arr){
		str+="<br>" + arr[i];	// toString()자동 호출
	}
	document.querySelector("#here").innerHTML = str;
	
	// 외부에서 객체의 속성접근가능
	console.log(arr[0].name);
};

function Student(이름, 자바, 디비, 웹){
	// this가 생략되면 window의 global영역의 변수로 선언의 의미이다.
	// this를 사용하면 이 생성자함수를 이용해서 만든 instance변수가 된다.
	this.name = 이름;
	this.java = 자바;
	this.sql = 디비;
	this.web = 웹;
};

// Student생성자 함수를 이용해서 만든 instance들이 공유하는 공간에 함수 정의 
// (메모리 효율적으로 관리를 위해 필요)
Student.prototype.getSum = function(){return this.java + this.sql + this.web};
Student.prototype.getAgv = function(){return this.getSum()/3;};
Student.prototype.toString = function(){
		return `이름은 ${this.name} 평균은 ${this.getAgv()}`;};

function f_obj5(){
	var su1 = 123;	// 기본형은 속성사용은 가능, 추가 불가
	var su2 = new Number(123);
	su2.myFunc = function(){alert("함수추가");};
	su2.myFunc();
};

function f_obj6(){
	var arr = [100,70,30,50,90];
	// 기본은 문자로 asc sort
	document.querySelector("#here").innerHTML = "asc: " + arr;
	
	// sort 기준 바꾸기
	arr.sort((a,b)=>b-a);
	document.querySelector("#here").innerHTML = "<br>desc:" + arr;
	
	var arr2 = ["자바","디비","웹","데브옵스","금융공학"];
	arr2.sort((a,b)=>a.localeCompare(b));
	document.querySelector("#here").innerHTML = "<br>desc: " + arr2;
};

function f_obj7(){
	var arr = [100,70,30,50,90];
	arr.forEach(function(elt,idx,arrObj){
		console.log(elt,idx+"번째",arrObj);
	});
	
	console.log("============map==============");
	var arr2 = arr.map(function(elt,idx,arrObj){
		return idx+"번째 값: " + elt;
	});
	console.log(arr2);
	
	console.log("============filter==============");
	var arr3 = arr.filter(function(elt){
		return elt >= 50;
	});
	console.log(arr3);
	
	console.log("============every==============");
	var arr4 = arr.every(function(elt){
		return elt >= 50;
	});
	console.log(arr4);
	
	console.log("============some==============");
	var arr5 = arr.some(function(elt){
		return elt >= 50;
	});
	console.log(arr5);
};


function f_obj8(){
	var obj = {name: "홍길동", age:20};
	var json1 = JSON.stringify(obj);
	console.log(obj);		// `{name: "홍길동", age:20}`
	console.log(json1);
	// JSON -> JS Object
	var obj2 = JSON.parse(json1);
	console.log(obj2.name);
	
};



