package com.shinhan.day10;

import lombok.Getter;

class Container<T> {
	T data;
	
	T get() {
		return data;
	}
	
	void set(T data) {
		this.data = data;
	}
}

@Getter
class ContainerB<K,V>{
	K key;
	V value;
	void set(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

public class ContainerExample {
	public static void main(String[] args) {
		ContainerB<String, String> container1 = new ContainerB<String, String>();
		container1.set("홍길동", "도적");
		String name1 = container1.getKey();
		String job = container1.getValue();
		System.out.println(name1 + " : " + job);
		ContainerB<String, Integer> container2 = new ContainerB<String, Integer>();
		container2.set("홍길동", 35);
		String name2 = container2.getKey();
		int age = container2.getValue();
		System.out.println(name2 + " : " + age);
	}

	public static void main2(String[] args) {
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();
		Container<Integer> container2 = new Container<Integer>();
		container2.set(6);
		int value = container2.get();
		System.out.println(str);
		System.out.println();
	}

}
