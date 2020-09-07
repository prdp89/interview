package com.interview.leetcode.graph.undirected;

import java.util.Arrays;

public class SmallestCityNeighbours {

    //https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
    public static void main( String[] args ) {
        int n = 4, distanceThreshold = 4;
        int[][] edges = {
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        };

        System.out.println(findTheCity(n, edges, distanceThreshold));
    }

    //CourseScheduleIV_FloydWarshal : Same as this, but this is a Undirected example..
    //https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/discuss/490312/JavaC%2B%2BPython-Easy-Floyd-Algorithm
    private static int findTheCity( int n, int[][] edges, int distanceThreshold ) {
        int[][] dis = new int[n][n];
        int res = 0, smallest = n;

        for (int[] row : dis)
            Arrays.fill(row, 10001);

        for (int[] e : edges)
            dis[e[0]][e[1]] = dis[e[1]][e[0]] = e[2];

        //Distance to reach same city is zero
        for (int i = 0; i < n; ++i)
            dis[i][i] = 0;

        for (int k = 0; k < n; ++k)
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; ++j)
                if (dis[i][j] <= distanceThreshold)
                    ++count;

            if (count <= smallest) {
                res = i;
                smallest = count;
            }
        }
        return res;
    }
}
