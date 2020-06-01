package com.interview.leetcode.graph.directed;

import java.util.Arrays;

public class NetworkDelayTime {

    //https://leetcode.com/problems/network-delay-time/
    public static void main( String[] args ) {
        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int N = 4, K = 2;

        System.out.println(networkDelayTime(times, N, K));
    }

    //This is a Bellman-Ford algo. implementation: Time complexity: O(N*E), Space complexity: O(N)
    //Runtime: 15 ms, faster than 79.39% of Java

    //given all paths: source --> target : [2,1,1],[2,3,1],[3,4,1]
    //2--> 1 , 2---> 3 , 3---> 4
    //we need to find max cost from point K = 2 to any point {1,3,4}

    //Just note that there may be multiple path to reach to a particular node, we need to keep Minimum in that..

    //Final answer will be Max {all min paths from Kth Node}
    private static int networkDelayTime( int[][] times, int N, int K ) {
        int[] distanceToNode = new int[N + 1];

        Arrays.fill(distanceToNode, Integer.MAX_VALUE);

        //we can't visit self node
        distanceToNode[K] = 0;

        //running one less bcz from Self Node we want to avoid..
        for (int i = 1; i <= N; i++) {

            for (int[] edge : times) {
                int source = edge[0], target = edge[1], weight = edge[2];

                if (distanceToNode[source] != Integer.MAX_VALUE && distanceToNode[target] > distanceToNode[source] + weight) {
                    distanceToNode[target] = distanceToNode[source] + weight;
                }

                //We need to Keep min., bcz there can be multiple path to a Node
                //distanceToNode[target] = Math.min(distanceToNode[target], distanceToNode[source] + weight);
            }
        }

        int maxwait = 0;

        for (int i = 1; i <= N; i++)
            maxwait = Math.max(maxwait, distanceToNode[i]);

        return maxwait == Integer.MAX_VALUE ? -1 : maxwait;
    }
}
