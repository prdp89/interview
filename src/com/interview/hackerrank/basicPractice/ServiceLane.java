package com.interview.hackerrank.basicPractice;

import java.util.Arrays;

public class ServiceLane {

    //https://www.hackerrank.com/challenges/service-lane/problem
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        int[] width = {2, 3, 1, 2, 3, 2, 3, 3};

        int[][] cases = {{0, 3},
                {4, 6},
                {6, 7},
                {3, 5},
                {0, 7}};

        int[] result = new int[cases.length];

        for (int i = 0; i < cases.length; i++) {

            int start = cases[i][0], end = cases[i][1];
            int min = width[start];

            for (int j = start + 1; j <= end; j++) {

                min = Math.min(min, width[j]);
            }

            result[i] = min;
        }

        System.out.println(Arrays.toString(result));
    }
}
