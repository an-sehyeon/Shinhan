package com.shinhan.day12;

public class ButtonExample {

	public static void main(String[] args) {
		
		// 1.구현 class사용
		Button saveButton = new Button();
		SaveListener listener = new SaveListener();
		saveButton.setClickListener(listener);
		saveButton.click();
		
		
		
		saveButton.setClickListener(() -> {
			System.out.println("Ok 버튼을 클릭했습니다.");
		});
		
		saveButton.click();	// Ok 버튼 클릭
		
		
		Button btnCancel = new Button();	// Cancel버튼 객체 생성
		// 람다표현식
		btnCancel.setClickListener(()->{
			System.out.println("Cansel 버튼을 클릭했습니다.");
		});
		
		btnCancel.click();
		
		work(listener);
	}
	
	private static void work(SaveListener listener) {
		Button button = new Button();
		// button에 listener를 넣는다.
		button.setClickListener(listener);
		
		// button을 클릭한다.
		button.click();
		
	}


}
