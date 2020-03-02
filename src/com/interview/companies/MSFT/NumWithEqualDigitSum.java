package com.interview.companies.MSFT;

import java.util.HashMap;

public class NumWithEqualDigitSum {

    //https://leetcode.com/discuss/interview-question/365872/
    public static void main( String[] args ) {
        int[] arr = {42, 33, 60};

        System.out.println(solve(arr));
    }

    private static int solve( int[] arr ) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            int sum = sumOfDigits(arr[i]);
            map.put(sum, map.getOrDefault(sum, 0) + arr[i]);

            max = Math.max(max, map.getOrDefault(sum, 0));
        }

        return max;
    }

    private static int sumOfDigits( int i ) {

        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
