package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class LargestPlusSign {

    //https://leetcode.com/problems/largest-plus-sign/
    public static void main( String[] args ) {
        int n = 5;
        int[][] mines = {{4, 2}};

        System.out.println(orderOfLargestPlusSign(n, mines));
    }

    private static int orderOfLargestPlusSign( int N, int[][] mines ) {
        int[][] grid = new int[N][N];
        int ans = 0;

        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], 1);
        }

        //entering mines in GRID
        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (grid[i][j] == 1) {

                    int count = 1;
                    int dir = 1;

                    //checking number of 1's within the bounds..
                    while (j - dir >= 0 && j + dir < N && i - dir >= 0 && i + dir < N &&
                            grid[i][j - dir] == 1 && grid[i][j + dir] == 1 &&
                            grid[i - dir][j] == 1 && grid[i + dir][j] == 1) {

                        count++;
                        dir++;
                    }

                    ans = Math.max(count, ans);
                }
            }
        }
        return ans;
    }
}
