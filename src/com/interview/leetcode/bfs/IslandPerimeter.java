package com.interview.leetcode.bfs;

public class IslandPerimeter {

    //https://leetcode.com/problems/island-perimeter/
    public static void main( String[] args ) {
        int[][] arr = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println(islandPerimeter(arr));
    }

    private static int islandPerimeter( int[][] grid ) {
        int count = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        //checking out of boundary of islands only
                        if (x < 0 || y < 0 || x == grid.length || y == grid[i].length || grid[x][y] == 0) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
