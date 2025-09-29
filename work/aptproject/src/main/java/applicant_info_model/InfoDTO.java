package applicant_info_model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InfoDTO {
	private int bno;
	private String name;
	private String reg_no;
	private String phone;
	private String address;
	private String dependent_count;
	private String non_home_start_date;
	private String account_open_date;
	private String is_married;
	private String housing_area;
	
	private int account_point;
	private int address_num;
	private int address_point;
	private int dependent_point;
	private int non_home_point;
	private int total_score;
	private int area_rank;
	
	// String으로 저장된 값 int형으로 변환
	private int dependentCount;
	private int nonhomestartdate;
	private int accountopendate;
	private int housingarea;
	
	private String down_payment;
	private String interim_payment;
	private String balace_payment;
	private String total_price;
	
	

}
