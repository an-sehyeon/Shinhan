package com.shinhan.controller.common;

import java.util.List;
import java.util.Map;

import dept.DeptDTO;
import dept.DeptService;
import emp.EmpDTO;
import emp.EmpService;
import job.JobDAO;
import job.JobDTO;

public class EmpDetailController implements CommonControllerInterface{

	@Override
	public void excute(Map<String, Object> datas) {
		String method = (String)datas.get("method");
		EmpService empService = new EmpService();
		if("GET".equals(method)) {
			int emp_id = (Integer)datas.get("empid");
			EmpDTO emp = empService.selectById(emp_id);

			DeptService dService = new DeptService();
			List<DeptDTO> deptlist = dService.selectAll();

			JobDAO jobDAO = new JobDAO();
			List<JobDTO> joblist = jobDAO.getAllJobs();
			
			datas.put("emp", emp);
			datas.put("deptlist", deptlist);
			datas.put("joblist", joblist);
		}else {
			EmpDTO emp = (EmpDTO)datas.get("emp");
			empService.empUpdate(emp);
		}
		
	}

}
