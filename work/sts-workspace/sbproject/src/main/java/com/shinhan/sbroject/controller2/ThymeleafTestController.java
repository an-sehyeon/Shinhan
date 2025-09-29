package com.shinhan.sbroject.controller2;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinhan.sbroject.dto.GuestBookDTO;
import com.shinhan.sbroject.entity.MemberEntity;
import com.shinhan.sbroject.entity.MemberRole;
import com.shinhan.sbroject.repository2.FreeBoardRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/html")
public class ThymeleafTestController {
	
	@Autowired
	FreeBoardRepository freeBoardRepo;
	
	@GetMapping("/ex1")
	public String f_template1() {
		
		return "layout/exTemplate";
	}
	
	
	@GetMapping("/layout1")
	public String f_layout1() {
		return "layout/exLayout1";
	}
	
	@GetMapping("/sample6")
	public void sample6(Model model) {
		model.addAttribute("now",new Date());
		model.addAttribute("price",123456789);
		model.addAttribute("title", "This is a just sample");
		model.addAttribute("options", Arrays.asList("aa","bb","cc"));
	}
	
	@GetMapping("/freeboard")
	public void f_selectAll(Model model, HttpSession session) {
		model.addAttribute("greeting", "Hello~~~~");
		model.addAttribute("blist", freeBoardRepo.findAll());
		
		MemberEntity	user = MemberEntity.builder()
				.mid("black")
				.mname("김신한")
				.mrole(MemberRole.MANAGER)
				.build();
		session.setAttribute("loginUser",user);
	}
	
	@GetMapping("/sample1")
	public void f1(Model model) {
		GuestBookDTO guest = GuestBookDTO.builder().gno(100L).title("타이틀").writer("작성자").content("화요요요요일").build();
		model.addAttribute("greeting", "안녕~~~~");
		model.addAttribute("book", guest);
	}

}
