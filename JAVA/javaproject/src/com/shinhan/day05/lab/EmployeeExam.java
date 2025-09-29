package com.shinhan.day05.lab;

public class EmployeeExam {

	
	public static void f2(String[] args) {
		Employee2[] empArr = new Employee2[4];
		double[] bonus = {0.1,0.2,0.3,0.4 };
		int index=0;
		empArr[0] = new Employee2("zzilre1", "유채승", 1500000);
		empArr[1] = new Employee2("zzilre2", "이재희", 1300000);
		empArr[2] = new Employee2("zzilre3", "최다희", 1200000);
		empArr[3] = new Employee2("zzilre4", "박채원", 1000000);
		for(Employee2 emp:empArr) {
			//객체를 출력하면 자동으로 toString()호출된다. 
			System.out.println(emp + " 보너스 포함 급여는 " + emp.getSalary(bonus[index++]));
		}
		System.out.println(1300000*1.2 + ":" + 1200000*1.3);
	}
	
	
	
	public static void main(String[] args) {
		
		Employee[] empArr = new Employee[4];
		
		empArr[0] = new Employee("이부장", "부장", 1500000);
		empArr[1] = new Employee("김과장", "과장", 1300000);
		empArr[2] = new Employee("최대리", "대리", 1200000);
		empArr[3] = new Employee("박사원", "사원", 1000000);
		
		for(Employee emp:empArr) {
			emp.print();
		}

	}

}

/*
부장 직급의 이부장씨의 본봉은 1500000 원이고 총급여는 1875000 원입니다.
과장 직급의 김과장씨의 본봉은 1300000 원이고 총급여는 1495000 원입니다.
대리 직급의 최대리씨의 본봉은 1200000 원이고 총급여는 1260000 원입니다.
사원 직급의 박사원씨의 본봉은 1000000 원이고 총급여는 1050000 원입니다.
*/
