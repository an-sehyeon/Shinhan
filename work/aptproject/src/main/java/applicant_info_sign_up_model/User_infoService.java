package applicant_info_sign_up_model;

import java.util.List;

public class User_infoService {
	User_infoDAO userDAO = new User_infoDAO();
	
	public int insertAdmin(String role, String name, String id, String password, String reg_no, String phone) {
		int list = userDAO.insertAdmin(role, name, id, password, reg_no, phone);
		return list;
	}
	
	public int insertUser(String role, String name, String id, String password, String reg_no, String phone, String address,
			int dependent_count, int non_home_start_date, String account_open_date, String is_married,
			int housing_area) {
			int list = userDAO.insertUser(role, name, id, password, reg_no, phone, address, dependent_count, non_home_start_date, account_open_date, is_married, housing_area);
				return list;
	}
	
	public List<User_infoDTO> area_select() {
		return userDAO.area_select();
	}
	
	public List<User_infoDTO> address_select(){
		return userDAO.address_select();
	}
	public List<User_infoDTO> dependent_select(){
		return userDAO.dependent_select();
	}
	public List<User_infoDTO> nonhome_select(){
		return userDAO.nonhome_select();
	}
	public List<User_infoDTO> account_select(){
		return userDAO.account_select();
	}

}
