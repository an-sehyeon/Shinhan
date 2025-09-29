package com.shinhan.application_office;

import java.util.Scanner;

import com.shinhan.common.CommonControllerInterface;

public class OfficeController implements CommonControllerInterface{
	Scanner sc = new Scanner(System.in);
	OfficeService officeService = new OfficeService();

	@Override
	public void execute() {
		boolean isStop = false;
		while(!isStop) {
			OfficeView.menuDisplay();
			int job = sc.nextInt();
			switch(job) {
			case 1->{f_allrank();}			// 각 평수의 전체 순위 조회
			case 2->{f_luckylist();}		// 각 평수 당첨자들 조회
			case 3->{f_selectlist();}		// 특정 사용자 조회
			case 4->{isStop = true;}		// 종료
			}
		}
		OfficeView.display("=====시스템을 종료합니다.=====");
		
	}

	


	// 1
	private void f_allrank() {
		System.out.println("ex)24/34/48 세 개 중 하나만 입력하세요");
		System.out.print("조회하고 싶은 평수를 입력하세요>>");
		int area = sc.nextInt();
		OfficeView.display(officeService.selectAllList(area));
	}
	
	// 2
	private void f_luckylist() {
		System.out.println("ex)24/34/48 세 개 중 하나만 입력하세요");
		System.out.print("2번 조회하고 싶은 평수를 입력하세요>>");
		int area = sc.nextInt();
		OfficeView.display(officeService.luckyList(area));
			
	}
	
	// 3
	private void f_selectlist() {
		System.out.println("조회하고 싶은 사용자의 이름을 입력하세요>>>");
		String name = sc.next();
		OfficeView.display(officeService.selectList(name));
		
	}

}
