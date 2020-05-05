package com.interview.leetcode.contests.contest180;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LuckyNumInMatrix {

    //https://leetcode.com/problems/lucky-numbers-in-a-matrix/
    public static void main( String[] args ) {
        int[][] ar = {
                {1, 10, 4, 2},
                {9, 3, 8, 7},
                {15, 16, 17, 12},
        };

        //luckyNumbers(ar).forEach(System.out::println);
        luckyNumbersOptimal(ar).forEach(System.out::println);
    }

    private static List<Integer> luckyNumbersOptimal( int[][] matrix ) {
        int[] minRow = new int[matrix.length];
        int[] maxCol = new int[matrix[0].length];

        Arrays.fill(minRow, Integer.MAX_VALUE);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }

        //finding intersection acc. to problem statement..
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                if (minRow[i] == maxCol[j]) {
                    list.add(minRow[i]);
                }
            }
        }

        return list;
    }

    //12 / 103 test cases passed.
    private static List<Integer> luckyNumbers( int[][] matrix ) {
        int[][] temp = new int[matrix.length][2];

        //List<Integer> list = new ArrayList<>();

        int maxG1 = Integer.MIN_VALUE, maxG = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {

            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                min = Math.min(min, matrix[i][j]);
                max = Math.max(max, matrix[i][j]);
            }

            temp[i][0] = min;
            temp[i][1] = max;

            maxG = Math.max(maxG, min);
            maxG1 = Math.max(maxG1, max);
        }

        return Collections.singletonList(Math.min(maxG, maxG1));
    }
}
