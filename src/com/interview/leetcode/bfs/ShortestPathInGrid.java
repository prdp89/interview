package com.interview.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInGrid {

    //https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
    public static void main( String[] args ) {
        int k = 1, grid[][] = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };

        System.out.println(shortestPath(grid, k));
    }

    //Runtime: 27 ms, faster than 37.34% of Java
    private static int shortestPath( int[][] grid, int k ) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int n = grid.length, m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});

        //extra State K to maintain number of deleted Nodes.
        boolean[][][] visited = new boolean[n][m][k + 1];
        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] item = queue.poll();
                int r = item[0], c = item[1], currK = item[2];

                if (r == n - 1 && c == m - 1)
                    return res;

                for (int[] dir : dirs) {
                    int nextR = dir[0] + r;
                    int nextC = dir[1] + c;

                    int nextK = currK;

                    if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m) {

                        if (grid[nextR][nextC] == 1)
                            nextK++;

                        if (nextK <= k && !visited[nextR][nextC][nextK]) {
                            visited[nextR][nextC][nextK] = true;
                            queue.offer(new int[]{nextR, nextC, nextK});
                        }
                    }
                }
            }

            res++;
        }

        return -1;
    }
}
