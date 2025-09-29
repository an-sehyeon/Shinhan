import java.util.Scanner;

// 클래스 CopilotTest2는 두 정수를 입력받아 사칙연산을 수행하는 프로그램입니다.
public class CopilotTest {
    public static void main(String[] args) {
        // f_compute 메서드를 호출하여 연산을 수행합니다.
        f_compute();
    }

    // f_compute 메서드는 사용자로부터 두 정수를 입력받고 사칙연산 결과를 출력합니다.
    public static void f_compute() {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성

        // 첫 번째 정수를 입력받습니다.
        System.out.print("Enter first integer: ");
        int num1 = scanner.nextInt();

        // 두 번째 정수를 입력받습니다.
        System.out.print("Enter second integer: ");
        int num2 = scanner.nextInt();

        // 사칙연산 결과를 출력합니다.
        System.out.println("Addition: " + add(num1, num2)); // 덧셈 결과 출력
        System.out.println("Subtraction: " + subtract(num1, num2)); // 뺄셈 결과 출력
        System.out.println("Multiplication: " + multiply(num1, num2)); // 곱셈 결과 출력
        System.out.println("Division: " + divide(num1, num2)); // 나눗셈 결과 출력

        scanner.close(); // Scanner 객체 닫기
    }

    // add 메서드는 두 정수의 합을 반환합니다.
    public static int add(int a, int b) {
        return a + b;
    }

    // subtract 메서드는 두 정수의 차를 반환합니다.
    public static int subtract(int a, int b) {
        return a - b;
    }

    // multiply 메서드는 두 정수의 곱을 반환합니다.
    public static int multiply(int a, int b) {
        return a * b;
    }

    // divide 메서드는 두 정수의 나눗셈 결과를 문자열로 반환합니다.
    // 나눗셈의 분모가 0인 경우 "Cannot divide by zero"를 반환합니다.
    public static String divide(int a, int b) {
        if (b != 0) {
            return String.valueOf((double) a / b); // 나눗셈 결과를 문자열로 변환하여 반환
        } else {
            return "Cannot divide by zero"; // 분모가 0인 경우의 메시지 반환
        }
    }
}
