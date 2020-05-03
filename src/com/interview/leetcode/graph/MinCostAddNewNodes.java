package com.interview.leetcode.graph;

import java.util.Arrays;

public class MinCostAddNewNodes {

    int[] parents;

    //https://leetcode.com/discuss/interview-question/356981
    /*
    Given an undirected graph with n nodes labeled 1..n. Some of the nodes are already connected.

    The i-th edge connects nodes edges[i][0] and edges[i][1] together. Your task is to augment this
    set of edges with additional edges to connect all the nodes. Find the minimum cost to add new
    edges between the nodes such that all the nodes are accessible from each other.

    Input:

    n, an int representing the total number of nodes.
    edges, a list of integer pair representing the nodes already connected by an edge.
    newEdges, a list where each element is a triplet representing the pair of nodes between which an edge can be added and the cost of addition, respectively (e.g. [1, 2, 5] means to add an edge between node 1 and 2, the cost would be 5).
    Example 1:

    Input: n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
    Output: 7
    Explanation:
    There are 3 connected components [1, 4, 5], [2, 3] and [6].
    We can connect these components into a single component by connecting node 1 to node 2 and node 1 to node 6 at a minimum cost of 5 + 2 = 7.
     */
    public static void main( String[] args ) {
        MinCostAddNewNodes main = new MinCostAddNewNodes();

        int tc1 = main.minCostToConnect(6, new int[][]{{1, 4}, {4, 5}, {2, 3}}, new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}});

        if (tc1 == 7) {
            System.out.println("All Test Case Pases!");
        } else {
            System.out.println("There are test failures!");
        }
    }

    public int minCostToConnect( int n, int[][] edges, int[][] newEdges ) {
        parents = new int[n + 1];
        int connected = n, minCost = 0;
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            if (this.union(edge[0], edge[1])) {
                connected--;
            }
        }

        Arrays.sort(newEdges, ( arr1, arr2 ) -> arr1[2] - arr2[2]);

        for (int[] newEdge : newEdges) {
            if (this.union(newEdge[0], newEdge[1])) {
                minCost += newEdge[2];
                connected--;
            }
            if (connected == 1) {
                return minCost;
            }
        }
        return connected == 1 ? connected : -1;
    }

    private boolean union( int x, int y ) {
        int setX = find(x);
        int setY = find(y);
        if (setX != setY) {
            parents[setY] = setX;
            return true;
        }
        return false;
    }

    private int find( int num ) {
        if (parents[num] != num) {
            parents[num] = find(parents[num]);
        }
        return parents[num];
    }
}
