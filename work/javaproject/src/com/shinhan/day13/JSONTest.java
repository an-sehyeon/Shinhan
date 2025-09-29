package com.shinhan.day13;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONTest {

	public static void main(String[] args) {
		f1();

	}
	
	private static void f4() {
		
		
		
		
		
	}
	
	private static void f3() {
		
		
		
		
		
	}
	
	private static void f2() {
		
		
		
		
		
	}

	private static void f1() {
		// {   }
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", "zzilre");		// {"id":"zzilre"}
		jsonObj.put("name", "찐");
		jsonObj.put("age", "20");
		jsonObj.put("student", true);
		
		JSONObject jsonObj2 = new JSONObject();
		jsonObj.put("id", "zzilre2");		// {"id":"zzilre"}
		jsonObj.put("name", "찐2");
		jsonObj.put("age", "30");
		jsonObj.put("student", false);
		
		JSONArray arr = new JSONArray();	// [{}, {}]
		arr.put(jsonObj);
		arr.put(jsonObj2);
		
		JSONObject root = new JSONObject();	// {"course" : " 신한금융sw아카데미", "strudents":[{},{}]}
		root.put("course", "신한금융sw아카데미");
		root.put("students", arr);
		
		System.out.println(root.toString());
		
		System.out.println(root.get("students"));
		JSONArray arr2 = (JSONArray)root.get("students");
		for(int i = 0; i < arr2.length(); i++) {
			JSONObject obj = (JSONObject)arr2.get(i);
			System.out.println(obj.get("name"));
		}
		
		
		
	}

}
