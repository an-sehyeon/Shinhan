package com.shinhan.day09;

import java.util.Properties;
import java.util.Set;

public class SystemInfoTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		
		// Map : 파이썬의 dict entry(key, valaue)
		Properties properties = System.getProperties();
		Set<Object> keys = properties.keySet();
		for(Object key:keys) {
			System.out.println(key + " --> " + System.getProperty((String)key));
		}
		
		
		
	}
}
