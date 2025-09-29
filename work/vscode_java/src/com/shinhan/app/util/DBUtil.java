package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    // 데이터베이스 연결 정보를 상수로 정의
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "hr";
    private static final String PASSWORD = "hr";

    // 정적 블록에서 드라이버 로드
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Oracle JDBC 드라이버를 로드할 수 없습니다.");
            e.printStackTrace();
        }
    }

    // 생성자
    private DBUtil() {
        // 인스턴스 생성 방지
    }

    /**
     * 데이터베이스 연결을 생성하여 반환하는 메서드
     * @return Connection 객체
     * @throws SQLException 데이터베이스 연결 실패 시 예외 발생
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * 사용한 자원을 해제하는 메서드
     * @param conn Connection 객체
     * @param pstmt PreparedStatement 객체
     * @param rs ResultSet 객체
     */
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 사용한 자원을 해제하는 메서드 (ResultSet이 없는 경우)
     * @param conn Connection 객체
     * @param pstmt PreparedStatement 객체
     */
    public static void close(Connection conn, PreparedStatement pstmt) {
        close(conn, pstmt, null);
    }
}