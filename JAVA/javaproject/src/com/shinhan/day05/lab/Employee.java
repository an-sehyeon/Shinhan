package com.shinhan.day05.lab;

public class Employee {
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;

	public Employee(String name, String title, int baseSalary) {
		this.name = name;
		this.title = title + "님";
		this.baseSalary = baseSalary;
		getTotalSalary();
	}
	//문자열에서 사용하는 리터럴값은 같은주소의 값을 사용한다. 
	//참조형은 == 은 주소비교이다. 
	//참조형은 값비교시 .equals()기능을 이용한다. 
	public void getTotalSalary() {
//		if(title.equals("부장님")) {
//			totalSalary = (int)(baseSalary + baseSalary * 0.25);
//		}else if(title.equals("과장님")) {
//			totalSalary = (int)(baseSalary + baseSalary * 0.15);
//		}else {
//			totalSalary = (int)(baseSalary + baseSalary * 0.05);
//		}
		
		switch(title) {
			case "부장님"->{totalSalary = (int)(baseSalary + baseSalary * 0.25);}
			case "과장님"->{totalSalary = (int)(baseSalary + baseSalary * 0.15);}
			default->{totalSalary = (int)(baseSalary + baseSalary * 0.05);}
		} 
		
		
		
	}
	public void print() {
		System.out.println(title + " 직급의 "
				+ name
				+ "씨의 본봉은 "
				+ baseSalary
				+ " 원이고 총급여는 "
				+ totalSalary
				+ " 원입니다.");
	}
	
	
}
 
