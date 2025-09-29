package com.shinhan.controller.common;

import java.util.Map;

import dept.DeptDTO;
import dept.DeptService;

public class DeptDetailController implements CommonControllerInterface{

	@Override
	public void excute(Map<String, Object> datas) {
		String method = (String)datas.get("method");
		
		if("GET".equals(method)) {
			int deptid = (Integer)(datas.get("deptid"));
			DeptService deptService = new DeptService();
			DeptDTO dept = deptService.selectById(deptid);
			datas.put("dept", dept);
		}else {
			DeptDTO dept = (DeptDTO) datas.get("dept");
			
			DeptService deptService = new DeptService();
			deptService.updateDept(dept);
		}
		
	}

}
