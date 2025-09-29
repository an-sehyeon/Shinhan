package dao;

import model.JobDTO;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {
    /**
     * 모든 Job 데이터를 조회하는 메서드
     * @return JobDTO 리스트
     * @throws SQLException 데이터베이스 작업 중 예외 발생
     */
    public List<JobDTO> getAllJobs() throws SQLException {
        List<JobDTO> jobs = new ArrayList<>();
        String query = "SELECT * FROM JOBS";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                JobDTO job = new JobDTO();
                job.setJobId(rs.getString("JOB_ID"));
                job.setJobTitle(rs.getString("JOB_TITLE"));
                job.setMinSalary(rs.getInt("MIN_SALARY"));
                job.setMaxSalary(rs.getInt("MAX_SALARY"));
                jobs.add(job);
            }
        } finally {
            DBUtil.close(conn, pstmt, rs);
        }
        return jobs;
    }

    /**
     * 특정 Job ID로 Job 데이터를 조회하는 메서드
     * @param jobId 조회할 Job ID
     * @return JobDTO 객체 또는 null
     * @throws SQLException 데이터베이스 작업 중 예외 발생
     */
    public JobDTO getJobById(String jobId) throws SQLException {
        String query = "SELECT * FROM JOBS WHERE JOB_ID = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, jobId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                JobDTO job = new JobDTO();
                job.setJobId(rs.getString("JOB_ID"));
                job.setJobTitle(rs.getString("JOB_TITLE"));
                job.setMinSalary(rs.getInt("MIN_SALARY"));
                job.setMaxSalary(rs.getInt("MAX_SALARY"));
                return job;
            }
        } finally {
            DBUtil.close(conn, pstmt, rs);
        }
        return null;
    }

    /**
     * 새로운 Job 데이터를 삽입하는 메서드
     * @param job 삽입할 JobDTO 객체
     * @return 삽입된 행의 개수
     * @throws SQLException 데이터베이스 작업 중 예외 발생
     */
    public int insertJob(JobDTO job) throws SQLException {
        String query = "INSERT INTO JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, job.getJobId());
            pstmt.setString(2, job.getJobTitle());
            pstmt.setInt(3, job.getMinSalary());
            pstmt.setInt(4, job.getMaxSalary());
            return pstmt.executeUpdate();
        } finally {
            DBUtil.close(conn, pstmt);
        }
    }

    /**
     * 기존 Job 데이터를 수정하는 메서드
     * @param job 수정할 JobDTO 객체
     * @return 수정된 행의 개수
     * @throws SQLException 데이터베이스 작업 중 예외 발생
     */
    public int updateJob(JobDTO job) throws SQLException {
        String query = "UPDATE JOBS SET JOB_TITLE = ?, MIN_SALARY = ?, MAX_SALARY = ? WHERE JOB_ID = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, job.getJobTitle());
            pstmt.setInt(2, job.getMinSalary());
            pstmt.setInt(3, job.getMaxSalary());
            pstmt.setString(4, job.getJobId());
            return pstmt.executeUpdate();
        } finally {
            DBUtil.close(conn, pstmt);
        }
    }

    /**
     * 특정 Job 데이터를 삭제하는 메서드
     * @param jobId 삭제할 Job ID
     * @return 삭제된 행의 개수
     * @throws SQLException 데이터베이스 작업 중 예외 발생
     */
    public int deleteJob(String jobId) throws SQLException {
        String query = "DELETE FROM JOBS WHERE JOB_ID = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, jobId);
            return pstmt.executeUpdate();
        } finally {
            DBUtil.close(conn, pstmt);
        }
    }
}