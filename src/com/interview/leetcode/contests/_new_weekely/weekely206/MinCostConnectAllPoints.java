package com.interview.leetcode.contests._new_weekely.weekely206;

import java.util.PriorityQueue;

public class MinCostConnectAllPoints {

    public static void main( String[] args ) {
        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        System.out.println(minCostConnectPoints(points));
    }

    //Runtime: 111 ms, faster than 100.00% of Java
    private static int minCostConnectPoints( int[][] points ) {

        //min heap by distance of points
        PriorityQueue<int[]> pq = new PriorityQueue<>(( a, b ) -> a[0] - b[0]);

        int component = points.length;
        int[] rank = new int[component];

        //Iterate for all Nodes combination; Krukshal Algo.
        for (int i = 0; i < component; i++) {

            for (int j = i + 1; j < component; j++) {

                //calculation Manhattan distance
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.add(new int[]{dist, i, j});
            }
        }

        for (int i = 0; i < component; i++) {
            rank[i] = i;
        }

        int resCost = 0;
        while (!pq.isEmpty() && component > 1) { //till all component connected and only 1 left
            int[] curr = pq.poll();

            int a = curr[1]; //why not -1, bcz we are dealing with indices here..
            int b = curr[2];
            int cost = curr[0];

            //We need to consider the new point if they have different parent
            //THen we connect two different components
            if (findParent(a, rank) != findParent(b, rank)) {
                resCost += cost;
                union(a, b, rank);
                component--; //same as RemoveMaxEdgesGraph
            }
        }

        return resCost;
    }

    private static void union( int a, int b, int[] rank ) {
        rank[findParent(b, rank)] = findParent(a, rank);
    }

    private static int findParent( int p, int[] rank ) {
        if (rank[p] != p) {
            rank[p] = findParent(rank[p], rank);
        }

        return rank[p];
    }
}
