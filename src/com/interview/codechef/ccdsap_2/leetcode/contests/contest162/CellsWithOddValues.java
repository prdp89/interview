package com.interview.codechef.ccdsap_2.leetcode.contests.contest162;

public class CellsWithOddValues {

    //https://leetcode.com/contest/weekly-contest-162/problems/cells-with-odd-values-in-a-matrix/
    public static void main( String[] args ) {

        /*int n = 48, m = 37;
        int[][] arr = {{40, 5}};*/

        int n = 2, m = 3;
        int[][] arr = {{0, 1}, {1, 1}};

        System.out.println(oddCells(n, m, arr));
    }

    //Runtime: 1 ms, faster than 91.04% of Java online submissions
    private static int oddCells( int n, int m, int[][] indices ) {
        int[][] res = new int[n][m];

        for (int[] temp : indices) {

            int first = temp[0], second = temp[1];

            for (int i = 0; i < m; i++) {
                res[first][i] += 1;
            }

            for (int j = 0; j < n; j++) {
                res[j][second] += 1;
            }
        }


        int oddCount = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (res[i][j] % 2 != 0)
                    oddCount++;
            }
        }


        return oddCount;
    }
}
