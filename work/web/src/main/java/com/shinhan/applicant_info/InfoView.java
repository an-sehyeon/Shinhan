package com.shinhan.applicant_info;

import com.shinhan.unit_price_by_area.AreaInfoDTO;

public class InfoView {
	public static void display(InfoDTO info) {
		if(info == null) {
			display("해당하는 사용자의 정보가 존재하지 않습니다.");
			return;
		}
		System.out.println("접수번호 : " + info.getBno() + "번");
		System.out.println("이름 : " + info.getName());
		System.out.println("주민등록번호 : " + info.getReg_no());
		System.out.println("전화번호 : " + info.getPhone());
		System.out.println("결혼유무 : " + info.getIs_married());
		System.out.println("부양가족 수 : " + info.getDependent_count() + "명");
		System.out.println("주소 : " + info.getAddress());
		System.out.println("통장 개설 연도 : " + info.getAccount_open_date() + "년");
		System.out.println("무주택 기간 : " + info.getNon_home_start_date() + "년");
		System.out.println("신청하려는 평수 : " + info.getHousing_area() + "평");
		System.out.println();
	}
	
	public static void display(AreaInfoDTO areaInfo) {
		if(areaInfo == null) {
			System.out.println("해당하는 사용자의 정보가 존재하지 않습니다.");
			return;
		}
		System.out.println(areaInfo.getHousing_area() + "평의 분양 자금 정보 입니다.");
		System.out.println("계약금은 " + areaInfo.getDown_payment() + "원 입니다.");
		System.out.println("중도금은 " + areaInfo.getInterim_payment() + "원 입니다.");
		System.out.println("잔금은 " + areaInfo.getBalace_payment() + "원 입니다.");
		System.out.println("총 분양금은 " + areaInfo.getTotal_price() + "원 입니다.");
		System.out.println();
	}
	
	public static void display(String message) {
		System.out.println(message);
		System.out.printf("\t=========    ====    =========\n");
		System.out.printf("\t========  ===    ===  ========\n");
		System.out.printf("\t=======   Good Luck!!!  =======\n");
		System.out.printf("\t========  ==========  ========\n");
		System.out.printf("\t==========  ======  ==========\n");
		System.out.printf("\t============  ==  ============\n");
		System.out.printf("\t==============   =============\n");
		System.out.println();
	}
	
	
	
	public static void menuDisplay() {
		System.out.println("1.정보입력");
		System.out.println("2.정보수정");
		System.out.println("3.정보삭제");
		System.out.println("4.내 정보 조회");
		System.out.println("5.신청한 타입 정보 조회");
		System.out.println("6.당첨 조회");
		System.out.println("7.종료");
		System.out.print("원하시는 서비스 번호를 입력하세요>>>");
	}




}
