package com.shinhan.day12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ShinhanStudent implements Comparable<ShinhanStudent>{
	String name;
	int score;
	
	@Override
	public int compareTo(ShinhanStudent obj) {
		// TODO Auto-generated method stub
		return obj.score -score;	// desc
	}

}
