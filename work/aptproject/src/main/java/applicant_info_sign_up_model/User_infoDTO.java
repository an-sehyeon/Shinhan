package applicant_info_sign_up_model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User_infoDTO {
	 private String role;
	 private String name;               
	 private String id;                 
	 private String password;           
	 private String reg_no;             
	 private String phone;              
	 private String address;            
	 private int dependent_count;    
	 private int non_home_start_date;
	 private String account_open_date;  
	 private String is_married;         
	 private int housing_area;  
	 
}
