package com.shinhan.SimpleBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.shinhan.utils.DBUtil;

public class SimpleBoardDAO {

	static final String READ_ALL = "select * from SimpleBoard";
	static final String READ_BY_WRITER = "select * from SimpleBoard where writer like ?";
	static final String READ_BY_TITLE = "select * from SimpleBoard where title like ?";
	static final String READ_BY_CONTENTS = "select * from SimpleBoard where contents like ?";
	static final String READ_BY_TITLE_AND_CONTENTS = "select * from SimpleBoard where title like ? and contents like ?";
	static final String READ_BY_WRITER_BNO_TITLE = """
			select *
			from SimpleBoard
			where writer = ? and bno = ? and title = ?
			""";
	static final String DELETE = "delete from SimpleBoard where bno = ?";
	static final String UPDATE = """
			update SimpleBoard
			set
			writer = ?,title = ?, contents = ?
			where bno =?
			""";
	static final String INSERT = """
				insert into SimpleBoard(
			    bno,
				writer,
				writedate,
				title,
				contents
				)
			values( bno.nextval,?,sysdate,?,?)
			""";

	public int insertPost(SimpleBoardDTO sb) {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(INSERT);
			pst.setString(1, sb.getWriter());
			pst.setString(2, sb.getTitle());
			pst.setString(3, sb.getContents());
			result = pst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
		} finally {
			DBUtil.dbDisconnect(conn, pst, null);
		}

		return result;
	}

	public int deleteBoard(int bno) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, bno);

			result = pstmt.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			try {
				if (conn != null)
					conn.rollback();
			} catch (SQLException rollbackEx) {
				rollbackEx.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pstmt, rs);

		}
		return result;
	}

	public int boardUpdate(SimpleBoardDTO board) {
		Connection conn = DBUtil.getConnection();
		int resultCount = 0;
		try {
			PreparedStatement pst = conn.prepareStatement(UPDATE);
			pst.setString(1, board.getWriter());
			pst.setString(2, board.getTitle());
			pst.setString(3, board.getContents());
			pst.setInt(4, board.getBno());
			resultCount = pst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
		}

		return resultCount;

	}

	public SimpleBoardDTO selectBoard(String writer, int bno, String title) {
		SimpleBoardDTO board = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(READ_BY_WRITER_BNO_TITLE);
			pst.setString(1, writer);
			pst.setInt(2, bno);
			pst.setString(3, title);
			rs = pst.executeQuery();
			while (rs.next()) {
				board = makesimpleBoardDTO(rs);
			}
		} catch (SQLException e) {
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return board;
	}

	public List<SimpleBoardDTO> selectByTitleAndContents(String writer, String contents) {
		List<SimpleBoardDTO> simpleBoardList = new ArrayList<SimpleBoardDTO>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(READ_BY_TITLE_AND_CONTENTS);
			st.setString(1, "%" + writer + "%");
			st.setString(2, "%" + contents + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				SimpleBoardDTO simpleBoardDTO = makesimpleBoardDTO(rs);
				simpleBoardList.add(simpleBoardDTO);
			}
		} catch (SQLException e) {
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);

		}
		return simpleBoardList;
	}

	public List<SimpleBoardDTO> selectByContents(String contents) {
		List<SimpleBoardDTO> simpleBoardList = new ArrayList<SimpleBoardDTO>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(READ_BY_CONTENTS);
			st.setString(1, "%" + contents + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				SimpleBoardDTO simpleBoardDTO = makesimpleBoardDTO(rs);
				simpleBoardList.add(simpleBoardDTO);
			}
		} catch (SQLException e) {
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return simpleBoardList;
	}

	public List<SimpleBoardDTO> selectByTitle(String title) {
		List<SimpleBoardDTO> simpleBoardList = new ArrayList<SimpleBoardDTO>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(READ_BY_TITLE);
			st.setString(1, "%" + title + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				SimpleBoardDTO simpleBoardDTO = makesimpleBoardDTO(rs);
				simpleBoardList.add(simpleBoardDTO);
			}
		} catch (SQLException e) {
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return simpleBoardList;
	}

	public List<SimpleBoardDTO> selectByWriter(String writer) {
		List<SimpleBoardDTO> simpleBoardList = new ArrayList<SimpleBoardDTO>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(READ_BY_WRITER);
			st.setString(1, "%" + writer + "%");
			rs = st.executeQuery();
			while (rs.next()) {
				SimpleBoardDTO simpleBoardDTO = makesimpleBoardDTO(rs);
				simpleBoardList.add(simpleBoardDTO);
			}
		} catch (SQLException e) {
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return simpleBoardList;
	}

	public List<SimpleBoardDTO> selectAll() {
		List<SimpleBoardDTO> simpleBoardList = new ArrayList<SimpleBoardDTO>();
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(READ_ALL);
			while (rs.next()) {
				SimpleBoardDTO simpleBoardDTO = makesimpleBoardDTO(rs);
				simpleBoardList.add(simpleBoardDTO);
			}
		} catch (SQLException e) {
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return simpleBoardList;
	}

	private SimpleBoardDTO makesimpleBoardDTO(ResultSet rs) throws SQLException {
		SimpleBoardDTO simpleBoardDTO = SimpleBoardDTO.builder().bno(rs.getInt("bno")).writer(rs.getString("writer"))
				.writedate(rs.getDate("writedate")).title(rs.getString("title")).contents(rs.getString("contents"))
				.build();
		return simpleBoardDTO;
	}

}
