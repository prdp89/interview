package com.interview.leetcode.dp.minmaxorununbounded;

import java.util.LinkedList;

public class MaximalRectangle {

    //https://leetcode.com/problems/maximal-rectangle/
    public static void main( String[] args ) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };

        System.out.println(maximalRectangle(matrix));
    }

    private static int maximalRectangle( char[][] matrix ) {
        if (matrix.length == 0) return 0;

        int[][] dp = new int[matrix.length][matrix[0].length];

        //if we are thinking in "MaximumHistogram", DP[] array calculates height of each bar in histogram
        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < dp[0].length; j++) {

                dp[i][j] = matrix[i][j] - '0';

                if (dp[i][j] > 0 && i > 0)
                    dp[i][j] += dp[i - 1][j];
            }
        }

        int max = 0;

        //Now we are computing max Width between bars in Histogram.
        for (int[] a : dp)
            max = Math.max(largestRectangleArea(a), max);

        return max;
    }

    // copied 'MaximumHistogram' solution : easy one :p
    private static int largestRectangleArea( int[] a ) {
        LinkedList<Integer> stack = new LinkedList<>();
        int max = 0;

        for (int i = 0; i <= a.length; i++) {

            while (!stack.isEmpty() && (i == a.length || a[stack.peek()] > a[i])) {

                int height = a[stack.pop()];
                int width = (!stack.isEmpty()) ? i - stack.peek() - 1 : i;

                max = Math.max(max, height * width);
            }

            stack.push(i);

        }

        return max;
    }
}
