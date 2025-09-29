package com.shinhan.applicant_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shinhan.project_util.DBUtil;
import com.shinhan.unit_price_by_area.AreaInfoDTO;

public class InfoDAO {
		Connection conn;
		PreparedStatement pst;
		ResultSet rs;
		int resultCount;
		
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
				delete from applicant_info 
				where name = ? and reg_no = ? and bno = ?
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
		
		
		public int deleteInfo(String name, String reg_no, int bno) {
			conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(MY_INFODELETE);
				pst.setString(1, name);
				pst.setString(2, reg_no);
				pst.setInt(3, bno);
				resultCount = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, null);
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
