package com.shinhan.sbroject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.sbroject.dto.GuestBookDTO;
import com.shinhan.sbroject.service.GuestBookService;

@RestController
public class GuestBookController {
	
	@Autowired
	GuestBookService gService;
	
	@GetMapping("/guest")
	public List<GuestBookDTO> selectAll(){
		return gService.selectAll();
	}

}
