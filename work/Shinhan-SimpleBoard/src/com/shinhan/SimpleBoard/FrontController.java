package com.shinhan.SimpleBoard;

import com.shinhan.utils.InsertUtil;
import com.shinhan.utils.ScannerUtil;

public class FrontController {
	public static void main(String[] args) {
		boolean is_end = false;
		CommonControllerInterface commonControllerInterface = null;
		int select;
		
		while(!is_end) {
			CommonView.menuDisplay();
			select = InsertUtil.check_Integer_Input("번호 입력 > ");
			switch(select) {
			case 1 -> commonControllerInterface = ControllerFactory.make("List");
			case 2 -> commonControllerInterface = ControllerFactory.make("Write");
			case 3 -> commonControllerInterface = ControllerFactory.make("Update");
			case 4 -> commonControllerInterface = ControllerFactory.make("Delete");
			case 5 -> {
				is_end = true;
				continue;
			}
			default -> CommonView.display_ready();
			}
			if(commonControllerInterface != null) {
				commonControllerInterface.execute();
			}
		}
		CommonView.goodBye();
		ScannerUtil.sc.close();
	}
}
