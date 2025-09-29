package com.shinhan.SimpleBoard;

// Factory Pattern
public class ControllerFactory {

	public static CommonControllerInterface make(String business) {
		CommonControllerInterface commonControllerInterface = null;
		switch (business) {
		case ("List") -> commonControllerInterface = new ListController();
    case ("Write") -> commonControllerInterface = new WriteController();
    case ("Update") -> commonControllerInterface = new UpdateController();
		case ("Delete") -> commonControllerInterface = new DeleteController();
		}
		return commonControllerInterface;
	}

}


