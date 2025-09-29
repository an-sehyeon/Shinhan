package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student implements Comparable<Student>{
	private String stdId;
	private String name;
	private String major;
	private int score;
	
	
	@Override
	public int compareTo(Student obj) {
		int comp1 = obj.score - score;
		if(comp1 == 0) {
			int comp2 = major.compareTo(obj.major);
			if(comp2 == 0) return obj.stdId.compareTo(stdId);
			return comp2;
		}
		
		return comp1;
	}
}

/*
 * 학생이 5명있다.
 * 조회하면 점수순으로 desc
 * 점수가 같으면 전공으로 asc
 * 전공같으면 학번 desc
 * 
 * 나(this)먼저 작성하고 들어온 data(매개변수)작성하면 ASC
 * 반대는 DESC
 */
