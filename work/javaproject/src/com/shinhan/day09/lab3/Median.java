package com.shinhan.day09.lab3;

import java.util.Arrays;

public class Median {
    public static void main(String[] args) {
        Median median = new Median();

        int[] values1 = { 10, 4, 53, 63, 17, 37, 52, 16, 33, 65 };
        System.out.println("input : " + Arrays.toString(values1));
        System.out.println("median : " + median.findMedian(values1));
        System.out.println("===============================");

        int[] values2 = { 32, 53, 52, 76, 15, 98, 76, 65, 36, 10 };
        System.out.println("input : " + Arrays.toString(values2));
        System.out.println("median : " + median.findMedian(values2));
    }

    public int findMedian(int[] values) {
        // 전체 합을 구함
        int sum = 0;
        for (int v : values) {
            sum += v;
        }

        // 평균값 계산 (소수점 계산 위해 double 사용)
        double avg = (double) sum / values.length;

        // 현재까지 평균값과 가장 가까웠던 수를 저장하는 변수
        int closest = values[0];
        // 평균값과 가장 가까운 거리를 담는 변수
        double minDiff = Math.abs(values[0] - avg);

        for (int i = 1; i < values.length; i++) {
            double diff = Math.abs(values[i] - avg);	// 현재값과 평균값 사이의 절댓값 거리 계산
            if (diff < minDiff) {						// 더 가까운 값이 발견되면 minDiff와 closest 모두 갱신
                minDiff = diff;
                closest = values[i];
            } else if (diff == minDiff && values[i] < closest) {
                // 평균과의 차이가 같으면 더 작은 값 선택
                closest = values[i];
            }
        }

        return closest;
    }
}
