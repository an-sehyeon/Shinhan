package com.shinhan.sbroject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.shinhan.sbroject.security.jwt.JwtAuthFilter;
import com.shinhan.sbroject.security.jwt.JwtUtil;

import lombok.RequiredArgsConstructor;

// 시큐리티 설정파일임을 의미
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	
	final String[] WHITE_LIST = {"/security/all", "/auth/**", "/api/login", "/api/signup", "listAll.do",
			"/css/**", "/images/**","/js/**"};
	final String[] MANAGER_LIST = {"/security/manager"};
	final String[] ADMIN_LIST = {"/security/admin"};
	final String[] USER_LIST = {"/security/user"};
	
	final MemberService memberService;
	final JwtUtil jwtUtil;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		System.out.println("SecurityConfig SecurityFilterChain 리턴 : " + http);
		http.authorizeHttpRequests(auth->{
			auth.requestMatchers(WHITE_LIST).permitAll();							// 로그인 없이 접속 가능
			auth.requestMatchers(MANAGER_LIST).hasRole("MANAGER");		// manager권한이 있어야 접속가능
			auth.requestMatchers(ADMIN_LIST).hasRole("ADMIN");				// admin권한이 있어야 접속가능
			auth.requestMatchers(USER_LIST).hasRole("USER");						// user권한이 있어야 접속가능
			auth.anyRequest().authenticated();											// 나머지는 로그인 후 접속가능
		});
		
		// Spring제공 로그인 페이지 보여줌
		//http.formLogin();
		
		// csrf토큰 default설정은 활성화
		// 활성화되어있다면 post, put과 같이 get이외의 요청은 반드시 스프링이 자동으로 토큰을 생성해 토큰을 비교하여 처리
		http.csrf((csrf)->csrf.disable());
		
		//★ 폼 기반 로그인 설정
		/*
		 * http.formLogin( login->login.loginPage("/auth/login")
		 * .usernameParameter("mid")//loginForm의 name이 변경됨
		 * .passwordParameter("mpassword")//loginForm의 name이 변경됨
		 * //.defaultSuccessUrl("/auth/loginSuccess")// 로그인 성공 시 리디렉션할 URL 지정 //continue
		 * 제거 .successHandler((request, response, authentication) -> {
		 * response.sendRedirect("/auth/loginSuccess"); }) //error 제거
		 * .failureHandler((request, response, exception) -> {
		 * request.getSession().setAttribute("loginError", "로그인 실패");
		 * response.sendRedirect("/auth/login"); // ?error 없이 리다이렉트 }) .permitAll() );
		 * //로그아웃설정 http.logout(out->out.logoutUrl("/auth/logout")// 로그아웃을 처리할 URL을 지정
		 * .logoutSuccessUrl("/auth/login")// 로그아웃 성공 시 리디렉션할 목적지를 지정
		 * .invalidateHttpSession(true)// 로그아웃 시 세션을 무효화 .deleteCookies("JSESSIONID")//
		 * 로그아웃 시 쿠키를 삭제 ); //접근불가(403)
		 * http.exceptionHandling(handling->handling.accessDeniedPage(
		 * "/auth/accessDenined"));
		 */
		
		// Cors설정을 활성화함.
		http.cors();
		http.addFilterBefore(new JwtAuthFilter(memberService, jwtUtil),
				UsernamePasswordAuthenticationFilter.class);
		
		return http.build();

	}
}
