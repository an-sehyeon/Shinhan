package com.shinhan.day09;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class Member {
	
	private final String id;
	@NonNull private String name;
	private int age;

}
