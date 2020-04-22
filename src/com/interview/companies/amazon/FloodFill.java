package com.interview.companies.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    //https://leetcode.com/problems/flood-fill/
    public static void main( String[] args ) {

       /* int[][] arr = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};

        int sr = 1, sc = 1, newColor = 2;*/

        int[][] arr = {
                {0, 0, 0},
                {0, 0, 0}};

        int sr = 0, sc = 0, newColor = 2;

        floodFill(arr, sr, sc, newColor);
    }

    //solved by me: Runtime: 1 ms, faster than 49.53% of Java
    //try using dirs array instead of if condition's

    //IF want to use DFS it can be same as WallsAndGates recursion
    private static int[][] floodFill( int[][] image, int sr1, int sc1, int newColor ) {
        int temp = image[sr1][sc1];

        if (temp == newColor)
            return image;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr1, sc1, newColor});

        while (!queue.isEmpty()) {

            int[] item = queue.poll();
            int sr = item[0], sc = item[1];

            image[sr][sc] = item[2];

            if (sr - 1 >= 0 && image[sr - 1][sc] == temp) { //top
                queue.offer(new int[]{sr - 1, sc, newColor});
            }

            if (sr + 1 < image.length && image[sr + 1][sc] == temp) { //bottom
                queue.offer(new int[]{sr + 1, sc, newColor});
            }

            //THis line give me some hard time of 1 hour :(
            if (sc + 1 < image[0].length && image[sr][sc + 1] == temp) { //right
                queue.offer(new int[]{sr, sc + 1, newColor});
            }

            if (sc - 1 >= 0 && image[sr][sc - 1] == temp) { //left
                queue.offer(new int[]{sr, sc - 1, newColor});
            }
        }

        return image;
    }

    //try using dirs array instead of if condition
    private static int[][] floodFillOneMore( int[][] image, int sr, int sc, int newColor ) {
        int startColor = image[sr][sc];
        if (startColor == newColor) return image;

        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        Queue<int[]> que = new LinkedList<int[]>();
        que.offer(new int[]{sr, sc});

        while (!que.isEmpty()) {
            int[] pos = que.poll();

            image[pos[0]][pos[1]] = newColor;

            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];

                if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != startColor)
                    continue;

                que.offer(new int[]{x, y});
            }
        }
        return image;
    }
}
