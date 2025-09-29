package com.shinhan.day05.lab;

public class EmployeeExam {
	public static void main(String[] args) {
		Employee2[] empArr = new Employee2[4];
		double[] bonus = {0.1,0.2,0.3,0.4};
		int index = 0;

		empArr[0] = new Employee2("adfadf1","이부장",1500000);
		empArr[1] = new Employee2("adfadf2","김과장",1300000);
		empArr[2] = new Employee2("adfadf3","최대리",1200000);
		empArr[3] = new Employee2("adfadf4","박사원",1000000);
		
		for(Employee2 emp:empArr) {
			// 객체를 출력하면 자동으로 toString()호출된다
			System.out.println(emp + " 보너스 포함 급여는 " + emp.getSalary(bonus[index++]));
//			System.out.println(emp.toString2());
		}
		
	}

	public static void f1(String[] args) {
		Employee[] empArr = new Employee[4];

		empArr[0] = new Employee("이부장","부장",1500000);
		empArr[1] = new Employee("김과장","과장",1300000);
		empArr[2] = new Employee("최대리","대리",1200000);
		empArr[3] = new Employee("박사원","사원",1000000);
		
		for(Employee emp:empArr) {
			emp.print();
		}
		
		
	}

}
