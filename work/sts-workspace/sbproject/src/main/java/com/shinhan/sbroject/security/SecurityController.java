package com.shinhan.sbroject.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {
	
	@GetMapping("/all")
	public void f1() {
		
	}
	
	
	@GetMapping("/admin")
	public void f2() {
		
	}
	
	
	@GetMapping("/manager")
	public void f3() {
		
	}
	
	
	@GetMapping("/user")
	public void f4() {
		
	}

}
