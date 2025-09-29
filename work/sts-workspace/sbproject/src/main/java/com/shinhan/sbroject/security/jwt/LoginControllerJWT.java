package com.shinhan.sbroject.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.sbroject.entity.MemberEntity;
import com.shinhan.sbroject.security.MemberService;

@RestController
public class LoginControllerJWT {
	@Autowired
	AuthServiceLogin authService;
	
	@Autowired
	MemberService memberService;

	@PostMapping(value = "/api/login")
	public ResponseEntity<TokenDTO> getMemberProfile(@RequestBody MemberEntity request) {
		System.out.println(request);

		String token = authService.login(request);
		TokenDTO dto = TokenDTO.builder().login(request.getMid()).token(token).build();
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PostMapping("/api/signup")
	public ResponseEntity<MemberEntity> f7(@RequestBody MemberEntity member) {
		System.out.println("signup:" + member);
		MemberEntity newMember = memberService.joinUser(member);
		return new ResponseEntity<>(newMember, HttpStatus.OK);
	}
}

