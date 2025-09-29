package com.shinhan.day09.lab2;

class MySum {
	int first;
	int second;

	MySum(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	/* 조건1  toString()재정의 */
	@Override
	public String toString() {
		return String.valueOf(first + second);
	}

	
	/* 조건2 equals()재정의 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MySum)) return false;
		MySum other = (MySum)obj;
		return this.toString().equals(other.toString());
	}
}


public class OverridingTest {
	public static void main(String[] args) {

		int i = 10;
		int j = 20;
		String s1 = "30";

		MySum ms1 = new MySum(j, i);
		MySum ms2 = new MySum(i, j);

		System.out.println(ms1);
		System.out.println(ms1.toString());

		if (ms1.equals(ms2)) {
			System.out.println("ms1 과 ms2 의 합계는 동일합니다.");
		} else {
			System.out.println("ms1 과 ms2 의 합계는 동일하지 않습니다.");
		}

		if (ms1.equals(s1)) {
			System.out.println("ms1 과 ms2 의 합계는 동일합니다.");
		} else {
			System.out.println("ms1 과 ms2 의 합계는 동일하지 않습니다.");
		}
	}
}
