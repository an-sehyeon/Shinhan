package com.shinhan.controller2.emp;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@WebServlet("/emp/empinsert.do")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmpService eService = new EmpService();
		List<EmpDTO> emplist = eService.selectAll();
		
		// manager_id 중복제거
		Set<Integer> managerIdSet = new LinkedHashSet<Integer>();		// 순서 유지하고 중복 제거
		for(EmpDTO emp : emplist) {
			Integer managerId = emp.getManager_id();
			if(managerId != null) {
				managerIdSet.add(managerId);
			}
		}
		
		// 중복 제거된 manager_id를 리스트로 변환
		List<Integer> uniqueManagerId = new ArrayList<>(managerIdSet);
		

		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAll();

		JobDAO jobDAO = new JobDAO();
		List<JobDTO> joblist = jobDAO.getAllJobs();

		request.setAttribute("managerId", uniqueManagerId);
		request.setAttribute("deptlist", deptlist);
		request.setAttribute("joblist", joblist);

		request.getRequestDispatcher("empinsert.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		//request.setCharacterEncoding("utf-8");
		
		EmpService empService = new EmpService();
		EmpDTO emp = makeEmp(request);
		empService.empInsert(emp);
		
		// 주소창바꾸기 : front에서는 location.href=''
		
		// 요청 재지정하기
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
