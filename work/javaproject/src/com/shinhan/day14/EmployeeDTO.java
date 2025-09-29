package com.shinhan.day14;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

// DTO (Data Transfer Object)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {

	private int	 	employee_id;   
	private String 	first_name;   
	private String 	last_name;     
	private String 	email;         
	private String 	phone_number;  
	private Date	hire_date;     
	private String 	job_id;        
	private double 	salary;        
	private double 	commission_pct;
	private int 	manager_id;    
	private int 	department_id;
	
	
}
