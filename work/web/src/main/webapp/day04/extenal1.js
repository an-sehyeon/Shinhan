/**
 * 
 */
// internal 자바스크립트
	// 1.변수타입 : number, string, boolean, undefined, object(array포함), function
	a=10;           
    var b = 20;     
    let c = 30;     
    const d = 40;   
    {
    	var e = 50;	// 전역변수
    	let f = 60; // block내에서만 유효
    }
    function f1(){
    	var v1 = 100;	// 지역변수
    	v2 = 200;	// 전역변수
    }
    f1();
    console.log(a+b+c+d+e+v2);