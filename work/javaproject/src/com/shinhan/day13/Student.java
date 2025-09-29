package com.shinhan.day13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private String name;
	private int englishScore;
	private int mathScore;

}

@FunctionalInterface
interface Funtion<T>{
	public double apply(T t);
}
