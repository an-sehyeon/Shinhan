package com.shinhan.controller2.emp;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dept.DeptDTO;
import dept.DeptService;
import emp.DateUtil;
import emp.EmpDTO;
import emp.EmpService;
import job.JobDAO;
import job.JobDTO;

/**
 * Servlet implementation class EmpDetailList
 */
//@WebServlet("/emp/empdetail.do")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 // 로그인을 하지 않은 사용자에게 제공하지 않는 서비스임
		  HttpSession session = request.getSession(); 
		  Object obj = session.getAttribute("loginEmp"); 
		  if(obj == null) {
			  session.setAttribute("info","로그인을 하지않은 사용자에게 제공하지않는 서비스입니다."); 
			  String path = getServletContext().getContextPath(); 
			  response.sendRedirect(path + "/auth/login");
			  return; 
		  }
		
		int emp_id = Integer.parseInt(request.getParameter("empid"));

		EmpService eService = new EmpService();
		EmpDTO emp = eService.selectById(emp_id);

		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAll();

		JobDAO jobDAO = new JobDAO();
		List<JobDTO> joblist = jobDAO.getAllJobs();

		/*
		 * data를 바인딩
		 * 1. request : 요청을하고 응답 후 사라진다.
		 * 2. session : 브라우저에서 여러 요청을 하는동안 유지하기 위함, 브라우저 닫으면 사라짐.
		 * 3. application : 서버가 종료되면 사라짐
		 * 
		 * */
		request.setAttribute("emp", emp);
		request.setAttribute("deptlist", deptlist);
		request.setAttribute("joblist", joblist);

		request.getRequestDispatcher("empdetail.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		//request.setCharacterEncoding("utf-8");
		
		EmpService empService = new EmpService();
		EmpDTO emp = makeEmp(request);
		empService.empUpdate(emp);
		
		// 주소창바꾸기 : front에서는 location.href=''
		
		// 본래 요청은 /emp/empdetail.do
		// 요청 재지정하기...> 브라우저의 주소창이 변경
		response.sendRedirect("emplist.do");
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
