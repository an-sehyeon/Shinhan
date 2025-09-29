package com.shinhan.day07;

public class Child1 extends Parent{
	
	// 부모의 field이름과 동일하면 자식것이 우선
	boolean score;
	
	
	// 1. field 추가
	String myname;
	
	// 2. 생성자 추가
	public Child1(int score, String myname) {
//		this.score = score;
		super(score);
		this.myname = myname;
	}
	
	// 3. method 추가
	void display() {
		System.out.println("score : " + score );
		System.out.println("myname : " + myname );
	}
	
	// 4. method 수정(override, 덮어쓰기)
	// - 이름같고 매개변수 같고 return같고 Modifier는 같거나 더 넓어져야한다.
	@Override
	void info() {
		super.info();
		System.out.println("자식의 info메서드 myname = " + myname);
		System.out.println("-----------------------------------");
	}
	
	// Overloading : 이름은 같지만 매개변수가 다르다.
	void info(String title) {
		super.info();
		System.out.println("!!Overloading");
		System.out.println("--------------Overloading--------------");
	}
	
	public Child1() {
		// super() 생략됨 -> 부모의 생성자를 호출, 첫줄에만 작성가능
		super(0);	// 명시적으로 부모의 생성자를 호출
		System.out.println("자식1 default 생성자");
	}
	
	
}
