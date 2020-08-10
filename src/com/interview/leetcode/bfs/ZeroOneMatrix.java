package com.interview.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    //https://leetcode.com/problems/01-matrix/
    public static void main( String[] args ) {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        System.out.println(Arrays.deepToString(updateMatrix(arr)));
    }

    //Runtime: 29 ms, faster than 26.12% of Java
    //This problem is similar to WallsAndGates, except we are using BFS here..
    private static int[][] updateMatrix( int[][] matrix ) {
        Queue<int[]> queue = new LinkedList<>();

        int m = matrix.length, n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];

        //similar to RottenOranges we are storing all Zero's in matrix
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int row = cur[0] + dir[i][0];
                int col = cur[1] + dir[i][1];

                if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
                    continue;
                }

                visited[row][col] = true;
                matrix[row][col] = matrix[cur[0]][cur[1]] + 1; //important step..
                queue.offer(new int[]{row, col});
            }
        }

        return matrix;
    }
}
