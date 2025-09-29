package application_office_model;

import java.util.List;

public class OfficeService {
	OfficeDAO officeDAO = new OfficeDAO();
	
	public List<OfficeDTO> selectBno(int bno){
		List<OfficeDTO> list = officeDAO.selectBno(bno);
		if(list!=null) {
			System.out.println("====" + bno + "번 사용자의 정보입니다.");
		}else {
			System.out.println("OfficeService에서 오류 출력");
		}
		return list;
	}
	
	public List<OfficeDTO> selectAll(){
		List<OfficeDTO> officelist = officeDAO.selectAll();
		System.out.println("OfficeService에서 로그출력: " + officelist.size() + "건");
		
		return officelist;
	}
	
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

	public List<OfficeDTO> selectDetail(String keyword, String value){
		List<OfficeDTO> list = officeDAO.selectDetail(keyword, value);
		
		return list;
	}
	
	public OfficeDTO luckyDetail(int bno) {
		OfficeDTO list = officeDAO.luckyDetail(bno);
		return list;
	}

}
