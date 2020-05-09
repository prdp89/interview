package com.interview.leetcode.contests.contest176;

public class CountNegativeMatrix {

    //https://leetcode.com/contest/weekly-contest-176/problems/count-negative-numbers-in-a-sorted-matrix/

    //Related qut: search2DMatrixII
    public static void main( String[] args ) {
        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };

        System.out.println(countNegatives(grid));
    }

    //TIME  : 1MS
    private static int countNegatives( int[][] grid ) {

        int count = 0;
        for (int i = grid.length - 1; i >= 0; i--) {

            for (int j = grid[i].length - 1; j >= 0 && grid[i][j] < 0; j--) {
                count++;
            }
        }

        return count;
    }

    /*

    ++++++
    ++++--
    ++++--
    +++---
    +-----
    +-----

     */
    //Runtime: 0 ms, faster than 100.00% of Java
    public int countNegativesOptimal( int[][] grid ) {

        //we are starting from bottom left corner of matrix.

        int m = grid.length, n = grid[0].length, r = m - 1, c = 0, cnt = 0;

        while (r >= 0 && c < n) {

            //this logic is upgrade of my logic, doesn't calculate again if last row element is negative and this condition true.
            if (grid[r][c] < 0) {
                --r; //bcz col are also in sorted order

                cnt += n - c; // total col - starting neg value index
            } else {
                ++c;
            }
        }

        return cnt;
    }
}
