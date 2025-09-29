package service;

import dao.JobDAO;
import model.JobDTO;

import java.sql.SQLException;
import java.util.List;

public class JobService {
    private JobDAO jobDAO = new JobDAO();

    /**
     * 모든 Job 데이터를 조회하는 서비스 메서드
     * @return JobDTO 리스트
     * @throws SQLException 데이터베이스 작업 중 예외 발생
     */
    public List<JobDTO> getAllJobs() throws SQLException {
        return jobDAO.getAllJobs();
    }

    /**
     * 특정 Job ID로 Job 데이터를 조회하는 서비스 메서드
     * @param jobId 조회할 Job ID
     * @return JobDTO 객체 또는 null
     * @throws SQLException 데이터베이스 작업 중 예외 발생
     */
    public JobDTO getJobById(String jobId) throws SQLException {
        return jobDAO.getJobById(jobId);
    }

    /**
     * 새로운 Job 데이터를 추가하는 서비스 메서드
     * @param job 추가할 JobDTO 객체
     * @return 성공 여부
     * @throws SQLException 데이터베이스 작업 중 예외 발생
     */
    public boolean addJob(JobDTO job) throws SQLException {
        return jobDAO.insertJob(job) > 0;
    }

    /**
     * 기존 Job 데이터를 수정하는 서비스 메서드
     * @param job 수정할 JobDTO 객체
     * @return 성공 여부
     * @throws SQLException 데이터베이스 작업 중 예외 발생
     */
    public boolean updateJob(JobDTO job) throws SQLException {
        return jobDAO.updateJob(job) > 0;
    }

    /**
     * 특정 Job 데이터를 삭제하는 서비스 메서드
     * @param jobId 삭제할 Job ID
     * @return 성공 여부
     * @throws SQLException 데이터베이스 작업 중 예외 발생
     */
    public boolean deleteJob(String jobId) throws SQLException {
        return jobDAO.deleteJob(jobId) > 0;
    }
}