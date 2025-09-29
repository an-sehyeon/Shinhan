package com.shinhan.common;

import com.shinhan.applicant_info.InfoController;
import com.shinhan.application_office.OfficeController;

public class ControllerFactory {

	public static CommonControllerInterface make(String business) {
		CommonControllerInterface controller = null;
		switch(business) {
		case "office" ->{controller = new OfficeController();}
		case "info" ->{controller = new InfoController();}
		}
		
		return controller;
	}

}
