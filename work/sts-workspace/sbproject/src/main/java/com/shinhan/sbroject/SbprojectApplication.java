package com.shinhan.sbroject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shinhan.sbroject,net.firstzone.myapp"})
@EnableJpaAuditing	// BaseEntity가 AuditingEntityListener임
public class SbprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbprojectApplication.class, args);
	}

}
