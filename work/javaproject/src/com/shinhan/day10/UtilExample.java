package com.shinhan.day10;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Pair<K, V>{
	private K key;
	private V value;
}


class ChildPair<K,V> extends Pair<K, V>{
	public ChildPair(K k, V v) {
		super(k, v);
		
	}
}


class Util{
	//<P extends Pair<K,V>,K,V>
		//<T extends Number> //Number, Integer, Double......
		//<T super Number> : 타입의 추론이 모호 Number, Object
		//2)와일드가드 사용시(메서드매개변수, 변수선언)는 extends, super모두 가능
		// Applicant<? extends Student>
		// Applicant<? super Worker
		static <P extends Pair<K,V>,K,V>  V getValue3(P pair, K key) {
			
			List<? super Number> alist = new ArrayList<>();
			List<? extends Number> alist2 = new ArrayList<>();
			List<?> alist3 = new ArrayList<>();
			
			
			if(pair.getKey().equals(key)) {
				return pair.getValue();
			}
			
			
			return null;
		}

	
	
	static <K,V> V getValue(Pair<K,V> pair, K key){ 
		if(pair.getKey().equals(key)) {
			return pair.getValue();
		}
		
		return null;
	}
	
	
	static <P extends Pair<K,V>, K, V> V getValue2(P pair, K key) {
		if(pair.getKey().equals(key)) {
			return pair.getValue();
		}
		
		return null;
	}
}


@AllArgsConstructor
@Getter
class OtherPair<K,V>{
	private K key;
	private V value;
}

public class UtilExample {
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("홍길동", 35);
		Integer age = Util.getValue2(pair,"홍길동");
		System.out.println(age);
		
		ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원",20);
		Integer childAge = Util.getValue2(childPair, "홍삼순");
		
//		OtherPair<String, Integer> otherPair = new OtherPair<>("홍삼원", 20);
//		int otherAge = Util.getValue2(otherPair, "홍삼원");
//		System.out.println(otherPair);
	}

}

/*OtherPair<String, Integer> otherPair = new OtherPair<>("홍삼원", 20);
//OtherPair는 Pair를 상속하지 않으므로 컴파일 에러가 발생
int otherAge = Util.getValue(otherPair, "홍삼원");
System.out.println(otherAge);*/
