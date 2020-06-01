package com.interview.leetcode.bfs;

public class ClosedIslands {

    private static boolean isLandAllOver = true;

    //https://leetcode.com/problems/number-of-closed-islands/
    public static void main( String[] args ) {
        int[][] grid = {
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };

        System.out.println(closedIsland(grid));
    }

    //Runtime: 1 ms, faster than 100.00% of Java
    //Here 0 is Land and 1 is Water
    //Island is close when all Left,Top,Right,Bottom are zero's
    private static int closedIsland( int[][] grid ) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                //if we are on land currently
                if (grid[i][j] == 0) {
                    isLandAllOver = true;

                    dfs(grid, i, j);

                    if (isLandAllOver)
                        count++;
                }
            }
        }

        return count;
    }

    private static void dfs( int[][] grid, int i, int j ) {
        //while traversing we reached end of GRID, return false
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            isLandAllOver = false;
            return;
        }

        //do not traverse if we are on water
        if (grid[i][j] == 1) //this condt. is necessary to exit recursion else Stackoverflow.
            return;

        //sink the current Land to water
        grid[i][j] = 1;

        //traverse in all four directions
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
