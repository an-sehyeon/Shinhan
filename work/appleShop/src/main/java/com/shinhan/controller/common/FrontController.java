package com.shinhan.controller.common;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDTO;
import emp.DateUtil;
import emp.EmpDTO;

/**
 * 모든요청을 받아서 처리하고자하는 서블릿임 : Spring은 dispatcherServlet의 역할
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		String uri = req.getRequestURI();
		String cpath = getServletContext().getContextPath();
		int pos = uri.indexOf(cpath);
			
		uri = uri.substring(pos + cpath.length());
		
		System.out.println("method : " + method);
		System.out.println("uri : " + uri);
		
		Map<String, Object> datas = new HashMap<>();
		datas.put("method", method);		// get인지 post인지 구분하기 위함
		CommonControllerInterface controller = null;
		String newPage = "";
		
		switch(uri) {
		case "/emp/emplist.do"->{
			controller = new EmpListController();
			newPage = "/emp/empAll.jsp";
		}
		case "/emp/selectByCondition.do"->{
			System.out.println("직원조건조회");
			controller = new EmpListConditionController();
			datas.put("reader", req.getReader());
			newPage = "/emp/empByCondition.jsp";
		}
		case "/emp/empdetail.do"->{
			controller = new EmpDetailController();
			if(method.equals("GET")) {
				datas.put("empid", convertToInt(req.getParameter("empid")));
				newPage = "/emp/empdetail.jsp";
			}else {
				datas.put("emp", makeEmp(req));
				newPage = "redirect:emplist.do";
			}
		}
		case "/dept/deptlist.do"->{
			controller = new DeptListController();
			newPage = "/dept/deptlist.jsp";
		}
		case "/dept/deptdetail.do"->{
			controller = new DeptDetailController();
			if(method.equals("GET")) {
				datas.put("deptid", convertToInt(req.getParameter("deptid")));
				newPage = "/dept/deptdetail.jsp";
			}else {
				datas.put("dept", makeDept(req));
				newPage = "redirect:deptlist.do";
			}
		}
		default ->{}
		}
		controller.excute(datas);
		for(String key:datas.keySet()) {
			if(key.equals("reader"))continue;
			req.setAttribute(key, datas.get(key));
		}
		if(newPage.startsWith("redirect:")) {
			resp.sendRedirect(newPage.substring(9));
		}else {
			req.getRequestDispatcher(newPage).forward(req, resp);
		}
	}
       
	
	private Object makeDept(HttpServletRequest req) {
		int deptid = convertToInt(req.getParameter("department_id"));
		String deptname = req.getParameter("department_name");
		int managerid = convertToInt(req.getParameter("manager_id"));
		int locationid = convertToInt(req.getParameter("location_id"));

		DeptDTO dept = DeptDTO.builder()
				.department_id(deptid)
				.department_name(deptname)
				.manager_id(managerid)
				.location_id(locationid)
				.build();
		return dept;
	}


	private EmpDTO makeEmp(HttpServletRequest request) {
		int empid = convertToInt(request.getParameter("employee_id"));
		int department_id = convertToInt(request.getParameter("department_id"));
		int manager_id = convertToInt(request.getParameter("manager_id"));
		
		double salary = convertToDouble(request.getParameter("salary"));
		double commission_pct = convertToDouble(request.getParameter("commission_pct"));
		
		Date hire_date = DateUtil.converToSQLDate(request.getParameter("hire_date"));
		
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String job_id = request.getParameter("job_id");
		
		EmpDTO emp = new EmpDTO();
		emp.setCommission_pct(commission_pct);
		emp.setDepartment_id(department_id);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(first_name);
		emp.setHire_date(hire_date);
		emp.setJob_id(job_id);
		emp.setLast_name(last_name);
		emp.setManager_id(manager_id);
		emp.setPhone_number(phone_number);
		emp.setSalary(salary);
		return emp;
	}

	private double convertToDouble(String parameter) {
		if(parameter == "" || parameter == null)return 0;
		return Double.parseDouble(parameter);
	}

	private int convertToInt(String parameter) {
		if(parameter == "" || parameter == null)return 0;
		return Integer.parseInt(parameter);
	}

}
