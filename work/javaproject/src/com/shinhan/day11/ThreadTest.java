package com.shinhan.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {

	public static void main(String[] args) {
//		autoSave();
//		call();
//		call2();
		
//		try {
//			call3();
//		}catch(InterruptedException | ExecutionException e) {
//			e.printStackTrace();
//		}
		
		call4();
		
		System.out.println("Main 종료");
	}

	private static void call4() {
		Thread thread1 =  new MovieThread();
		thread1.start();
		
		Thread thread2 = new Thread(new MusicRunnable());
		thread2.start();
	}

	private static void call3() throws InterruptedException, ExecutionException {
		List<Future<Integer>> arr = new ArrayList<>();
		
		ExecutorService exService = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 100; i++) {
			int index = i;
			Future<Integer> result = exService.submit(new Callable<Integer>() {
				
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int num = 1; num <= index; num++) {
						sum += num;
					}
					System.out.println(Thread.currentThread().getName() + " ====>" + index + "까지의 합계 : " + sum);
					return sum;
				}
				
			});
			arr.add(result);
//			System.out.println("Future로 받은 result = " + result.get());
		}
		for(Future<Integer> f: arr) {
			System.out.println(f.get());
		}
		
	}

	private static void call2() {
		ExecutorService exService = Executors.newFixedThreadPool(5);	// 스레드풀을 몇개 사용할지 정하기
		for (int i = 1; i <= 100; i++) {
			int index = i;
			Runnable r1 = () -> {
				int sum = 0;
				for(int num=1; num<=index; sum++) {
					sum += num;
				}
				System.out.println(Thread.currentThread().getName() + " ====>" + index + "까지의 합계 : " + sum);
			};
			exService.execute(r1);
		}

	}

	private static void call() {
		// 1~100까지 loop, 1~1, 1~2, 1~3...1~100

		for (int i = 1; i <= 100; i++) { // local class에서 local변수를 접근하면 이 변수는 final이다. (수정불가)
			int index = i;
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					int sum = 0;
					for (int num = 1; num <= index; num++) {
						sum += num;
					}
					System.out.println(Thread.currentThread().getName() + " : + " + index + "까지의 합계 : " + sum);
				}
			});
			t1.start();
		}
	}

	private static void autoSave() {
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true); // Daemon : 메인 종료시 자동으로 끝남
		t1.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("autoSave 함수종료");
	}

}
