package com.shinhan.day05;

public class Car {
	String model;
	String color;
	int price;
	
	// field
	static String company;
	
	// method
	static void staticMethod() {		// 여러번 호출가능 (함수)
		// static에서 non-static은 사용불가
//		System.out.println(model);	// 에러
		
		// static에서 static사용
		System.out.println(company);
		
		// static에서 non-static 사용하려면 객체 생성 후 사용가능
		Car c = new Car();
		System.out.println(c.model);
	}
	
	// block -> 호출하지않아도 수행됨. 호출 불가
	static {
		System.out.println("----------static block1----------");
		System.out.println(company);
//		System.out.println(nodel);		// model : non-static, 에러
		Car c = new Car();
		System.out.println(c.toString());
		
		// static 에서 non-static은 사용불가, 
//		String s = toString();
	}
	static {
		System.out.println("static block2");
	}
	
	
	// super : 부모를 의미
	// super() : 부모를 생성 후 자식을 생성
	// 생성자에서 instance method사용불가
	// 생성자가 수행후 instance method 사용 가능하기 때문
	// static이 붙으면 시작하자마자 메모리에 올라가기 때문에 가능
	public Car() {
		this(null,null,f1());
		System.out.println("기본생성자");
		
	}
	
	static int f1() {
		return 100;
	}



	public Car(String model) {
		this(model,null,0);
	}



	public Car(String model, String color) {
		// this() : 생성자가 같은 이름의 다른 생성자 호출 시 사용
		this(model,color,0);
	}



	public Car(String model, String color, int price) {
		// 멤버변수와 매개변수가 이름이 같아서 충돌발생, 구분하기 위해 현재 객체를 this라고 함.
		this.model = model;
		this.color = color;
		this.price = price;
	}

	// Override(덮어쓰기, 재정의) 부모가 정의한 함수를 변경한다.
	// 함수의 정의가 같아야 가능 (이름과 매개변수가 같아야하고 return도 같아야 함.)
	@Override
	public String toString() {
		return "Car [model=" + model + ", color=" + color + ", price=" + price + "]";
	}
	
	
}
