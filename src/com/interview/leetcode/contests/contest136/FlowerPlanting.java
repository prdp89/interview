package com.interview.leetcode.contests.contest136;

import java.util.Arrays;

public class FlowerPlanting {

    //https://leetcode.com/contest/weekly-contest-136/problems/flower-planting-with-no-adjacent/
    public static void main( String[] args ) {

        int[][] arr = {{1, 2}, {2, 3}, {3, 1}};
        int N = 3;

        System.out.println( Arrays.toString(solve(arr, N)));
    }

    //ref  : https://leetcode.com/problems/flower-planting-with-no-adjacent/discuss/305823/Java-solution-or-12-ms
    //Basic idea: adjust the color of nodes whenever two nodes have the same color. Initialy, every node has color 1.

    private static int[] solve( int[][] paths, int n ) {

        int[] result = new int[n];

        Arrays.fill(result, 1);

        boolean stop = false;
        do {
            stop = true;
            for (int[] edge : paths) {

                //getting min out of path
                int u = Math.min(edge[0], edge[1]);

                //getting max out of path
                int v = Math.max(edge[0], edge[1]);

                //If Both edge has same value
                //Case1: when multiple path connected to same garden(edge)
                //Case1: Base case when all edge has 1 initialized
                if (result[u - 1] == result[v - 1]) {

                    stop = false;

                    //Assigning the greater edge the value + 1
                    //If that edge reached max then start planting flower from 1 {1...4}
                    //Assigning 1 works bcz 'there is no garden(edge) that has more than 3 paths coming into or leaving it'
                    result[v - 1] = result[v - 1] == 4 ? 1 : result[v - 1] + 1;
                }
            }
        }
        while (!stop); //loop until all unique flowers are planted
        return result;

    }
}
