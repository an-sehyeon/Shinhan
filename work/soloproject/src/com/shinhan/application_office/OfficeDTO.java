package com.shinhan.application_office;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OfficeDTO {
	
	private int bno;
	private int housing_area;
	private int total_score;
	private int area_rank;
	private int sort_seed;
	
	private String is_married;
	private int address_point;
	
	private int dependent_point;
	private int non_home_point;
	private int account_point;
	private String name;
	private String reg_no;
	private String phone;

}
