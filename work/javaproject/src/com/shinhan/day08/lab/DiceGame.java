package com.shinhan.day08.lab;

class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;
		return number;
	}
}

public class DiceGame {
	public static void main(String args[]) {
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);

		int result2 = game.countSameEye(-10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);

	}

	int countSameEye(int n) {

		try { // 예외처리하기
			if (n < 0) {
				throw new IllegalArgumentException2("던지는 횟수는 음수가 될 수 없습니다."); // 강제 Exception 발생
			}
		} catch (IllegalArgumentException e) {
			System.out.println("에러");

		}
		Dice d1 = new Dice(8);
		Dice d2 = new Dice(8);
		int result = 0;

		for (int i = 1; i <= n; i++) {
			int su1 = d1.play();
			int su2 = d2.play();
			if (su1 == su2)
				result++;
			System.out.println(su1 + " + " + su2);
		}

		return result;
	}
}
