package com.shinhan.day05.lab;

public class Employee2 {
	String id;
	String name;
	int baseSalary;
	
	public Employee2(String id, String name, int baseSalry) {
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalry;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseSalry() {
		return baseSalary;
	}

	public void setBaseSalry(int baseSalry) {
		this.baseSalary = baseSalry;
	}
	
	double getSalary(double bonus) {
		double salary = baseSalary + baseSalary * bonus;
		return salary;
	}
	
	// toString()은 모든 class의 부모class로 사용하는 object에서 제공되는 함수, 재정의 가능
	// 재정의 : Overriding => 메서드이름이 같고, 매개변수 개수와 타입이 같고 return과 타입도 같아야 한다.
	// 접근지정자(Modifier)는 같거나 더 넓어져야한다.
	// 접근 권한 : public > protected > 생략 > private
	public String toString() {
		String result =   name
						+ "("
						+ id
						+ ") 사원의 기본급은 "
						+ baseSalary
						+ "원 입니다.";
		return result;
	}
	
	String toString2() {
		String result =   name
						+ "("
						+ id
						+ ") 사원의 기본급은 "
						+ baseSalary
						+ "원 입니다.";
		return result;
	}
	

}
