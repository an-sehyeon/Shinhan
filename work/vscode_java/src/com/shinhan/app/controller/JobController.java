package controller;

import model.JobDTO;
import service.JobService;
import view.JobView;

import java.sql.SQLException;
import java.util.Scanner;

public class JobController {
    private JobService jobService = new JobService();
    private JobView jobView = new JobView();

    /**
     * 프로그램 실행 메서드
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 메뉴 출력
            System.out.println("1. 모든 직업 조회");
            System.out.println("2. 직업 ID로 조회");
            System.out.println("3. 직업 추가");
            System.out.println("4. 직업 수정");
            System.out.println("5. 직업 삭제");
            System.out.println("6. 종료");
            System.out.print("옵션을 선택하세요: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            try {
                switch (option) {
                    case 1:
                        // 모든 Job 데이터 조회
                        jobView.displayJobs(jobService.getAllJobs());
                        break;
                    case 2:
                        // 특정 Job ID로 데이터 조회
                        System.out.print("직업 ID를 입력하세요: ");
                        String jobId = scanner.nextLine();
                        jobView.displayJob(jobService.getJobById(jobId));
                        break;
                    case 3:
                        // 새로운 Job 데이터 추가
                        JobDTO newJob = new JobDTO();
                        System.out.print("직업 ID를 입력하세요: ");
                        newJob.setJobId(scanner.nextLine());
                        System.out.print("직업 이름을 입력하세요: ");
                        newJob.setJobTitle(scanner.nextLine());
                        System.out.print("최소 급여를 입력하세요: ");
                        newJob.setMinSalary(scanner.nextInt());
                        System.out.print("최대 급여를 입력하세요: ");
                        newJob.setMaxSalary(scanner.nextInt());
                        scanner.nextLine(); // 개행 문자 제거
                        if (jobService.addJob(newJob)) {
                            jobView.displayMessage("직업이 성공적으로 추가되었습니다.");
                        } else {
                            jobView.displayMessage("직업 추가에 실패했습니다.");
                        }
                        break;
                    case 4:
                        // 기존 Job 데이터 수정
                        JobDTO updateJob = new JobDTO();
                        System.out.print("직업 ID를 입력하세요: ");
                        updateJob.setJobId(scanner.nextLine());
                        System.out.print("직업 이름을 입력하세요: ");
                        updateJob.setJobTitle(scanner.nextLine());
                        System.out.print("최소 급여를 입력하세요: ");
                        updateJob.setMinSalary(scanner.nextInt());
                        System.out.print("최대 급여를 입력하세요: ");
                        updateJob.setMaxSalary(scanner.nextInt());
                        scanner.nextLine(); // 개행 문자 제거
                        if (jobService.updateJob(updateJob)) {
                            jobView.displayMessage("직업이 성공적으로 수정되었습니다.");
                        } else {
                            jobView.displayMessage("직업 수정에 실패했습니다.");
                        }
                        break;
                    case 5:
                        // 특정 Job 데이터 삭제
                        System.out.print("직업 ID를 입력하세요: ");
                        String deleteJobId = scanner.nextLine();
                        if (jobService.deleteJob(deleteJobId)) {
                            jobView.displayMessage("직업이 성공적으로 삭제되었습니다.");
                        } else {
                            jobView.displayMessage("직업 삭제에 실패했습니다.");
                        }
                        break;
                    case 6:
                        // 프로그램 종료
                        System.out.println("프로그램을 종료합니다...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("잘못된 옵션입니다. 다시 시도하세요.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                jobView.displayMessage("데이터베이스 오류가 발생했습니다.");
            }
        }
    }

    public static void main(String[] args) {
        new JobController().run();
    }
}