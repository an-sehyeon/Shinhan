package com.shinhan.day09;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import comshinhan.util.DateUtil;

public class DateTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
		
	}

	private static void f6() {
		Date d1 = new Date();
		System.out.println(d1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		String str = sdf.format(d1);		// 날짜 -> 문자
		System.out.println(str);
		
		str = DateUtil.converToString(d1);
		System.out.println(str);
		
		String str2 = "2025-04-11 03:44:01";
		Date d2 = DateUtil.converToDate(str2);
		System.out.println(d2);
		
		// util.Date -> sql.Date로 바꾸기
		java.sql.Date d3 = DateUtil.converToSQLDate2(d1);
		System.out.println(d3);
	}

	private static void f5() {
		double su = -10000000000000.123;
		DecimalFormat df = new DecimalFormat("+000,000,000.000000;-000,000,000.000000");
		DecimalFormat df2 = new DecimalFormat("###,###,###.######");
		String str = df.format(su);
		String str2 = df2.format(su);
		System.out.println(str);
		System.out.println(str2);
		
	}

	private static void f4() {
		java.sql.Date d = new java.sql.Date(new Date().getTime());
		System.out.println(d);
		
		java.sql.Date d2 = call(new Date().getTime());
		System.out.println(d2);
		
	}

	private static java.sql.Date call(long time) {
		
		
		return new java.sql.Date(time);
	}

	private static void f3() {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		System.out.println(dt.getYear());
		System.out.println(dt.getMonth());
		System.out.println(dt.getMonthValue());
		System.out.println(dt.getDayOfMonth());
		
	}

	private static void f2() {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
				
				
				
	}

	private static void f1() {
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getTime());
		
		Date d2 = new Date(1744352419795L);
		System.out.println(d2);
		
	}

}
