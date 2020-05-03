package com.interview.leetcode.graph;

import java.util.Arrays;

public class ConnectCityMinCost {

    //https://code.dennyzhang.com/connecting-cities-with-minimum-cost
    //https://www.youtube.com/watch?v=V4hm80xAJmM

    /*
    There are N cities numbered from 1 to N.

    You are given connections, where each connections[i] = [city1, city2, cost] represents
    the cost to connect city1 and city2 together. (A connection is bidirectional: connecting
    city1 and city2 is the same as connecting city2 and city1.)

    Return the minimum cost so that for every pair of cities, there exists a path of connections
    (possibly of length 1) that connects those two cities together. The cost is the sum of the connection
    costs used. If the task is impossible, return -1.
     */

    private static int[] rank;

    /*
    Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
    Output: 6
    Explanation:
    Choosing any 2 edges will connect all cities so we choose the minimum 2 --> {1-->2-->3 = 5 +1 = 6}.
     */
    public static void main( String[] args ) {
        int[][] connections = {
                {1, 2, 5},
                {1, 3, 6},
                {2, 3, 1},
        };

        int n = 3;

        System.out.println(minimumCost(n, connections));
    }

    private static int minimumCost( int N, int[][] connections ) {
        rank = new int[N];

        //init every Vertex to default index parent.
        for (int i = 0; i < N; i++) {
            rank[i] = i;
        }

        //sorting acc to edge cost
        Arrays.sort(connections, ( a, b ) -> a[2] - b[2]);

        //NOw if we find two vertices whose parents are not equal,
        //We are assigning parent to it;eg: 1-->2 : 1 child has assigned a Parent = 2
        int cost = 0;
        for (int[] con : connections) {

            //why: con[0]-1 : bcz vertices are Start with 1 and array is zero based index.
            if (findParent(con[0] - 1) != findParent(con[1] - 1)) {
                cost += con[2];

                //linking two vertices with each-other
                union(con[0] - 1, con[1] - 1);
            }
        }

        //checking at last if all the vertices are belong to same group {connected to each other}
        //or != group mean independent cities : we cannot link those cities to find min cost
        int group = findParent(0);
        for (int i = 0; i < N; i++) {
            if (findParent(i) != group)
                return -1;
        }

        return cost;
    }

    //union is like linking two vertices
    private static void union( int a, int b ) {
        rank[findParent(b)] = findParent(a);
    }

    private static int findParent( int p ) {
        if (rank[p] != p) {
            rank[p] = findParent(rank[p]);
        }

        return rank[p];
    }

}
