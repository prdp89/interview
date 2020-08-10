package com.interview.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    //https://leetcode.com/problems/shortest-path-in-binary-matrix/
    public static void main( String[] args ) {
        int arr[][] = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        System.out.println(shortestPathBinaryMatrix(arr));
    }

    //Runtime: 33 ms, faster than 25.78% of Java
    //Modified by me :)
    private static int shortestPathBinaryMatrix( int[][] grid ) {
        int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int ans = 0;
        int size = queue.size();

        while (!queue.isEmpty()) {

            size--;

            //for (int i = 0; i < size; i++) {
            int[] pop = queue.remove();

            if (pop[0] == m - 1 && pop[1] == n - 1) {
                return ans + 1;
            }

            for (int k = 0; k < 8; k++) {

                int nextX = dir[k][0] + pop[0];
                int nextY = dir[k][1] + pop[1];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }

            }
            // }

            if (size == 0) {
                ans++;
                size = queue.size();
            }
        }

        return -1;
    }
}
