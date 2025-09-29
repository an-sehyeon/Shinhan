package com.shinhan.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionTest2 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
//		f10();
//		f11();
//		f12();
//		f13();
//		f14();
		f15();
	}
	
	
	private static void f15() {
		List<String> mylist = new ArrayList<>();
		mylist.add("A");mylist.add("B");mylist.add("C");mylist.add("D");
		
		// 수정불가한 Collection : of(), copy(), asList(), 배열 -> list
		
		List<Integer>data = List.of(10,20,30,40,50);
		List<String> data2 = List.of("자바","데이터베이스","프레임워크");
		Set<Integer> data3 = Set.of(10,20,30,40,50);		// 중복된 값은 set만들기 불가 
		Map<String, Integer> data4 = Map.of("A",100,"B",200);
		

		
		
		List<String> data5 = List.copyOf(mylist);
		
		Integer[] arr = {100,90,40,20,70};
		List<String> data6 = Arrays.asList("자바","데이터베이스","프레임워크");
		List<Integer> data7 = Arrays.asList(arr);
		
		
//		data5.add("DDD");
		
		
//		data.add(60);	// 실행오류(Immutable 변경불가)
//		data3.add(60);
		System.out.println(data);
		
		System.out.println(data2.contains("자바"));
		System.out.println(data4);
		System.out.println(data5);
		System.out.println(data6);
		System.out.println(data7);
		
	}
	
	
	
	private static void f14() {
		List<String> data = Collections.synchronizedList(new ArrayList<>());
		
		Thread t1 = new Thread() {
			public void run() {
				for(int i = 1; i <=1000; i++) {
					data.add(i, "내용 : " + i);
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for(int i = 1001; i <=2000; i++) {
					data.add(i, "내용 : " + i);
				}
			}
		};
		try {
			t1.join(); t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.start();
		t2.start();
		System.out.println("map size : " + data.size());
		
	}
		
		
		
		
		
	
	
	
	private static void f13() {
		Map<Integer, String> data = Collections.synchronizedMap(new HashMap<>());
//		Map<Integer, String> data = new HashTable<>();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for(int i = 1; i <=1000; i++) {
					data.put(i, "내용 : " + i);
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for(int i = 1001; i <=2000; i++) {
					data.put(i, "내용 : " + i);
				}
			}
		};
		try {
			t1.join(); t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.start();
		t2.start();
		System.out.println("map size : " + data.size());
		
	}


	private static void f12() {
		// Queue
		// FIFO : 선입선출, 넣기(offer), 빼기(poll)
		Queue<Student> data = new LinkedList<Student>();
		
		Student st1 = Student.builder().stdId("1").name("kim").major("컴공").score(99).build();
		Student st2 = Student.builder().stdId("2").name("kim").major("컴공").score(99).build();
		Student st3 = Student.builder().stdId("3").name("kim").major("컴공").score(99).build();
		Student st4 = Student.builder().stdId("4").name("kim").major("컴공").score(99).build();
		Student st5 = Student.builder().stdId("5").name("kim").major("컴공").score(99).build();
		
		data.offer(st1);
		data.offer(st2);
		data.offer(st3);
		data.offer(st4);
		data.offer(st5);
		System.out.println("사이즈 : " + data.size());
		while(!data.isEmpty()) {
			System.out.println(data.poll());
		}
		System.out.println("사이즈 : " + data.size());
		
		
	}
	
	
	private static void f11() {
		// Stack
		// LIFO : 후입선출, 넣기(push), 빼기(peek)
		
		Stack<Student> st = new Stack<>();
		Student st1 = Student.builder().stdId("1").name("kim").major("컴공").score(99).build();
		Student st2 = Student.builder().stdId("2").name("kim").major("컴공").score(99).build();
		Student st3 = Student.builder().stdId("3").name("kim").major("컴공").score(99).build();
		Student st4 = Student.builder().stdId("4").name("kim").major("컴공").score(99).build();
		Student st5 = Student.builder().stdId("5").name("kim").major("컴공").score(99).build();
		
		st.push(st1);
		st.push(st2);
		st.push(st3);
		st.push(st4);
		st.push(st5);
//		st.add(st1);
//		st.add(st2);
//		st.add(st3);
//		st.add(st4);
//		st.add(st5);
		System.out.println("사이즈 : " + st.size());
		System.out.println("맨 마지막 : " + st.peek());
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
		System.out.println("사이즈 : " + st.size());
		
		
		
		
	}
	
	
	private static void f10() {
		TreeMap<String, Integer> data = new TreeMap<>();
		data.put("apple", 10);
		data.put("aa", 10);
		data.put("bb", 10);
		data.put("apple", 20);		// 키가 중복되면 값이 대체됨.
		data.put("ee", 10);
		data.put("dd", 10);
		
		System.out.println("firstKey : " + data.firstKey());
		System.out.println("firstEntry : " + data.firstEntry());		// key = value
		
		Entry<String, Integer> entry2 = data.firstEntry();
		System.out.println(entry2.getKey() + " ==>" + entry2.getValue());
		
		NavigableMap<String, Integer> data2 = data.descendingMap();
		
		
		System.out.println("================keySet================");
		for(String key:data.keySet()) {
			System.out.println(key + " ->" + data2.get(key));
		}
		
		
		System.out.println("================entrySet================");
		for(Entry<String, Integer> entry : data2.entrySet()) {
			System.out.println(entry.getKey() + "==> "  + entry.getValue());
			
		}
		
		
	}
	
	
	private static void f9() {
		
		TreeSet<Integer> data = new TreeSet<>();
		data.add(100);
		data.add(500);
		data.add(200);
		data.add(400);
		data.add(300);
		
		System.out.println("first : "  + data.first());
		System.out.println("last : "  + data.last());
		System.out.println("lower : "  + data.lower(300));
		System.out.println("higher : "  + data.higher(300));
		System.out.println("floor : "  + data.floor(350));
		System.out.println("ceiling : "  + data.ceiling(299));
		
		NavigableSet<Integer> data2 = data.descendingSet();
		
		System.out.println("================data목록==================");
		for(Integer i:data2) {
			System.out.println(i);
		}
		
		System.out.println("================부분집합==================");
		NavigableSet<Integer> data3 = data.tailSet(300,true);
		for(Integer i:data3) {
			System.out.println(i);
		}
		
		System.out.println("================<=부분집합==================");
		NavigableSet<Integer> data4 = data.subSet(200, true, 400, false);
		for(Integer i:data4) {
			System.out.println(i);
		}
	}
	
	
	private static void f8() {
		// 조회기능이 강화된 Collection
		// 배열, List(ArrayList, LinkedList, Vector), Set(HashSet, TreeSet), Map(HashMap, HashTable, TreeMap)
		TreeSet<Student> data = new TreeSet<>();
		data.add(Student.builder().stdId("1").name("kim").major("컴공").score(99).build());
		data.add(Student.builder().stdId("4").name("kim").major("경제").score(99).build());
		data.add(Student.builder().stdId("2").name("kim").major("통신").score(99).build());
		data.add(Student.builder().stdId("5").name("kim").major("통신").score(99).build());
		data.add(Student.builder().stdId("3").name("kim").major("경영").score(99).build());
		
		Student search = Student.builder().stdId("2").name("kim").major("통신").score(99).build();
		
		System.out.println("first : " + data.first());
		System.out.println("last : " + data.last());
		System.out.println("lower : " + data.lower(search));
		System.out.println("higer : " + data.higher(search));
		
		System.out.println("====================================");
		for(Student s : data) {
			System.out.println(s);
		}
		
		
	}
	
	
	private static void f7() {
		// TreeSet
		TreeSet<Board> data = new TreeSet<>();
		data.add(new Board("b", "b2", "방길동"));
		data.add(new Board("c", "b2", "방길동"));
		data.add(new Board("d", "b2", "방길동"));
		data.add(new Board("a", "b2", "방길동"));
		data.add(new Board("e", "b2", "방길동"));
		
		
		
		for(Board i:data) {
			System.out.println(i);
		}
		
	}
	
	
	private static void f6() {
		// TreeSet (String)
		TreeSet<String> data = new TreeSet<>();
		data.add("A");
		data.add("C");
		data.add("E");
		data.add("D");
		data.add("B");
		
		
		for(String i:data) {
			System.out.println(i);
		}
		
	}
	
	
	private static void f5() {
		// TreeSet (Integer)
		TreeSet<Integer> data = new TreeSet<>();
		data.add(100);
		data.add(500);
		data.add(200);
		data.add(400);
		data.add(300);
		
		for(Integer i:data) {
			System.out.println(i);
		}
		
	}


	private static void f4() {
		Board[] arr = {
				new Board("b", "b2", "방길동"),
				new Board("c", "c2", "c3"),
				new Board("e", "e2", "e3"),
				new Board("d", "d2", "방길동"),
				new Board("c", "a2", "홍길동"),
				new Board("a", "a2", "홍길동"),
		};
		
		// sort기준 변경시
		Arrays.sort(arr,new Comparator<Board>() {
			@Override
			public int compare(Board o1, Board o2) {
				
				return o1.getContent().compareTo(o2.getContent());
			}
		});
		System.out.println("----------------Sort기준 변경----------------------");
		Arrays.sort(arr);
		for(Board b : arr) {
			System.out.println(b);
		}
		
	}
	
	
	private static void f3() {
		String a = "f";
		String b = "c";
		
		System.out.println(a.compareTo(b));
		
		
	}
	
	
	private static void f2() {
		String[] arr = {"java","sql","web","html","js"};
		
		// 자바가 제공하는 sort이용 (Ascending)
//		Arrays.sort(arr);
		
		// sort기준바꾸기 (Dscending)
		Arrays.sort(arr,(o1, o2)-> o2.compareTo(o1));
		
		System.out.println(Arrays.toString(arr));
		
		
		
	}
	

	private static void f1() {
		Integer[] arr = { 80, 66, 90, 54, 79 };

		System.out.println("before: " + Arrays.toString(arr));
		// sort 직접구현
//		f_sort(arr);
		
		// 자바가 제공하는 sort이용 (Ascending)
//		Arrays.sort(arr);
		
		// 자바가 제공하는 sort이용 -> sort기준을 변경하고자한다. 
		// 1)구현class만들기 
//		Arrays.sort(arr, new DescendingInteger());
		
		// 2)익명구현class만들기 
//		Arrays.sort(arr, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o1 - o2;
//			}
//			
//		});
		
		// 3)람다표현식
		Arrays.sort(arr, (a,b)-> b-a);
		System.out.println("after: " + Arrays.toString(arr));
		
		// 

	}

	private static void f_sort(int[] arr) {
		// selection solt (Descending)
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

	}

}
