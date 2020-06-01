package com.interview.leetcode.bfs;

import java.util.*;

public class PacificAtlanticWaterFlow {

    //Explanation: https://www.youtube.com/watch?v=vSz5sT5LeQQ

    //Water can flow from One cell to Another with equal or Lower value
    //Left Top corner where Pacific ocean flowing : { 1   2   2   3  (5) }
    //Eg : 3 < 5 : so water can flow from 5 -> 3 -> 2 -> 2 -> 1

    //Right Bottom belongs to Atlantic ocean:
    // {(5), 4, 1, 5, 4} : again atlantic water flow from 5 -> 4 and last 5 -> 4

    //But see, bracket (5) is common between Pacific and Atlantic, we have to find these intersection points of pacific and atlantic
    public static void main( String[] args ) {
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        pacificAtlantic(matrix).forEach(System.out::println);
    }

    //Runtime: 20 ms, faster than 23.96% of Java
    private static List<List<Integer>> pacificAtlantic( int[][] matrix ) {

        List<List<Integer>> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;

        int n = matrix.length, m = matrix[0].length;

        //we will store the Left top index in Queue bcz these are already reachable from pacific ocean.
        //and a visited array to keep track these corner points are already visited
        Queue<int[]> pQueue = new LinkedList<>(); //pacific queue
        boolean[][] bPacific = new boolean[n][m]; //so that we don't visit same point from either of Atlantic or Pacific

        Queue<int[]> aQueue = new LinkedList<>(); //atlantic queue
        boolean[][] bAtlantic = new boolean[n][m];


        //storing left edge of Pacific and right edge of Atlantic
        for (int i = 0; i < n; i++) { //vertical direction
            pQueue.offer(new int[]{i, 0});
            bPacific[i][0] = true;

            aQueue.offer(new int[]{i, m - 1});
            bAtlantic[i][m - 1] = true;
        }

        //storing top edge of Pacific and bottom edge of Atlantic
        for (int i = 0; i < m; i++) { //horizontal direction
            pQueue.offer(new int[]{0, i});
            bPacific[0][i] = true;

            aQueue.offer(new int[]{n - 1, i});
            bAtlantic[n - 1][i] = true;
        }

        //calculate reachable points of pacific and atlantic ocean water
        bfs(pQueue, bPacific, matrix);
        bfs(aQueue, bAtlantic, matrix);

        //now, intersection of both is the final answer
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (bPacific[i][j] && bAtlantic[i][j])
                    list.add(Arrays.asList(i, j));
            }
        }

        return list;
    }

    //this bfs is similar to FloodFill bfs, we are visiting only those points which are lower than current
    private static void bfs( Queue<int[]> queue, boolean[][] visited, int[][] matrix ) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int n = matrix.length, m = matrix[0].length;

        while (!queue.isEmpty()) {
            int[] currDir = queue.poll();

            for (int[] dir : dirs) {
                int x = dir[0] + currDir[0];
                int y = dir[1] + currDir[1];

                //Since water can only flow from high/equal cell to low cell,
                // add the neighbour cell with height larger or equal to current cell to the queue
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[currDir[0]][currDir[1]])
                    continue;

                queue.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }
    }
}
