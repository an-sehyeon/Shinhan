package ch01;


public class Main {
	    // n으로 나누었을 때, 몫과 나머지가 같은 수들을 모두 더하는 함수
	    public static int solution(int n) {
	        int sum = 0; // 결과 합 저장 변수

	        // q는 1부터 n-1까지 가능
	        // x = q * (n + 1) → 이 x들이 몫과 나머지가 같은 수들임
	        for (int q = 1; q < n; q++) {
	            int x = q * (n + 1); // x는 (n + 1)의 배수
	            sum += x; // 조건을 만족하는 수를 결과에 더함
	        }

	        return sum; // 결과 반환
	    }

	    // 실행 예시
	    public static void main(String[] args) {
	    	// 1번 문제 : 몫과 나머지
	        System.out.println("n : 2, result : " + solution(2)); // 출력: 3
	        System.out.println("n : 3, result : " + solution(3)); // 출력: 12
	        System.out.println("n : 4, result : " + solution(4)); // 출력: 30
	        System.out.println("n : 5, result : " + solution(5)); // 출력: 60
	        
	        // 2번 문제 : 식 조작
	    }
	}
