package com.shinhan.utils;

import java.sql.Date;
import java.util.regex.Pattern;

public class InsertUtil {
	
	// 숫자 확인하는 Util
	public static int check_Integer_Input(String message) {
		int num = 0;
		boolean flag = true;
		while (flag) {
			try {
				System.out.print(message);
				String input = ScannerUtil.sc.nextLine().trim();
				if (input.isEmpty()) {
				    System.out.println("값을 입력해주세요.");
				    continue;
				}
				num = Integer.parseInt(input);
				flag = false;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
				continue;
			}
		}
		return num;
	}
	
	// 문자 확인하는 Util
	public static String check_String_Input(String message) {
	    String input = "";
	    while (true) {
	        System.out.print(message);
	        input = ScannerUtil.sc.nextLine().trim();
	        if (input.isEmpty()) {
	            System.out.println("값을 입력해주세요.");
	            continue;
	        }
	        return input;
	    }
	}
	
	// 전화번호 확인하는 Util
	public static String check_PhoneNumber_Input(String message) {
		String input = "";
		String pattern = "^01[016789]-\\d{3,4}-\\d{4}$";
		while (true) {
			System.out.print(message);
			input = ScannerUtil.sc.nextLine().trim();
			if (input.isEmpty()) {
				System.out.println("값을 입력해주세요.");
				continue;
			}else if(!Pattern.matches(pattern, input)) {
				System.out.println("전화번호 형식이 잘못되었습니다. 010-####-#### 형식으로 입력해주세요.");
				continue;
			}
			return input;
		}
	}

	// 날짜 형식 확인하는 Util
	 public static Date check_Date_Input(String message) {
	        Date sqlDate = null;
	        boolean flag = true;
	        while (flag) {
	            try {
	            	System.out.print(message);
	                String input = ScannerUtil.sc.nextLine().trim();
	                if (input.equals("0")) return null;
	                if (!input.matches("\\d{4}-\\d{2}-\\d{2}")) {
	                    throw new IllegalArgumentException();
	                }

	                Date utilDate = DateUtil.convertToSqlDate(DateUtil.convertToDate(input));
	                if (utilDate == null) throw new IllegalArgumentException();

	                sqlDate = DateUtil.convertToSqlDate(utilDate);
	                flag = false;
	            } catch (IllegalArgumentException e) {
	                System.out.println("날짜 형식이 잘못되었습니다. yyyy-MM-dd 형식으로 입력해주세요.");
	            }
	        }
	        return sqlDate;
	    }
	
}