package com.shinhan.day09.lab4;

public class Prob1 {
    public static void main(String[] args) {
        String original = "everyday we have is one more than we deserve";
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < original.length(); i++) {
            char ch = original.charAt(i);

            // 공백은 그대로
            if (ch == ' ') {
                encrypted.append(' ');
            }
            
            else if (ch >= 'a' && ch <= 'z') {
                char c = (char) (ch + 3);

                // z를 넘어가면 a부터 다시 시작
                if (c > 'z') {
                    c -= 26;
                }

                encrypted.append(c);
            }
        }

        System.out.println("암호화할 문자열 : " + original);
        System.out.println("암호화된 문자열 : " + encrypted.toString());
    }
}
