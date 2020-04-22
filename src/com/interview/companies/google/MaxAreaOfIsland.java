package com.interview.companies.google;

public class MaxAreaOfIsland {

    private final static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    //https://leetcode.com/problems/max-area-of-island/
    public static void main( String[] args ) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(grid));
    }

    private static int maxAreaOfIsland( int[][] grid ) {

        int max = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }

        return max;
    }

    private static int dfs( int i, int j, int[][] grid ) {

        if (!checkBound(i, j, grid) || grid[i][j] == 0)
            return 0;

        int count = 1;

        grid[i][j] = 0;
        count += dfs(i + 1, j, grid);
        count += dfs(i - 1, j, grid);
        count += dfs(i, j + 1, grid);
        count += dfs(i, j - 1, grid);

        //grid[i][j] = 1; //no need to set to 1 again, returns wrong result.
        return count;
    }

    private static boolean checkBound( int row, int col, int[][] board ) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    private int dfsMOreWay( int[][] grid, int r, int c ) {
        // mark current grid as visited (2)
        grid[r][c] = 0;

        int currArea = 1;

        // try out each possible direction
        for (int[] direction : directions) {

            int nr = r + direction[0], nc = c + direction[1];

            if (checkBound(nr, nc, grid)) {
                currArea += dfsMOreWay(grid, nr, nc);
            }
        }

        return currArea;
    }
}
