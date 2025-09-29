package com.shinhan.day09.lab5;

public class Adder {
    public static void main(String[] args) {
        Adder adder = new Adder();

        String expr = "3+5+9+1";
        System.out.println(expr + "=" + adder.execute(expr));

        expr = "11+45+77+3";
        System.out.println(expr + "=" + adder.execute(expr));

        expr = "33+51+12+11";
        System.out.println(expr + "=" + adder.execute(expr));
    }

    public int execute(String expression) {
        int result = 0;        // 누적 합계
        String strNum = "";    // 숫자를 임시로 담을 문자열

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i); // 현재 문자

            if (currentChar == '+') {
                // + 기호를 만나면 지금까지 모은 숫자(strNum)를 정수로 바꾸고 더함
                result += Integer.parseInt(strNum);
                strNum = ""; // 다음 숫자를 위해 초기화
            } else {
                // 숫자라면 strNum에 누적
                strNum += currentChar;
            }
        }

        // 마지막 숫자는 + 기호가 뒤에 없으므로 따로 더해줌
        result += Integer.parseInt(strNum);

        return result;
    }
}
