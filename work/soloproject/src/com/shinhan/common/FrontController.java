package com.shinhan.common;

import java.util.Scanner;

import com.shinhan.project_util.MyUtil;

public class FrontController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyUtil util = new MyUtil();
		
		CommonControllerInterface controller = null;
		boolean isStop = false;
		
		while(!isStop) {
			System.out.println(util.BLUE + "원하시는 서비스 번호를 입력하세요" + util.END );
			System.out.println("1.접수처 2.접수자 3.종료");
			int job = sc.nextInt();
			
			switch(job) {
			case 1->{controller = ControllerFactory.make("office");}
			case 2->{controller = ControllerFactory.make("info");}
			case 3->{isStop = true; continue;}
			default->{continue;}
			}
			controller.execute();
		}
		sc.close();
		System.out.println("-----Thank You-----");

	}

}



