package com.shinhan.controller2.emp;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import emp.EmpService;

/**
 * Servlet implementation class EmpListServlet
 */
//@WebServlet("/emp/selectByCondition.do")
public class EmpListServletCondition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * String jobid = request.getParameter("jobid"); int deptid =
		 * Integer.parseInt(request.getParameter("deptid")); int salary =
		 * Integer.parseInt(request.getParameter("salary")); String hire_date =
		 * request.getParameter("hire_date");
		 * 
		 * 
		 * EmpService empService = new EmpService();
		 * 
		 * Integer[] deptArr = new Integer[] {deptid};
		 * 
		 * request.setAttribute("emplist",
		 * empService.selectByCondition(deptArr,jobid,salary,hire_date));
		 * 
		 * RequestDispatcher rd = request.getRequestDispatcher("empByCondition.jsp");
		 * rd.forward(request, response);
		 */
		
		// 1. JSON 데이터 읽기
        BufferedReader reader = request.getReader();
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
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
        request.setAttribute("emplist",
        		empService.selectByCondition(deptArr, jobid, salary, hire_date));
        RequestDispatcher  rd = request.getRequestDispatcher("empByCondition.jsp");
        rd.forward(request, response);




	}


}
