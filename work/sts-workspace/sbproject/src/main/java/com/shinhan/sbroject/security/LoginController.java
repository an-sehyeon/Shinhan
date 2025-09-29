package com.shinhan.sbroject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.sbroject.entity.MemberEntity;


@Controller
@RequestMapping("/auth")
public class LoginController {

	@GetMapping("/login")
	public void login() {
		
	}
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		
	}
	@GetMapping("/logout")
	public void logout() {
		
	}
	@GetMapping("/accessDenined")
	public void accessDenined() {
		
	}
	//사용자등록페이지 보여주기 
	@GetMapping("/signup")
	public String joinForm() {
		return "auth/joinForm";
	}
	
	
	@Autowired
	MemberService memberService;
	
	@ResponseBody
	@PostMapping("/joinProc")
	public String joinProc(MemberEntity member) {
		MemberEntity newMember = memberService.joinUser(member);
		return newMember !=null && member.getMid() == newMember.getMid()? "register OK":"가입실패";
	}
	
	//---------------------------------------------------------//
	//로그인 post
	//회원가입 signup
	
	/*
	 * @Autowired AuthServiceLogin authService;
	 * 
	 * @PostMapping(value = "/login" )
	 * 
	 * @ResponseBody public ResponseEntity<TokenDTO> getMemberProfile(@RequestBody
	 * MemberEntity request) { System.out.println(request);
	 * 
	 * String token = authService.login(request); TokenDTO dto =
	 * TokenDTO.builder().login(request.getMid()).token(token).build(); return new
	 * ResponseEntity<>(dto, HttpStatus.OK); }
	 * 
	 * @PostMapping("/signup")
	 * 
	 * @ResponseBody public ResponseEntity<MemberEntity> f7(@RequestBody
	 * MemberEntity member) { System.out.println("signup:" + member); MemberEntity
	 * newMember = memberService.joinUser(member); return new
	 * ResponseEntity<>(newMember, HttpStatus.OK); }
	 */

	
	
}
