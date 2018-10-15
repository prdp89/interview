package com.interview.codingblocks.week9DynamicProgrammming;

//We are finding Min. cost path to reach the end og Grid
public class MinCostToEndOfGrid {

    public static void main( String[] args ) {
        int grid[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};

        //min path cost : 1 -> 2 -> 3 -> 2 -> 3 = 11

        int ans = minCostPath(grid, 3, 3);
        System.out.println(ans);
    }

    //https://www.youtube.com/watch?v=ylUOpQJIeVc
    //TIme complexity : O ( M * N )
    //This is Bottom Up DP approach.
    private static int minCostPath( int[][] grid, int m, int n ) {
        int dp[][] = new int[100][100];

        dp[0][0] = grid[0][0];

        //Base case: fill the first row
        for (int c = 1; c < n; c++) {

            dp[0][c] = dp[0][c - 1] + grid[0][c];

        }

        //Base case: fill the first column
        for (int r = 1; r < m; r++) {

            dp[r][0] = dp[0][r - 1] + grid[r][0];

        }


        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {

                dp[r][c] = Math.min(
                        dp[r - 1][c], //value from upward cell
                        dp[r][c - 1] //value from left cell
                ) + grid[r][c]; //Adding current grid cell value

            }
        }
        return dp[m - 1][n - 1];
    }
}
