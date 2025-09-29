package com.shinhan.application_office;

import java.util.List;

public class OfficeService {
	OfficeDAO officeDAO = new OfficeDAO();
	
	public List<OfficeDTO> selectAllList(int area) {
		List<OfficeDTO> list = officeDAO.selectAllList(area);
		if(list != null) {
			System.out.println("==================" + area + "평 사용자들의 전체  순위 목록입니다.==================");
		}else {
			System.out.println("OfficeService에서 오류 출력 ");
		}
		
		return list;
	}
	
	public List<OfficeDTO> luckyList(int area){
		List<OfficeDTO> list = officeDAO.luckyList(area);
		if(list != null) {
			System.out.println("==================" + area + "평 당첨자 목록입니다..==================");
		}else {
			System.out.println("OfficeService에서 오류 출력 ");
		}
		
		return list;
	}
	
	public List<OfficeDTO> selectList(String name){
		List<OfficeDTO> list = officeDAO.selectList(name);
		if(list != null) {
			System.out.println("=======" + name + "님의 정보입니다.=====");
		}else {
			System.out.println("해당 사용자는 존재하지 않습니다.");
		}
		return list;
	}

}
