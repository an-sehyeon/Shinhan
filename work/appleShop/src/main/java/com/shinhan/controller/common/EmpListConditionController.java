package com.shinhan.controller.common;

import java.io.BufferedReader;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import emp.EmpService;

public class EmpListConditionController implements CommonControllerInterface{

	@Override
	public void excute(Map<String, Object> datas) {
		// 1. JSON 데이터 읽기
		
        BufferedReader reader = (BufferedReader)datas.get("reader");
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        try {
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        }
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	
        }
        String json = jsonBuilder.toString();
        System.out.println(json);
		
        Gson gson = new Gson();
        JsonObject jsonObj = gson.fromJson(json, JsonObject.class);
        JsonArray deptArray = jsonObj.getAsJsonArray("deptid");
        String jobid = jsonObj.get("jobid").getAsString();
        int salary =  jsonObj.get("salary").getAsInt();
        String hire_date = jsonObj.get("hire_date").getAsString();
		
        Integer[] deptArr = new Integer[deptArray.size()];
        for (int i = 0; i < deptArray.size(); i++) {
        	deptArr[i] = deptArray.get(i).getAsInt();
        }
        EmpService empService = new EmpService();
        datas.remove("reader");
        datas.put("emplist",empService.selectByCondition(deptArr, jobid, salary, hire_date));

	}

}
