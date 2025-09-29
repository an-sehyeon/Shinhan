package com.shinhan.day09;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

// DTO(Data Transfer Object)


// 어노테이션 사용은 순서 상관없음
@EqualsAndHashCode(of= "stdId")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class StudentDTO {
	
	private final String stdId;
	private final String name;
	private String major;
	private int grade;

}
