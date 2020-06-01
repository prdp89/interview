package com.interview.leetcode.graph.unionfind;

import java.util.Arrays;

public class RedudantConnectionUnionFind {

    //First approach done through BFS : com.interview.leetcode.graph.RedudantConnection

    //https://leetcode.com/problems/redundant-connection/
    public static void main( String[] args ) {
       /* int[][] graph = {
                {1, 2},
                {1, 3},
                {2, 3}
        };*/

        int[][] graph = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5}
        };

        System.out.println(Arrays.toString(findRedundantConnection(graph)));
    }

    /*
    An edge will connect two nodes into one connected component.

    When we count an edge in, if two nodes have already been in the same connected component, the edge will result in a cycle. That is, the edge is redundant.

    We can make use of Disjoint Sets (Union Find).
    If we regard a node as an element, a connected component is actually a disjoint set.

    For example,

    Given edges [1, 2], [1, 3], [2, 3],
      1
     / \
    2 - 3
    Initially, there are 3 disjoint sets: 1, 2, 3.
    Edge [1,2] connects 1 to 2, i.e., 1 and 2 are winthin the same connected component.
    Edge [1,3] connects 1 to 3, i.e., 1 and 3 are winthin the same connected component.
    Edge [2,3] connects 2 to 3, but 2 and 3 have been winthin the same connected component already, so [2, 3] is redundant.
     */

    //same as ConnectCityMinCost
    //Runtime: 0 ms, faster than 100.00% of Java
    private static int[] findRedundantConnection( int[][] edges ) {
        int[] rank = new int[edges.length];

        for (int i = 0; i < rank.length; i++) {
            rank[i] = i;
        }

        int[] res = new int[2];
        for (int[] edge : edges) {

            if (findParent(edge[0] - 1, rank) != findParent(edge[1] - 1, rank)) {
                union(edge[0] - 1, edge[1] - 1, rank);
            } else {
                res[0] = edge[0];
                res[1] = edge[1];
            }
        }

        return res;
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
