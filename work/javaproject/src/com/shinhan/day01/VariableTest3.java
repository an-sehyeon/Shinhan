package com.shinhan.day01;


// > java VariableTest3
// JVM이 load... static이 메모리에 올라온다.
// new에 의해서 객체를 만들면 non-static도 사용가능
public class VariableTest3 {

	// field
	int score1 = 100;
	
	// method
	void f1(){
		int score2 = 100;
		System.out.println("f1함수 : " + (score1 + score2));
	}
	
	void f2(){
		int score3 = 100;
		System.out.println("f2함수 : " + (score1 + score3));
	}
	
	// block
	{	String subject = "자바";
		System.out.println("1.instance block...객체생성시마다 수행됨." + subject);
	}
	{
		System.out.println("2.instance block...객체생성시마다 수행됨.");
	}
	
	public static void main(String[] args) {
	//	f1();	static은 non-static을 사용불가
		VariableTest3 aa = new VariableTest3();
		System.out.println(aa.score1);
		aa.f1();
		aa.f2();
		
		
		{
			String myname = "jin";		// 지역변수
			System.out.println(myname);
		}
	//	System.out.println(myname);		// 지역변수는 block내에서만 사용 가능
	}

}
