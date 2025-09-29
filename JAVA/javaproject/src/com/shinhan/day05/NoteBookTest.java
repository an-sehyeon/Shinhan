package com.shinhan.day05;

public class NoteBookTest {

	public static void main(String[] args) {
		NoteBook aa = new NoteBook("ABC", "Samsung", 300);
		System.out.println(aa.getModel());
		aa.setModel("PPPP" );
		System.out.println(aa.getModel());
	}

}
