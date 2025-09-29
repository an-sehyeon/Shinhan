package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
class VEhicle{
	private String company;
}

// 규약서(규칙) 정의 = 추상, 반드시 구현 class가 추상메서드를 구현해야한다. 
interface Activeable{
	public abstract void active();
}

@ToString(of = {"model", "price"})
@Setter
@Getter
@AllArgsConstructor
class Car extends VEhicle implements Activeable{
	// 1. filed (data 저장목적)
	private String model;
	private int price;
	// 2. constructor -> method(new 방법)
	// - @Setter,@Getter 어노테이션
	
	
	// 3. 일반 method(기능)
	// - @AllArgsConstructor 어노테이션
	void test1() {
		setCompany("ddd");
		System.out.println(getCompany());
	}
	@Override
	public void active(){
		try {
		int a = 10/0;
		System.out.println(a);
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	// 4. bolck : {}, static{}
	
	
	// 5. inner class : class{}, static class{}, local class ==> method() { class{} }
	
	
}

public class Review {
	public static void main(String[] args) {
		call();
		System.out.println("---main end---");
	}

	private static void call() {
		
		Car car1 = new Car("ABC",1000);
		car1.setModel("DDD");
		car1.setCompany("현대");
		System.out.println(car1.getModel());
		
		car1.active();
		
	}
	
}
