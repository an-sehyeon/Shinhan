package com.shinhan.application_office;

import java.util.List;

public class OfficeView {
	
	public static void display(String message) {
		System.out.println(message);
		System.out.println();
	}

	public static void menuDisplay() {
		System.out.println("1.전체 순위 목록");
		System.out.println("2.당첨자 순위 목록");
		System.out.println("3.특정 사용자 조회");
		System.out.println("4.종료");
		System.out.println();
		System.out.print("원하시는 서비스 번호를 입력하세요>>>");
		
	}

	public static void display(List<OfficeDTO> list) {
		if(list == null || list.isEmpty()) {
			display("존재하지 않는 사용자입니다.");
			return;
		}
		for(OfficeDTO office : list) {
		System.out.println("평수 : " + office.getHousing_area() + "평");
		System.out.println("접수번호 : " + office.getBno() + "번");
		System.out.println("이름 : " + office.getName());
		System.out.println("주민등록번호 : " + office.getReg_no());
		System.out.println("전화번호 : " + office.getPhone());
		System.out.println("부양가족에 따른 가점 : " + office.getDependent_point());
		System.out.println("무주택 기간에 따른 가점 : " + office.getNon_home_point());
		System.out.println("청약통장 유지 기간에 따른 가점 : " + office.getAccount_point());
		System.out.println("주소에 따른 가점 : " + office.getAddress_point() + "점");
		System.out.println("결혼 유무 : " + office.getIs_married());
		System.out.println("총점 : " + office.getTotal_score() + "점");
		System.out.println("순위 : " + office.getArea_rank() + "위");
		System.out.println("-------------------------------");
		}
		
	}

}
