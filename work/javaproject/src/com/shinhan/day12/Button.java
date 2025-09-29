package com.shinhan.day12;

public class Button {
	
	// 정적 멤버 인터페이스
	// inner class, inner interface
	@FunctionalInterface
	public static interface ClickListener{
		// 추상 메서드
		public abstract void onCick();
		
	}
	
	// 필드
	private ClickListener clickListener;
	
	// 일반 메소드
	void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	// 이 버튼의 동작(Listener)을 구현class에서 정한다.
	// click()메서드에서 그 동작을 호출
	void click() {
		this.clickListener.onCick();
	}

}
