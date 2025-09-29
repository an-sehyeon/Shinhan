package applicant_info_sign_up_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import apt_util.DBUtil;

public class User_infoDAO {
	Connection conn;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	int resultCount;

	static final String USER_INSERT = """
			insert into user_info values (seq_bno.nextval,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
			""";
	static final String ADDRESS_SELECT = """	
			select distinct address from address_score
			""";
	static final String DEPENDENT_SELECT = """
			select dependent_count from dependent_score
			""";
	static final String NON_HOME_SELECT = """
			select non_home_start_date from non_home_ownership_score
			""";
	static final String ACCOUNT_SELECT = """
			select Account_open_date from subscription_account_score
			""";
	static final String AREA_SELECT = """
			select distinct housing_area from applicant_info
			""";
	static final String ADMIN_INSERT = """
			insert into user_info values (seq_bno.nextval,?, ?, ?, ?, ?, ?)
			""";
			
	public List<User_infoDTO> area_select() {
		List<User_infoDTO> list = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(AREA_SELECT);
			while(rs.next()) {
				User_infoDTO user = new User_infoDTO();
				user.setHousing_area(rs.getInt("housing_area"));
				list.add(user);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return list;
	}
			
	public List<User_infoDTO> account_select(){
		List<User_infoDTO> list = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(ACCOUNT_SELECT);
			while(rs.next()) {
				User_infoDTO user = new User_infoDTO();
				user.setAccount_open_date(rs.getString("account_open_date"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return list;
	}		
			
			
	public List<User_infoDTO> nonhome_select(){
		List<User_infoDTO> list = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(NON_HOME_SELECT);
			while(rs.next()) {
				User_infoDTO user = new User_infoDTO();
				user.setNon_home_start_date(rs.getInt("non_home_start_date"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return list;
	}		
			
			
	public List<User_infoDTO> dependent_select(){
		List<User_infoDTO> list = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(DEPENDENT_SELECT);
			while(rs.next()) {
				User_infoDTO user = new User_infoDTO();
				user.setDependent_count(rs.getInt("dependent_count"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return list;
	}		
	
	public List<User_infoDTO> address_select(){
		List<User_infoDTO> addresslist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(ADDRESS_SELECT);
			while(rs.next()) {
				User_infoDTO user = new User_infoDTO();
				user.setAddress(rs.getString("address"));
				addresslist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return addresslist;
	}

	public int insertAdmin(String role, String name, String id, String password, String reg_no, String phone) {
			conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(ADMIN_INSERT);
				pst.setString(1, role);
				pst.setString(2, name);
				pst.setString(3, id);
				pst.setString(4, password);
				pst.setString(5, reg_no);
				pst.setString(6, phone);
				resultCount = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			DBUtil.dbDisconnect(conn, pst, null);
			}
		return resultCount;
	}

	public int insertUser(String role, String name, String id, String password, String reg_no, String phone, String address,
			int dependent_count, int non_home_start_date, String account_open_date, String is_married,
			int housing_area) {
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(USER_INSERT);
			pst.setString(1, role);
			pst.setString(2, name);
			pst.setString(3, id);
			pst.setString(4, password);
			pst.setString(5, reg_no);
			pst.setString(6, phone);
			pst.setString(7, address);
			pst.setInt(8, dependent_count);
			pst.setInt(9, non_home_start_date);
			pst.setString(10, account_open_date);
			pst.setString(11, is_married);
			pst.setInt(12, housing_area);
			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, null);
		}
		return resultCount;
	}
	
}
