package com.shinhan.controller.common;

import java.util.List;
import java.util.Map;

import dept.DeptDTO;
import dept.DeptService;

public class DeptListController implements CommonControllerInterface{

	@Override
	public void excute(Map<String, Object> datas) {
		DeptService deptService = new DeptService();
		List<DeptDTO>deptlist = deptService.selectAll();
		
		// 요청객체에 조회된 내용을 저장한다.
		datas.put("deptListData", deptlist);
		
	}

}
