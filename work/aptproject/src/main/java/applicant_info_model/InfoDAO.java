package applicant_info_model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import apt_util.DBUtil;
import unit_price_by_area.model.AreaInfoDTO;

public class InfoDAO {
		Connection conn;
		PreparedStatement pst;
		ResultSet rs;
		int resultCount;
		
		static final String USER_INFO = """
				select * from applicant_info where bno = ?
				""";
		
		static final String INSERT = """
					insert into applicant_info(
						name, reg_no, phone, address, 
						dependent_count, non_home_start_date,
						account_open_date, is_married, housing_area)
						values (?,?,?,?,?,?,?,?,?)
				""";
		static final String MY_INFOSELECT = """
					select * 
					from applicant_info 
					where name = ?
					and reg_no = ?
				""";
		static final String MY_INFOUPDATE = """
				update applicant_info set 
				name = ?, reg_no = ?, phone = ?, address = ?, 
				dependent_count = ?, non_home_start_date = ?, 
				account_open_date = ?, is_married = ?, housing_area = ?
				where bno = ?
			""";
		static final String MY_INFODELETE ="""
				{call delete_applicant(?, ?, ?)}
				""";
		static final String AREA_INFO = """
				select *
				from unit_price_by_area  
				where unit_price_by_area.housing_area = (
				select housing_area from 
				applicant_info where name = ? and reg_no = ?)
				""";
		static final String MYLANK = """
				select * from view_all_rank where bno = ? and name = ? and reg_no = ? and area_rank <= 30
				""";
		static final String AREA_PAYMENT_PLAN = """
				select * from view_area_payment_plan where bno = ?
				""";
	
		
		public InfoDTO userInfo(int bno) {
			InfoDTO info = null;
			conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(USER_INFO);
				pst.setInt(1, bno);
				rs = pst.executeQuery();
				while(rs.next()) {
					info = makeUserInfo(rs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			return info;
		}
		
		
		public InfoDTO paymentPlan(int bno) {
			InfoDTO info = null;
			conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(AREA_PAYMENT_PLAN);
				pst.setInt(1, bno);
				rs = pst.executeQuery();
				while(rs.next()) {
					info = makePaymentPlan(rs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			return info;
		}
		
		public int insertInfo(InfoDTO info) {
				conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(INSERT);
				pst.setString(1, info.getName());
				pst.setString(2, info.getReg_no());
				pst.setString(3, info.getPhone());
				pst.setString(4, info.getAddress());
				pst.setInt(5, info.getDependentCount());
				pst.setInt(6, info.getNonhomestartdate());
				pst.setInt(7, info.getAccountopendate());
				pst.setString(8, info.getIs_married());
				pst.setInt(9, info.getHousingarea());
				resultCount = pst.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Insert 중 에러 발생 : " + e.getMessage());
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			
			return resultCount;
		}
		
		
		
		
		public int updateInfo(InfoDTO info) {
			conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(MY_INFOUPDATE);
				pst.setString(1, info.getName());
				pst.setString(2, info.getReg_no());
				pst.setString(3, info.getPhone());
				pst.setString(4, info.getAddress());
				pst.setInt(5, info.getDependentCount());
				pst.setInt(5, info.getDependentCount());
				pst.setInt(6, info.getNonhomestartdate());
				pst.setInt(7, info.getAccountopendate());
				pst.setString(8, info.getIs_married());
				pst.setInt(9, info.getHousingarea());
				pst.setInt(10, info.getBno());
				resultCount = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, null);
			}
			
			return resultCount;
		}
		
		
		public int deleteInfo(int bno, String name, String reg_no) {
			conn = DBUtil.getConnection();
			// 프로시저 호출
			CallableStatement cstmt = null;
			try {
				cstmt = conn.prepareCall(MY_INFODELETE);
				cstmt.setInt(1, bno);
		        cstmt.setString(2, name);
		        cstmt.setString(3, reg_no);
		        
		        // 프로시저 내부에서 commit 수행
		        cstmt.execute();
		        // 성공했다고 가정하여 1로 반환
				resultCount = 1;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, cstmt, null);
			}
			
			return resultCount;
		}
		
			
		
		public InfoDTO selectMyInfo(String name, String reg_no) {
			InfoDTO info = null;
			conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(MY_INFOSELECT);
				pst.setString(1, name);
				pst.setString(2, reg_no);
				rs = pst.executeQuery();
				while(rs.next()) {
					info = makeInfo(rs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			
			return info;
		}
		
		
		public AreaInfoDTO housingAreaInfo(String name, String reg_no) {
			AreaInfoDTO areaInfo = null;
			conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(AREA_INFO);
				pst.setString(1, name);
				pst.setString(2, reg_no);
				rs = pst.executeQuery();
				if(rs.next()) {
					areaInfo = AreaInfoDTO.builder()
							.housing_area(rs.getInt("housing_area"))
							.down_payment(rs.getString("down_payment"))
							.interim_payment(rs.getString("interim_payment"))
							.balace_payment(rs.getString("balace_payment"))
							.total_price(rs.getString("total_price"))
							.build();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			
			return areaInfo;		
		}
		
		
		public InfoDTO lotte_check(int bno, String name, String reg_no) {
			InfoDTO info = null;
			conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(MYLANK);
				pst.setInt(1, bno);
				pst.setString(2, name);
				pst.setString(3, reg_no);
				rs = pst.executeQuery();
				if(rs.next()) {
					info = InfoDTO.builder()
							.bno(rs.getInt("bno"))
							.name(rs.getString("name"))
							.housing_area(rs.getString("housing_area"))
							.area_rank(rs.getInt("area_rank"))
							.build();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			
			return info;
		}
		
		private InfoDTO makePaymentPlan(ResultSet rs){
			InfoDTO info = null;
			try {
				info = InfoDTO.builder()
						.bno(rs.getInt("bno"))
						.name(rs.getString("name"))
						.reg_no(rs.getString("reg_no"))
						.phone(rs.getString("phone"))
						.housing_area(rs.getString("housing_area"))
						.down_payment(rs.getString("down_payment"))
						.interim_payment(rs.getString("interim_payment"))
						.balace_payment(rs.getString("balace_payment"))
						.total_price(rs.getString("total_price"))
						.build();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return info;
		}
		
		private InfoDTO makeUserInfo(ResultSet rs) {
			InfoDTO info = null;
			try {
				info = InfoDTO.builder()
						.bno(rs.getInt("bno"))
						.name(rs.getString("name"))
						.reg_no(rs.getString("reg_no"))
						.phone(rs.getString("phone"))
						.address(rs.getString("address"))
						.housing_area(rs.getString("housing_area"))
						.build();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return info;
		}
		
		
		private InfoDTO makeInfo(ResultSet rs) throws SQLException {
			InfoDTO info = InfoDTO.builder()
					.bno(rs.getInt(1))
					.name(rs.getString(2))
					.reg_no(rs.getString(3))
					.phone(rs.getString(4))
					.address(rs.getString(5))
					.dependent_count(rs.getString(6))
					.non_home_start_date(rs.getString(7))
					.account_open_date(rs.getString(8))
					.is_married(rs.getString(9))
					.housing_area(rs.getString(10))
					.build();
			return info;
		}





		
		
	

}
