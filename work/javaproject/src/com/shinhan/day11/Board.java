package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// JavaBeans기술 : 기본 생성자 필수(JSP의 Beans, Spring, Mybatis)
// default 생성자, setter, getter 필수

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode//(of = "subject")
public class Board implements Comparable<Board>{
	
	private String subject;
	private String content;
	private String writer;
	
	
	@Override
	public int compareTo(Board obj) {
		// 작성자로 Asc, 작성자가 같으면 subject로 desc
		int comp1 = writer.compareTo(obj.writer);
		if(comp1 == 0) {
			return obj.subject.compareTo(subject);	// desc
		}
		return comp1; // asc
	}
	
}
