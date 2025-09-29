package com.shinhan.day03;

public class LAB3 {

	public static void main(String[] args) {
		printSeason(Integer.parseInt(args[0]));
	}

	private static void printSeason(int month) {
		String season;
		switch(month) {
		case 3,4,5 ->{season = "봄";}
		case 6,7,8 ->{season = "여름";}
		case 9,10,11 ->{season = "가을";}
		case 12,1,2 ->{season = "겨울";}
		default ->{System.out.println("1~12 사이의 숫자만 입력하셔야 합니다."); return;}
		}
		System.out.println(season + "에 태어나셨네요");
	}

}
