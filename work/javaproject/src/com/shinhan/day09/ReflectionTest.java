package com.shinhan.day09;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Class a = StudentDTO.class;
		Class b = Class.forName("com.shinhan.day09.StudentDTO");
		StudentDTO s = new StudentDTO("123", "김");
		Class c = s.getClass();
		
		System.out.println(a.getName());
		System.out.println(b.getName());
		System.out.println(c.getName());
		
		Field[] arr = a.getDeclaredFields();
		for(Field field:arr) {
			System.out.println(field.getName());
		}
		
		Method[] arr2 = a.getDeclaredMethods();
		for(Method method : arr2) {
			System.out.println(method.getName()+ " 파라메터갯수 : " + method.getParameterCount());
		}
		
	}
	
}
