package com.shinhan.application_office;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.project_util.DBUtil;

public class OfficeDAO {
	Connection conn;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	
	static final String ALL_RANK_LIST = """
			select * from view_all_rank where housing_area = ? order by area_rank asc
			""";
	static final String LUCKY_LIST = """
			select * from application_office 
			where housing_area = ? 
			and area_rank <= 30 
			order by area_rank asc
			""";
	static final String SELECT_LIST = """
			select ao.bno, ai.name, ao.area_rank 
			from application_office ao join applicant_info ai  on(ao.bno = ai.bno)
			where ai.name = ?
			""";
	static final String SELECT_ALL = """
			select * from view_all_list order by housing_area asc, area_rank asc
			""";
	static final String SELECT_BNO = """
			select * from view_all_list where bno = ?
			""";
	
	public List<OfficeDTO> selectBno(int bno){
		List<OfficeDTO> list = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SELECT_BNO);
			pst.setInt(1, bno);
			rs = pst.executeQuery();
			while(rs.next()) {
				OfficeDTO office = makeInfo(rs);
				list.add(office);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return list;
	}
	
	public List<OfficeDTO> selectAll(){
		List<OfficeDTO> list = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_ALL);
			while(rs.next()) {
				OfficeDTO office = select_all_makeInfo(rs);
				list.add(office);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return list;
	}
	
	public List<OfficeDTO> selectAllList(int area) {
		List<OfficeDTO> list = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(ALL_RANK_LIST);
			pst.setInt(1, area);
			rs = pst.executeQuery();
			while(rs.next()) {
				OfficeDTO office = makeInfo(rs);
				list.add(office);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return list;
	}
	
	public static String buildDebugSQL(String sqlTemplate, Object... params) {
	    for (Object param : params) {
	        String val = (param instanceof String) ? "'" + param + "'" : String.valueOf(param);
	        sqlTemplate = sqlTemplate.replaceFirst("\\?", val);
	    }
	    return sqlTemplate;
	}




	
	public List<OfficeDTO> luckyList(int area){
		List<OfficeDTO> list = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(LUCKY_LIST);
			pst.setInt(1, area);
			rs = pst.executeQuery();
			while(rs.next()) {
				OfficeDTO office = makeInfo(rs);
				list.add(office);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return list;
	}

	public List<OfficeDTO> selectList(String name){
		List<OfficeDTO> list = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SELECT_LIST);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while(rs.next()) {
				OfficeDTO office = makeInfo(rs);
				list.add(office);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return list;
	}


	private OfficeDTO select_all_makeInfo(ResultSet rs) {
		OfficeDTO office = null;
		try {
			office = OfficeDTO.builder()
					.bno(rs.getInt("bno"))
					.name(rs.getString("name"))
					.reg_no(rs.getString("reg_no"))
		            .phone(rs.getString("phone"))
		            .address(rs.getString("address"))
		            .housing_area(rs.getInt("housing_area"))
		            .total_score(rs.getInt("total_score"))
		            .area_rank(rs.getInt("area_rank"))
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return office;
	}

	private OfficeDTO makeInfo(ResultSet rs) {
		OfficeDTO office = null;
		try {
			office = OfficeDTO.builder()
					.bno(rs.getInt("bno"))
		            .name(rs.getString("name"))
		            .reg_no(rs.getString("reg_no"))
		            .phone(rs.getString("phone"))
		            .housing_area(rs.getInt("housing_area"))
		            .dependent_point(rs.getInt("dependent_point"))
		            .non_home_point(rs.getInt("non_home_point"))
		            .account_point(rs.getInt("account_point"))
		            .total_score(rs.getInt("total_score"))
		            .address_point(rs.getInt("address_point"))
		            .is_married(rs.getString("is_married"))
		            .area_rank(rs.getInt("area_rank"))
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return office;
	}
	
	

}
