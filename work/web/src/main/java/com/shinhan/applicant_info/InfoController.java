package com.shinhan.applicant_info;

import java.util.Scanner;
import java.util.function.Predicate;

import com.shinhan.common.CommonControllerInterface;

public class InfoController implements CommonControllerInterface{
	Scanner sc = new Scanner(System.in);
	InfoService infoService = new InfoService();

	@Override
	public void execute() {
		boolean isStop = false;
		while(!isStop) {
			InfoView.menuDisplay();
			int job = sc.nextInt();
			switch(job) {
			case 1->{f_insert();}				// 정보입력
			case 2->{f_update();}				// 정보수정
			case 3->{f_delete();}				// 정보삭제
			case 4->{f_myinfo();}				// 내 정보 조회
			case 5->{f_housing_area_info();}	// 신청한 타입 정보 조회(해당타입의 신청자 수, 분양금)
			case 6->{f_lotte_check();}			// 당첨 조회
			case 7->{isStop = true;;}			// 종료
			}
		}
		InfoView.display("==========이용해주셔서 감사합니다.==========");
		
	}
	


	// 1
	private void f_insert() {	
		InfoDTO info = makeInfo();
		
		
		int result = infoService.insertInfo(info);
		if(result > 0) {
			InfoView.display("접수가 완료되었습니다!!!.");
		}else {
			InfoView.display("회원정보 저장 실패");
		}
		
	}
	
	
	// 공통 입력 검증 메서드
    public String getValidatedInput(String prompt, 
    		Predicate<String> validator, String errorMessage) {
    	Scanner in = new Scanner(System.in);
    	while (true) {
            System.out.print(prompt);
            String input = in.nextLine().trim();

            if (validator.test(input)) {
                return input;
            } else {
                System.out.println("입력오류: " + errorMessage);
            }
        }
    }

	
	private InfoDTO makeInfo() {
		System.out.println("이름은 한글만 입력하세요>>");
		String name =  getValidatedInput("이름 : ", 
				input->input.matches("^[가-힣]{3,4}$"),
				"이름은 한글로 3글자 이상 4글자 이하로 입력하세요"
				);
		
		
		System.out.println();
		System.out.println("ex)1111111-1111111");
		String reg_no = getValidatedInput("주민등록번호 : ",input->input.matches("^\\d{6}-\\d{7}$"),
				"형식이 올바르지 않습니다. 예:1111111-1111111");
		
		System.out.println();
		System.out.println("ex)010-1234-5678");
		String phone = getValidatedInput("전화번호 : ",input->input.matches("^010-\\d{4}-\\d{4}$"),
			    "형식이 올바르지 않습니다. 예: 010-1234-5678");
		
		System.out.println();
		System.out.println("ex)Y/N");
		String is_marrie = getValidatedInput("결혼 유무 : " ,input->input.matches("^[YyNn]$"),
			    "형식이 올바르지 않습니다. Y 또는 N만 입력하세요."
				);
		
		System.out.println();
		System.out.println("ex)숫자만 입력하세요, 없으면 0 입력하세요");
		String dependent_count = getValidatedInput("부양가족 수 : " ,input->input.matches("^[0-7]$"),
				"숫자만 입력하세요, 부양가족수가 7명 이상이면 7을 입력하세요"
				);
		// int로 저장
		int dependentCount = Integer.parseInt(dependent_count);

		
		System.out.println();
		System.out.println("ex)서울/대구/경북");		
		String address = getValidatedInput("주소 : " ,input->input.matches("^(서울|부산|대구|인천|광주|대전|울산|경기|경북|경남|충남|충북|전남|전북|강원|제주)$"),
				"서울,부산,대구,인천,광주,대전,울산,경기,경북,경남,충남,충북,전남,전북,강원,제주 중 하나만 입력하세요");
		
		
		
		System.out.println();
		System.out.println("연도만 입력하세요>>>");
		System.out.println("ex) 2020");
		String account_open_date = getValidatedInput("통장 개설 연도 : ",input->{
			if (!input.matches("^\\d{4}$")) 
				return false;
			int year = Integer.parseInt(input);
	        return year >= 2008 && year <= 2025;
		},
				"2008~2025년도 사이의 연도만 입력 가능합니다. 2007년 이전에 개설하셨다면 2008을 입력하세요");
		int accountopendate = Integer.parseInt(account_open_date);
		
		
		System.out.println();
		System.out.println("ex)숫자만 입력하세요");
		String non_home_start_date = getValidatedInput("무주택 기간 (년) 입력 (예: 0~16) : ", input -> {
			        if (!input.matches("^\\d{1,2}$")) return false; 
			        int year = Integer.parseInt(input);
			        return year >= 0 && year <= 16;
			    },
			    "무주택 기간은 0년 이상 16년 이하의 숫자만 입력 가능합니다. 17년 이상이라면 16일 입력하세요"
			);

			int nonhomestartdate = Integer.parseInt(non_home_start_date);
		
		
		
		
		System.out.println();
		System.out.println("ex)숫자만 입력하세요 24/34/48");
		String housing_area = getValidatedInput("신청하려는 평수 : ", input->input.matches("^(24|34|48)$"),
				"24/34/48중 하나만 입력하세요");
		int housingarea = Integer.parseInt(housing_area);
		
		InfoDTO info = InfoDTO.builder()
				.name(name)
				.reg_no(reg_no)
				.phone(phone)
				.address(address)
				.dependentCount(dependentCount)
				.nonhomestartdate(nonhomestartdate)
				.accountopendate(accountopendate)
				.is_married(is_marrie)
				.housingarea(housingarea)
				.build();
		return info;
	}
	
	
	
