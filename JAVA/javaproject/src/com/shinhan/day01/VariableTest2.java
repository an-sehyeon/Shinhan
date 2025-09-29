package com.shinhan.day01;

//class : 변수와 메서드들의 묶음 
public class VariableTest2 {
	//1.field(멤버변수)
	int score=99;
	//2.생성자메서드
	//3.일반메서드(기능)
	//4.inner class
	//5.block(문장들의 묶음)
	
	public static void main(String[] args) {
		//method6("10", "20");

		method8();

	}
    private static void method8() {
		//기본형을 문자열로 변경
    	int v1 = 100;
    	String s1 = v1 + "";
    	String s2 = String.valueOf(v1);
    	System.out.println(s1 + 200);
    	System.out.println(s2 + 200);
    	
		
	}
	private static void method7() {
    	//Wrapper class = 기본형타입 + 기능 
		String s1 = "100";
		byte v1 = Byte.parseByte(s1);
		
		//**잘못된 casting 이다. 기본형만 casting 가능 
		//byte v11 = (byte)s1;
		
		short v2 = Short.parseShort(s1);
		int v3 = Integer.parseInt(s1);
		long v4 = Long.parseLong(s1);
		float v5 = Float.parseFloat(s1);
		double v6 = Double.parseDouble(s1);
		s1 = "true";
		boolean v7 = Boolean.parseBoolean(s1);
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v5);
		System.out.println(v6);
		System.out.println(v7);
		
	}
	//파라메터, argument 
	private static void method6(String s1, String s2) {//a = 10; b=20
		//문자를 숫자로 변경하기 
		int a=Integer.parseInt(s1);
		int b=Integer.parseInt(s2);
		
		System.out.println("덧셈:" + (a+b));  //문자+숫자=>문자 
		System.out.println("뺄셈:" + (a-b)); //문자-숫자는 불가 
		System.out.println("곱하기:" + a*b);
		System.out.println("몫:" +a/b);
		System.out.println("나머지:" +a%b);
		
	}

	private static void method5() {
		//두수의 사칙연산 수행하기 
		int a=10;
		int b=3;
		System.out.println("덧셈:" + (a+b));  //문자+숫자=>문자 
		System.out.println("뺄셈:" + (a-b)); //문자-숫자는 불가 
		System.out.println("곱하기:" + a*b);
		System.out.println("몫:" +a/b);
		System.out.println("나머지:" +a%b);
		
	}

	private static void method4() {
		//연산식에서 정수는 int로 자동 형변환된다.
		byte v1 =10;
		byte v2 =20;
		int v3 = v1 + v2;
		byte v4 = (byte)(v1 + v2);
		
		System.out.println(v3);
		System.out.println(v4);
		
	}

	private static void method3() {
		int v1;  //2147483647
		byte v2 = 127;
		float v3;
		//byte<short, char<int<long<float<double 
		//**자동 타입변환 : 큰방 = 작은값 
		v1 = v2;
		v3 = v2;
		System.out.println(v1);
		System.out.println(v3);
		//**강제 타입변환 : 작은방 = (작은방타입)큰값 , data손실가능성 있음 
		v1 = 128;
		v2 = (byte)v1;
		System.out.println(v2);
		
		char ch = 'A';
		
		//v1:4byte ch:2byte
		v1 = ch;
		System.out.println(v1);
		v1++;
		ch = (char)v1;
		System.out.println(ch);
		
		
	}

	private static void method2() {
		String v1 =  """
					 {
					    "name": "hong",
					    "age": 20,
					    "major": "computer"
					}
				""";
		System.out.println(v1);
	}

	private static void method1() {
		//문자열
		String v1 = "이것이\t\t \"자바\"다. \n신용권'선생님'";
		System.out.println(v1);
	}

}






