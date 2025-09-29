package com.shinhan.day09.lab6;

public class FindCharacters {
    public static void main(String[] args) {
        FindCharacters fc = new FindCharacters();

        // 테스트a
        int count1 = fc.countChar("Boys, be ambitious", 'i');
        System.out.println("'i'의 개수: " + count1);  // 결과: 2

        // 테스트b
        int count2 = fc.countChar("Boys, be ambitious", 'b');
        System.out.println("'b'의 개수: " + count2);  // 결과: 2
    }

    public int countChar(String str, char c) {
        int count = 0;

        // 문자열을 문자 배열로 변환
        char[] chars = str.toCharArray();

        // 배열 순회하며 해당 문자와 같은지 비교
        for (char ch : chars) {
            if (ch == c) {
                count++;
            }
        }

        return count;
    }
}


