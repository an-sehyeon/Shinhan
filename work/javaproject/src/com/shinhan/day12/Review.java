package com.shinhan.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import lombok.Builder;

public class Review {
	public static void main(String[] args) {
//		 Collection add() : List, Set : interface
//		 					map
//		 List : ArrayList. LinkedList, Vector : 순서있음, 중복가능
//		 Set : HashSet(순서없음), TreeSet(순서있음) : 키 중복 불가
		// Map : 키와 값의 쌍, HashMap, Hashtable, TreeMap
		
		List<Integer> a1 = new ArrayList<>();
		List<Integer> a2 = new LinkedList<>();
		List<Integer> a3 = new Vector<>();
		
		Set<Integer> a4 = new HashSet<>();
		Set<Integer> a5 = new TreeSet<>();				// Comparable를 구현한 class만 add()가능
		
		Map<String, Integer> a6 = new HashMap<>();		// 키는 중복불가 (hashcode, equals 동일성체크)
		Map<String, Integer> a7 = new Hashtable<>();	// Thread에 안정적
		Map<String, Integer> a8 = new TreeMap<>();		// Comparable를 구현한 class만 put()가능
		
		Stack<Integer> a9 = new Stack<Integer>();		// LIFO 후입선출
		Queue<Integer> a10 = new LinkedList<>();		// FIFO 선입선출
		
//		Set<Book> data = new HashSet<>();
//		Set<Book> data = new TreeSet<>();
//		data.add(new Book("A", 300));
//		data.add(new Book("B", 300));
//		data.add(new Book("A", 200));
//		System.out.println(data.size());
//		for(Book b:data) {
//			System.out.println(b);
//		}
		
		// Key값으로 sort된다.
		Map<Book, Integer> data2 = new TreeMap<>();
		data2.put(new Book("A",300),1000);
		data2.put(new Book("B",500),2000);
		data2.put(new Book("C",300),3000);
		System.out.println(data2.size());
		for(Entry<Book,Integer> entry : data2.entrySet()) {
//			System.out.println("key : " entry.getKey());
//			System.out.println("key : " entry.getvalue());
			System.out.println("=================================" );
		}
		
	}
	
}

//@Data
@Builder
class Book implements Comparable<Book>{
	String title;
	int price;
	
	@Override
	public int compareTo(Book obj) {
		int comp1 = price - obj.price;
		if(comp1 == 0) return obj.title.compareTo(title);	// DESC
		return comp1;		// ASC
	}
	
//	public Book(String title, int price) {
//		super();
//		this.title = title;
//		this.price = price;
//	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(price, title);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Book other = (Book) obj;
//		return price == other.price && Objects.equals(title, other.title);
//	}
	
	
	
}


















