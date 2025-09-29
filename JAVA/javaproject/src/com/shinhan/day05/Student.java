package com.shinhan.day05;

//class : object만드는 틀, template
public class Student {
	//1.field( static:class변수, non-static:instance변수)
	//instance변수는 new에 의해 자동으로 초기화된다. (0, 0.0, ' ', false, null)
	public String name;
	public String major;
	public double score;
	public char grade;
	public boolean isWorking;
	
	
	
	//학생수를 저장하는 변수추가(static) : class변수, class를 이용해서 생성한 모든 오브젝트가 공유 
	//object생성없이 접근가능하다.(field, method) 
	//class load시에 method영역으로 올라가고 자동초기화된다.(field)
	public static int studentCount;
	
	//2.constructor method....생성하는 방법이 여러가지로 정의한다면 Overloading(추가)
	//--정의하지않으면 컴파일시에 기본생성자(default생성자)는 제공된다. 
	//--정의하면 본생성자(default생성자)는 제공되지않는다. 
	//--초기값 설정이 목적이다. 
	//이 class로 만든 현재객체 : this
	// 매개변수이름과 멤버변수이름이 충돌발생함 (구별이 필요함) : 속성접근은 this.
	//하나의 생성자가 같은이름의 다른모양의 생성자를 호출 this()
	public Student(){		
		this(null, null, 0, false);		
	}
	public Student(String name){
		this(name, null, 0, false);	
	}
	public Student(String name,String major ){
		this(name, major, 0, false);	
	}
	public Student(String name,String major,double score ){
		this(name, major, score,  false);	
	}
	public Student(String name,String major,double score,  boolean isWorking ){
		//매개변수이름과 멤버변수이름이 충돌발생함 (구별이 필요함)
		this.name = name;
		this.major = major;
		this.score = score;
		grade = getGrade(score);
		this.isWorking = isWorking;
		studentCount++;
		System.out.printf("학생이 %d번째 생성되었습니다.\n", studentCount);
	}
	
	//3.일반 method(기능, 함수)
	private char getGrade(double score) {
		char result = ' ';
		switch ((int)score/10) {
		case 9,10->{result='A';}
		case 8->{result='B';}
		case 7->{result='C';}
		case 6->{result='D';}
		default->{result='F';}
		}
		return result;
	}
	
	public static int getCount() {
		return studentCount;
	}
	public void print(){
		System.out.println("-----학생정보------------");
		System.out.println("이름:" + name);
		System.out.println("전공:" + major);
		System.out.println("점수:" + score);
		System.out.println("학점:" + grade);
		System.out.println("학기중:" + isWorking);
		System.out.println("-----------------------");
	}
	
	
	//4.block : 문장들의 묶음 , 이름이 없음 {}
	{   
		System.out.println("-----------------------");
		System.out.println("instance생성시마다 수행된다.(instance block)-생성자와 유사");
		System.out.println("-----------------------");
	}
	static{   
		System.out.println("-----------------------");
		System.out.println("class load시 1번 수행한다.(static block)");
		System.out.println("-----------------------");
	}
	
	//5.inner class
	class myInnerClass{
		
	}
	
}

class MyOuterClass{
	
}




