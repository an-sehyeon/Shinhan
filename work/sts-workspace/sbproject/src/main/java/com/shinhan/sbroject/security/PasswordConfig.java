package com.shinhan.sbroject.security;

import com.shinhan.sbroject.aop.LoggingAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    private final LoggingAdvice loggingAdvice;

    PasswordConfig(LoggingAdvice loggingAdvice) {
        this.loggingAdvice = loggingAdvice;
    }
	
	@Bean
	public PasswordEncoder makePassword() {
		System.out.println("============PasswordEncoder Configuration==========");
		return new BCryptPasswordEncoder();
	}

}
