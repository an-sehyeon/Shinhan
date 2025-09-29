package com.shinhan.day12;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) throws URISyntaxException, IOException {
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
//		f15();
//		f16();
//		f17();
//		f18();
//		f19();
//		f20();
//		f21();
//		f22();
		f23();
	}
	
	private static void f23() {
		Random random = new Random();
		List<Integer> scores = new ArrayList<Integer>();
		for(int i=0;i<10000;i++) {		// int최대 : 2147483647
			scores.add(random.nextInt(101));	// 0 < 101
		}
		
		long start = 0;
		long end = 0;
		long time = 0;
		double avg = 0;
		
		Stream<Integer> stream = scores.stream();
		start = System.nanoTime();
		avg = stream.mapToInt(i->i.intValue()).average().getAsDouble();
		end = System.nanoTime();
		time = end - start;
		System.out.println("평균 : " + avg + " 일반 스트림으로 처리하는데 걸리는 시간(ns) : " + time);
		
		
		Stream<Integer> stream2 = scores.parallelStream();
		start = System.nanoTime();
		avg = stream2.mapToInt(i->i.intValue()).average().getAsDouble();
		end = System.nanoTime();
		time = end - start;
		System.out.println("평균 : " + avg + " parallelStream 스트림으로 처리하는데 걸리는 시간(ns) : " + time);
		
	}

	private static void f22() {
		List<ShinhanStudent2> data = List.of(
				new ShinhanStudent2("김",100,"남"),
				new ShinhanStudent2("박",90,"여"),
				new ShinhanStudent2("정",70,"남"),
				new ShinhanStudent2("양",88,"여"),
				new ShinhanStudent2("최",99,"남")
				);
		
		Map<String, List<ShinhanStudent2>> groupMap = 
				data.stream().collect(Collectors.groupingBy(st -> st.getGender()));
		for(String key:groupMap.keySet()) {
			System.out.println(key + "=>" + groupMap.get(key));
		}
		
		Map<String, Double> groupMap2 = 
				data.stream().collect(
						Collectors.groupingBy(st -> st.getGender(),
								Collectors.averagingDouble(st->st.getScore())));
		
		for(String key : groupMap2.keySet()) {
			System.out.println(key + " => " + groupMap2.get(key));
		}
		
	}
	
	private static void f21() {
		Map<String, Integer> map = new TreeMap<>();
		map.put("bnanana", 3);
		map.put("apple", 6);
		map.put("apple", 2);
		map.put("apple", 8);
		map.put("cherry", 9);
		System.out.println(map);
		System.out.println(map.get("apple"));
		
		
	}

	private static void f20() {
		ShinhanStudent[] arr = { 
				new ShinhanStudent("A", 100), 
				new ShinhanStudent("V", 90), 
				new ShinhanStudent("C", 60),
				new ShinhanStudent("D", 70), 
				new ShinhanStudent("E", 80) };
		List<ShinhanStudent> data = Arrays.asList(arr);
		
		List<ShinhanStudent> data2 = data.stream().filter(st->st.getScore()>=70).toList();
		System.out.println(data2);
		
		
		// List -> Map
		Map<String, Integer> data3 = data.stream()
		.filter(st->st.getScore()>=70)
		.collect(
				Collectors.toMap(
						st2->st2.getName(),
						st2-> st2.getScore()
						)
				);
		System.out.println(data3);
		
		
		
	}

	private static void f19() {
		ShinhanStudent[] arr = { 
				new ShinhanStudent("A", 100), 
				new ShinhanStudent("V", 90), 
				new ShinhanStudent("C", 60),
				new ShinhanStudent("D", 70), 
				new ShinhanStudent("E", 80) };
		List<ShinhanStudent> data = Arrays.asList(arr);
		int sum1 = data.stream().mapToInt(st->st.getScore()).sum();
		int sum2 = data.stream().mapToInt(st->st.getScore()).reduce(0,(a,b)->a+b);
		
		
		System.out.println(sum1);
		System.out.println(sum2);
		
		
	}

	private static void f18() {
		List<Integer> list = new ArrayList<>();
//		list.add(10);
//		list.add(20);
//		list.add(30);

		// 1) data 없으면 오류
//		double d1 = list.stream().mapToInt(i->i.intValue()).average().getAsDouble();
//		System.out.println(d1);

		// 2) 값이 있는 경우만 얻는다(오류없음)
//		list.stream().mapToInt(i -> i.intValue()).average().ifPresent(avg -> {
//			System.out.println(avg);
//		});
		

	}

	private static void f17() {
		int[] arr = { 100, 20, 30, 40, 50 };

		long count = Arrays.stream(arr) // original strieam
				.filter(score -> score >= 50) // 중간
				.count(); // 최종
		System.out.println(count);

		OptionalDouble opDouble = Arrays.stream(arr).filter(score -> score < 0).average();
		// 값이 있는 경우만 사용하기
//		if(opDouble.isPresent()) {
//			double result = opDouble.getAsDouble();
//			System.out.println(result);
//		}

		double result = opDouble.orElse(0);
		System.out.println(result);

		int max = Arrays.stream(arr).max().orElse(0);
		System.out.println(max);

	}

	private static void f16() {
		int[] arr = { 100, 20, 30, 40, 50 };

		boolean result = Arrays.stream(arr).allMatch(score -> score >= 20);
		boolean result2 = Arrays.stream(arr).anyMatch(score -> score >= 90);
		boolean result3 = Arrays.stream(arr).noneMatch(score -> score < 0);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);

	}

	private static void f15() {
		int[] arr = { 100, 20, 30, 40, 50 };

		Arrays.stream(arr) // original stream
				.peek(score -> System.out.println(score)) // 중간
				.sum();
		System.out.println("총합 : " + sum);

		Arrays.stream(arr) // original stream
				.forEach(score -> {
					System.out.println(score); // 최종
				});

	}

	private static void f14() {
		ShinhanStudent[] arr = { new ShinhanStudent("A", 100), new ShinhanStudent("V", 90), new ShinhanStudent("C", 60),
				new ShinhanStudent("D", 70), new ShinhanStudent("E", 80) };
		List<ShinhanStudent> data = Arrays.asList(arr);
		data.stream()
//		.sorted()
				.sorted((a, b) -> a.getName().compareTo(b.getName())).forEach(st -> {
					System.out.println(st);
				});

	}

	private static void f13() {
		// 문자 -> 숫자
		List<String> alist = Arrays.asList("10, 20, 30", "40, 50");
		alist.stream().flatMapToInt(s -> {
			String[] strArr = s.split(",");
			int[] intArr = new int[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(intArr);
		}).forEach(a -> {
			System.out.println(a);
		});

	}

	private static void f12() {
		List<String> alist = new ArrayList<String>();
		alist.add("this is java");
		alist.add("i am a best developer");

		alist.stream().flatMap(st -> Arrays.stream(st.split(" "))).forEach(word -> {
			System.out.println(word);
		});
		System.out.println("----------------------------------");
		String[] arr = "this is java".split(" ");
		Arrays.stream(arr).forEach(a -> System.out.println(a));

	}

	private static void f11() {
		int[] arr = { 1, 2, 3, 4, 5 }; // new Integer(1)
		Arrays.stream(arr).boxed()
//		.asDoubleStream()
				.forEach(i -> {
					System.out.println(i.doubleValue());
//			System.out.println(i);
				});

	}

	private static void f10() {
		ShinhanStudent[] arr = { 
				new ShinhanStudent("A", 100), 
				new ShinhanStudent("V", 90), 
				new ShinhanStudent("C", 60),
				new ShinhanStudent("D", 70), 
				new ShinhanStudent("E", 80) };
		
		List<ShinhanStudent> data = Arrays.asList(arr);
		
		data.stream().mapToInt(st -> st.getScore()).filter(score -> score >= 80).forEach(st -> {
			System.out.println(st);
		});

	}

	private static void f9() {
		List<Integer> alist = List.of(100, 50, 30, 100, 60, 60, 100, 40, 80, 30, 90);

		alist.stream().distinct().filter(s -> s >= 80).forEach(s -> {
			System.out.println(s);
		});

	}

	private static void f8() {
		List<String> alist = List.of("1월", "금", "1월", "금", "1월", "2화", "수", "2목", "4금", "3월", "화", "수", "목", "금");
		alist.stream()
				.distinct() // 중복 배제
				.filter(s -> s.startsWith("2")) // 필터
				.forEach(s -> {
					System.out.println(s);
				});

	}

	private static void f7() throws URISyntaxException, IOException {
		// getEResource()는 bin에 접근
		Class cls = StreamTest.class;
		Path path = Paths.get(cls.getResource("data.txt").toURI());
		Stream<String> st = Files.lines(path);
		st.forEach(s -> {
			System.out.println(s);
		});

	}

	static int sum = 0;

	private static void f6() {
		// 1~10

		IntStream.rangeClosed(1, 10).forEach(i -> {
			// 자바가 람다표현식 -> 익명구현class로 변경. 메서드내의 class는 Local Class이다
			// Local Class는 지역변수를 변경할 수 없다. 접근만 가능(final)
			sum += i;
			System.out.println("누적 : " + sum);
		});
		System.out.println("합계 : " + sum);

	}

	private static void f5() {
		ShinhanStudent[] arr = { 
				new ShinhanStudent("A", 100), 
				new ShinhanStudent("V", 90), 
				new ShinhanStudent("C", 60),
				new ShinhanStudent("D", 70), 
				new ShinhanStudent("E", 80) };
		
		List<ShinhanStudent> data = Arrays.asList(arr);
		
		double avg = data.stream().mapToInt(st -> st.getScore()).average().getAsDouble();
		System.out.println(avg);

	}

	private static void f4() {
		List<String> alist = List.of("월", "화", "수", "목", "금", "월", "화", "수", "목", "금");
//		alist.stream().forEach(s->{
//			System.out.println(Thread.currentThread().getName() + " : " + s);
//		});

		alist.parallelStream().forEach(s -> {
			System.out.println(Thread.currentThread().getName() + " : " + s);
		});
//		
	}

	private static void f3() {
		String[] arr = { "a", "b", "c", "자바", "web" };
		Arrays.stream(arr).forEach(s -> System.out.println(s));

	}

	private static void f2() {
		// 내부 반복자 : 스트림
		int[] arr = { 10, 20, 30, 40, 50 };

//		IntConsumer ic = i->{};

		Arrays.stream(arr).forEach(i -> {
			System.out.println(i);
		});

	}

	private static void f1() {
		// 외부 반복자를 이용하기
		int[] arr = { 10, 20, 30, 40, 50 };
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
