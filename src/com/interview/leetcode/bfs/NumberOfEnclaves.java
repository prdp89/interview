package com.interview.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    //https://leetcode.com/problems/number-of-enclaves/
    public static void main( String[] args ) {
        int[][] A = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        System.out.println(numEnclaves(A));
    }

    //Runtime: 4 ms, faster than 78.27% of Java o
    //we need to traverse only to lands and sink it to water.
    //we can start to traverse from corners like FloodFill
    private static int numEnclaves( int[][] A ) {

        //traversing left and right col
        for (int i = 0; i < A.length; i++) {
            bfs(A, i, 0);
            bfs(A, i, A[0].length - 1);
        }

        //traversing top and bottom row
        for (int i = 0; i < A[0].length; i++) {
            bfs(A, 0, i);
            bfs(A, A.length - 1, i);
        }

        int landLeft = 0;
        //now count land left..
        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1)
                    landLeft++;
            }
        }

        return landLeft;
    }

    private static void bfs( int[][] A, int i, int j ) {
        if (A[i][j] == 0)
            return;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        A[i][j] = 0;

        while (!queue.isEmpty()) {

            int[] currIndex = queue.poll();
            for (int[] dir : dirs) {
                int x = dir[0] + currIndex[0];
                int y = dir[1] + currIndex[1];

                if (checkBounds(x, y, A) && A[x][y] == 1) {
                    //sink the Land
                    A[x][y] = 0;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }

    private static boolean checkBounds( int x, int y, int[][] a ) {
        return x >= 0 && y >= 0 && x < a.length && y < a[0].length;
    }
}
