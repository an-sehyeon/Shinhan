package com.shinhan.day05.lab;

public class Employee {
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;
	
	public Employee() {
		this(null,null,0);
	}
	
	public Employee(String title) {
		this(null,title,0);
	}
	public Employee(String name, String title, int baseSalary) {
		super();
		this.name = name;
		this.title = title + "님";
		this.baseSalary = baseSalary;
		getTotalSalary();
	}
	
	
	// 문자열에서 사용하는 리터럴 값은 같은 주소의 값을 사용
	// 참조형 == 은 주소비교이다.
	// 참조형은 값비교시 .equals()기능을 이용해야됨.
	public void getTotalSalary() {
		
		if(title.equals("부장님")) {
			totalSalary = (int) (baseSalary + baseSalary * 0.25);
		}else if(title.equals("과장님")) {
			totalSalary = (int) (baseSalary + baseSalary * 0.15);
		}else {
			totalSalary = (int) (baseSalary + baseSalary * 0.05);
		}
	}
	
	public void print() {
		System.out.println(	title
							+ " 직급의 "
							+ name
							+ "씨의 본봉은 "
							+ baseSalary
							+ "원이고 총급여는 "
							+ totalSalary
							+ "입니다.");
	}
	
	

}
