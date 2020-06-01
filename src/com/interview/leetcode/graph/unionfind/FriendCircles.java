package com.interview.leetcode.graph.unionfind;

public class FriendCircles {

    //https://leetcode.com/problems/friend-circles/
    public static void main( String[] args ) {
        int[][] graph = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println(findCircleNum(graph));
    }

    //We have count number of Disjoint set here..
    //Count is total nodes, if two nodes have diff. parent then decrement count.
    //Runtime: 2 ms, faster than 46.32% of Java
    private static int findCircleNum( int[][] M ) {
        int[] rank = new int[M.length];

        for (int i = 0; i < M.length; i++) {
            rank[i] = i;
        }

        int count = M.length;

        for (int i = 0; i < M.length; i++) {

            for (int j = 0; j < M.length; j++) {

                if (M[i][j] == 1) {
                    if (findParent(i, rank) != findParent(j, rank)) {
                        count--;
                        union(i, j, rank);
                    }
                }
            }
        }

        return count;
    }

    private static void union( int a, int b, int[] rank ) {
        rank[findParent(b, rank)] = findParent(a, rank);
    }

    private static int findParent( int p, int[] rank ) {
        if (p != rank[p])
            rank[p] = findParent(rank[p], rank);

        return rank[p];
    }
}
