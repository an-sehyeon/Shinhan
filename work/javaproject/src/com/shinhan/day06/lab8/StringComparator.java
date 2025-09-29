package com.shinhan.day06.lab8;

public class StringComparator {
	public static void main(String[] args) {
		StringComparator sc = new StringComparator();
		int result1 = sc.compare("Yongari-2001", "DragonWar", true);
		int result2 = sc.compare("Yongari-2001", "DragonWar", false);
		System.out.println(result1);// 12
		System.out.println(result2);// 9

	}

	private int compare(String string, String string2, boolean b) {
		
		return 0;
	}
}
