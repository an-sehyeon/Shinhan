package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Data;

// 제네릭 타입으로 변경하기
@AllArgsConstructor
@Data
public class Bag<M,S,C> {
	M model;
	S size;
	C color;
	
	
	
	
}
