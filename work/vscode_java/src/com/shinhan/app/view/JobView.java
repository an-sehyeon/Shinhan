package view;

import model.JobDTO;

import java.util.List;

public class JobView {
    // 여러 개의 Job 정보를 출력합니다.
    public void displayJobs(List<JobDTO> jobs) {
        for (JobDTO job : jobs) {
            System.out.println(job.getJobId() + " | " + job.getJobTitle() + " | " +
                    job.getMinSalary() + " | " + job.getMaxSalary());
        }
    }

    // 단일 Job 정보를 출력합니다.
    public void displayJob(JobDTO job) {
        if (job != null) {
            System.out.println(job.getJobId() + " | " + job.getJobTitle() + " | " +
                    job.getMinSalary() + " | " + job.getMaxSalary());
        } else {
            System.out.println("Job not found.");
        }
    }

    // 메시지를 출력합니다.
    public void displayMessage(String message) {
        System.out.println(message);
    }
}