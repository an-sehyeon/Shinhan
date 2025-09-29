package com.shinhan.applicant_info;

import com.shinhan.unit_price_by_area.AreaInfoDTO;

public class InfoService {
	InfoDAO infoDAO = new InfoDAO();


	public int insertInfo(InfoDTO info) {
		int result = infoDAO.insertInfo(info);
		if(result > 0) {
		System.out.println("정상적으로 접수가 " + result + "건 완료되었습니다!!!");
		}else {
			InfoView.display("회원정보 저장 실패");
		}
		return result;
	}
	
	
	public int updateInfo(InfoDTO info) {
		int result = infoDAO.updateInfo(info);
		if(result == 0) {
		System.out.println("수정에 실패하셨습니다.");
		}
		return result;
	}
	
	
	public int deleteInfo(String name, String reg_no, int bno) {
		int result = infoDAO.deleteInfo(name,reg_no,bno);
		System.out.println("InfoService에서 로그 출력: " + result + "건 delete");		
		return result;
	}
	

	
	public InfoDTO selectMyInfo(String name, String reg_no) {
		InfoDTO info = infoDAO.selectMyInfo(name, reg_no);
		if(info != null) {
			System.out.println("========================" + name + "님의 정보입니다.========================");
		}else {
			
		}
		return info;
	}
	
	
	public AreaInfoDTO housingAreaInfo(String name, String reg_no) {
		AreaInfoDTO areaInfo = infoDAO.housingAreaInfo(name, reg_no);
		if(areaInfo != null) {
			System.out.println("=====" + name + "님이 신청하신 평수의 분양 자금 정보입니다.=====");
		}
		return areaInfo;
	}
	
	
	public InfoDTO lotte_check(int bno, String name, String reg_no) {
		InfoDTO info = infoDAO.lotte_check(bno, name, reg_no);
		
		if(info != null) {
			System.out.println("축하 드립니다!!! " + name + "님은 로또 당첨되셨습니다!!!!");
			System.out.printf("\t=========    ====    =========\n");
			System.out.printf("\t========  ===    ===  ========\n");
			System.out.printf("\t=======    축하축하!!!  =======\n");
			System.out.printf("\t========  ==========  ========\n");
			System.out.printf("\t==========  ======  ==========\n");
			System.out.printf("\t============  ==  ============\n");
			System.out.printf("\t==============   =============\n");
			
		}else {
			System.out.println("아쉽지만 " + name + "님은 다음 기회를 노리세요");
			System.out.println();
		}
		return info;
	}

}
