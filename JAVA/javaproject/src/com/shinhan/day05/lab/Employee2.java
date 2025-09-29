package com.shinhan.day05.lab;

public class Employee2 extends Object{
	private String id;
	private String name;
	private int baseSalary;
	public Employee2(String id, String name, int baseSalary) {
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
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
		double salary = baseSalary + baseSalary * bonus ; 
		return salary;
	}
	//toString()은 모든 class의 부모class로 사용하는 Object에서 제공되는 함수이다. 재정의가능하다.
	//재정의(Override) : 메서드이름같고 매개변수개수와 타입이 같고 return 타입같고 
	//접근지정자(Modifier)는 같고나 더 넓어져야한다.
	//접근권한 : public > protected >생략 > private
	public String toString() {
		String result =  name
				+ "("
				+ id
				+ ") 사원의 기본급은 "
				+ baseSalary
				+ "원 입니다. ";
		return result;
	}
	
	
	String toString2() {
		String result =  name
				+ "("
				+ id
				+ ") 사원의 기본급은 "
				+ baseSalary
				+ "원 입니다.!!!!";
		return result;
	}
}
 