	//2
		private void f_update() {
			System.out.println("이름은 한글만 입력하세요>>");
			String name =  getValidatedInput("이름 : ", 
					input->input.matches("^[가-힣]{3,4}$"),
					"이름은 한글로 3글자 이상 4글자 이하로 입력하세요"
					);
			System.out.println("ex)1111111-1111111");
			String reg_no = getValidatedInput("주민등록번호 : ",input->input.matches("^\\d{6}-\\d{7}$"),
					"형식이 올바르지 않습니다. 예:1111111-1111111");
			
			// 이름, 주민번호 검증
			InfoDTO chackInfo = infoService.selectMyInfo(name, reg_no);
			
			if(chackInfo != null) {
				System.out.println("본인 확인 완료. 수정할 정보를 입력하세요>>>");
				InfoDTO info = makeInfo();
				info.setBno(chackInfo.getBno());
				
				int result = infoService.updateInfo(info);
				if(result > 0) {
					InfoView.display("회원정보가 성공적으로 수정되었습니다.");
				}else {
					InfoView.display("회원 정보 수정에 실패했습니다.");
				}
				
			}else {
				InfoView.display("일치하는 정보가 없습니다.");
			}
		}
	
		// 3
		private void f_delete() {
			System.out.println("이름은 한글만 입력하세요>>");
			String name =  getValidatedInput("접수 취소할 사용자 이름 : ", 
					input->input.matches("^[가-힣]{3,4}$"),
					"이름은 한글로 3글자 이상 4글자 이하로 입력하세요"
					);
			System.out.println("ex)1111111-1111111");
			String reg_no = getValidatedInput("접수 취소할 사용자 주민번호 : ",input->input.matches("^\\d{6}-\\d{7}$"),
					"형식이 올바르지 않습니다. 예:1111111-1111111");
			
			System.out.print("접수 취소할 사용자 접수번호 : ");
			int bno = sc.nextInt();
			
			InfoView.display(infoService.deleteInfo(name, reg_no, bno)+"건 삭제");
		}

		
	
	// 4
	private void f_myinfo() {
		String name =  getValidatedInput("조회할 사용자 이름 : ", 
				input->input.matches("^[가-힣]{3,4}$"),
				"이름은 한글로 3글자 이상 4글자 이하로 입력하세요"
				);
		String reg_no = getValidatedInput("조회할 사용자 주민등록번호 : ",input->input.matches("^\\d{6}-\\d{7}$"),
				"형식이 올바르지 않습니다. 예:1111111-1111111");
		InfoView.display(infoService.selectMyInfo(name, reg_no));
	}
	

	// 5
	private void f_housing_area_info() {
		String name =  getValidatedInput("조회할 사용자 이름 : ", 
				input->input.matches("^[가-힣]{3,4}$"),
				"이름은 한글로 3글자 이상 4글자 이하로 입력하세요"
				);
		String reg_no = getValidatedInput("조회할 사용자 주민등록번호 : ",input->input.matches("^\\d{6}-\\d{7}$"),
				"형식이 올바르지 않습니다. 예:1111111-1111111");
		InfoView.display(infoService.housingAreaInfo(name, reg_no));
		
	}
	
	// 6
	private void f_lotte_check() {
		String name =  getValidatedInput("사용자 이름 : ", 
				input->input.matches("^[가-힣]{3,4}$"),
				"이름은 한글로 3글자 이상 4글자 이하로 입력하세요"
				);
		String reg_no = getValidatedInput("사용자 주민번호 : ",input->input.matches("^\\d{6}-\\d{7}$"),
				"형식이 올바르지 않습니다. 예:1111111-1111111");
		System.out.print("사용자 접수번호 : ");
		int bno = sc.nextInt();
		
		
		InfoDTO info = infoService.lotte_check(bno,name,reg_no);
		if(info != null) {
			System.out.print(info.getArea_rank());
		}
		
	}
	
}
