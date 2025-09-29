package com.shinhan.controller.common;

import java.util.Map;

import dept.DeptService;
import job.JobDAO;

//POJO(Plan Old Java Object)
public class EmpListController implements CommonControllerInterface{

	@Override
	public void excute(Map<String, Object> datas) {
		DeptService deptService = new DeptService();
		datas.put("deptlist", deptService.selectAll());
		
		JobDAO jobDAO = new JobDAO();
		datas.put("joblist", jobDAO.getAllJobs());
	}

}
