/**
 * 
 */
window.onload = function(){
	var btn1 = document.querySelector("button:nth-of-type(1)");
	var btn2 = document.querySelector("button:nth-of-type(2)");
	var btn3 = document.querySelector("button:nth-of-type(3)");
	var btn4 = document.querySelector("button:nth-of-type(4)");
	var btn5 = document.querySelector("button:nth-of-type(5)");
	var btn6 = document.querySelector("button:nth-of-type(6)");
	var btn7 = document.querySelector("#btn7");
	var btn8 = document.querySelector("#btn8");
	var btn9 = document.querySelector("#btn9");
	var btn10 = document.querySelector("#btn10");
	btn1.onclick = f_1;		//callback함수, 받은쪽에서 호출
	btn2.onclick = f_2;
	btn3.onclick = f_3;
	btn4.onclick = f_4;
	btn5.onclick = f_5;
	btn6.onclick = f_6;
	btn7.onclick = f_7;
	btn8.onclick = f_8;
	btn9.onclick = f_9;
	btn10.onclick = f_10;
	
};

// 선언적 함수
function f_1(){
		// 익명함수
		var f = function(){alert("나는 함수이다.")};
		console.log(f);
		console.log(typeof(f));
		f();
};


function f_2(){
		var result1 = sumAll(10,20);
		var result2 = sumAll(1,2,3,4,5);
		var result3 = sumAll(1,2,3,4,5,6,7,8,9,10);
		console.log(result1,result2,result3);
};

function sumAll(){
	// 내장객체 : arguments
	var sum = 0;
	for(let i=0;i<arguments.length;i++){
		sum+=arguments[i];
	}
	return sum;
};

function sumAll(a,b){
	return a+b+"!!!";
};

function f_3(){
	var width = 3;
	var height = 4;
	var result = Math.sqrt(sqare(width) + sqare(height));
	console.log(width, height, result);
	
	// 내부 함수
	function sqare(data){
	return data*data;
	}
};

// callback함수 : 함수정의를 파라메터로 전달하고 받은쪽에서 호출
function f_4(){
	// 1초마다 시간을 출력
	timer = setInterval(function(){
		var today = new Date();
		here.innerHTML = today;
	},1000);
	
	var f = function(){
		console.log("callback함수");
	};
	call4(f);
};

// 함수를 매개변수로 받아서 호출
function call4(func){
	func();
};

const f = outer();
function f_5(){
	console.log(f());	// 버튼을 누를때마다 su 증가
	
};

function outer(){
	var su=0;	// 지역변수
	return function(){
		su++;
		return su;
	}
};

// 0.1초후에 1~5까지 출력
function f_6(){
	// 변하고있는 지역변수 i를 setTimeout메서드와 같이 사용하고 있어 문제 발생
	/*for(var i=1;i<=5;i++){
		setTimeout(function(){
			console.log(i);
		},100)
	};*/
	// 지역변수를 복사하여 사용
	/*for(var i=1;i<=5;i++){
		setTimeout((function(aa){
			console.log(aa);
		})(i),100)
	};*/
	// {}내에서만 유효한 변수로 선언
	for(let i=1;i<=5;i++){
		setTimeout(function(){
			console.log(i);
		},100)
	};
};

const closure1 = minLengthValidator(5);
const closure2 = minLengthValidator(3);
function f_7(){
	var message1 = a(userid1.value);
	var message2 = b(userid2.value);
	console.log(message1);
	console.log(message2);
};

function minLengthValidator(minLength){
	return function(input){
		if(input.length < minLength){
			return `최소길이는 ${minLength}입니다.`;
		}else{
			return `${input}"값은 유효한 값입니다."`;
		}
	};
}

function f_8(){
	clearTimeout(timer);
}

function f_9(){
	var path = "http://localhost:9090/web/day01/jsp/empdetail.jsp? emp_id=한글";
	 // encode: 부호화
	 var encode_path = encodeURIComponent(path);
	 console.log(encode_path);
	 // decode: 복구
	 var decode_path = decodeURIComponent(encode_path);
	 console.log(decode_path);
}

function f_10(){
	var input1 = su1.value;
	var input2 = su2.value;
	/*var v_op = document.querySelector("#op option:checked").innerHTML;*/
	var v_op = document.getElementById("op").value;
	
	var s = input1 + v_op + input2; 	
	// eval() : 문자열로 만들어진 문장을 자바스크립트로 바꿔서 해석
	result.value = eval(s);
}	
