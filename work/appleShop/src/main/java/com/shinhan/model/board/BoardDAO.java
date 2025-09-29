package com.shinhan.model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import emp.DBUtil;


//비지니스 로직(업무로직)중에서 데이터베잇 관련업무는 DAO에서 작성한다. 
//CRUD작업 
//DAO(Data Access Object)
public class BoardDAO {
	//DB연결, 해제시 사용
	Connection conn;
	//SQL문을 DB에 전송
	Statement st;
	PreparedStatement pst;
	//Select결과
	ResultSet rs;
	//insert,delete,update결과는 영향받은 건수 
	int resultCount;
	
	static final String SELECT_ALL = "select * from board";
	static final String SELECT_DETAIL = "select * from board where bno=?";
	static final String INSERT = "insert into board values(seq_board.nextval,?,?,?,?,?)";
	/*
	 * static final String UPDATE = "update departments set " +
	 * " department_name=?,manager_id=?,location_id=? " + " where department_id=?";
	 * static final String DELETE = "delete from departments where department_id=?";
	 */
	
	//1.Select(Read)..모두보기 
	public List<BoardDTO> selectAll() {
		List<BoardDTO> blist = new ArrayList<BoardDTO>();
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_ALL);
			while(rs.next()) {
				BoardDTO board = makeBoard(rs);
				blist.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return blist;
	}
	//2.Select(Read)..상세보기
	public BoardDTO selectById(int bno) {
		BoardDTO board = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SELECT_DETAIL);
			pst.setInt(1, bno);
			rs = pst.executeQuery();
			while(rs.next()) {
				board = makeBoard(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return board;
	}
	
	//3.Inert
	public int insertBoard(BoardDTO board) {
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(INSERT);
			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setString(3, board.getWriter());
			pst.setString(4, board.getPic1());
			pst.setString(5, board.getPic2());
			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, null);
		}
		return resultCount;
	}

	/*
	 * //4.Update public int updateDept(DeptDTO dept) { conn =
	 * DBUtil.getConnection(); try { pst = conn.prepareStatement(UPDATE);
	 * pst.setInt(4, dept.getDepartment_id()); pst.setString(1,
	 * dept.getDepartment_name()); pst.setObject(2,
	 * dept.getManager_id()==0?null:dept.getManager_id()); pst.setObject(3,
	 * dept.getLocation_id()==0?null:dept.getLocation_id()); resultCount =
	 * pst.executeUpdate(); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } finally { DBUtil.dbDisconnect(conn, pst, null);
	 * } return resultCount; }
	 * 
	 * //5.Delete public int deleteDept(int deptid) { conn = DBUtil.getConnection();
	 * try { pst = conn.prepareStatement(DELETE); pst.setInt(1, deptid); resultCount
	 * = pst.executeUpdate(); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } finally { DBUtil.dbDisconnect(conn, pst,
	 * null); } return resultCount; }
	 */
	
	
	private BoardDTO makeBoard(ResultSet rs) throws SQLException {
		BoardDTO board = BoardDTO.builder()
			.bno(rs.getInt(1))
			.title(rs.getString(2))
			.content(rs.getString(3))
			.writer(rs.getString(4))
			.pic1(rs.getString(5))
			.pic2(rs.getString(6))
			.build();
		return board;
	}
	
}

