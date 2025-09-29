package com.shinhan.sbroject.security.jwt;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shinhan.sbroject.entity.MemberEntity;
import com.shinhan.sbroject.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceLogin {

	private final JwtUtil jwtUtil;
	private final MemberRepository memberRepository;
	private final PasswordEncoder encoder;
	
	//로그인시 토큰발급하기 
	public String login(MemberEntity dto) {
		String mid = dto.getMid();  //회원1
		String password = dto.getMpassword();  //1234
		MemberEntity member = memberRepository.findById(mid).orElse(null);
		if (member == null) {
			throw new UsernameNotFoundException("Mid이 존재하지 않습니다.");
		}

		// 암호화된 password를 디코딩한 값과 입력한 패스워드 값이 다르면 null 반환
		if (!encoder.matches(password, member.getMpassword())) {
			throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
		}
        //ID, pass .... OK....토큰발급하기 
		String accessToken = jwtUtil.createAccessToken(member);
		return accessToken;
	}
}


