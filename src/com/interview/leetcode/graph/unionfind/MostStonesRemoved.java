package com.interview.leetcode.graph.unionfind;

public class MostStonesRemoved {

    //https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
    public static void main( String[] args ) {
        int[][] stones = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        };

        System.out.println(removeStones(stones));
    }

    //Runtime: 58 ms, faster than 26.55% of Java
    private static int removeStones( int[][] stones ) {
        int[] rank = new int[stones.length];

        for (int i = 0; i < stones.length; i++)
            rank[i] = i;

        //we assume all points are connected by default
        int connectedComponent = stones.length;

        //now same as FriendCircles..
        for (int i = 0; i < stones.length; i++) {

            for (int j = 0; j < stones.length; j++) {

                //if other stones on same row as i'th stone
                //OR if other stones are on same col as j'th stone
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    if (findParent(rank, i) != findParent(rank, j)) {
                        union(i, j, rank);

                        //decrement to indicate a component is disjoint..
                        connectedComponent--;
                    }
                }

            }
        }

        //we need at-least one stone unremoved if group of Stones are colliding {in same row or col}
        //So connectedCompoent == disjoint set
        //stones.length == total points in graph
        //Subtracting both will return the largest possible stone we can remove.
        return stones.length - connectedComponent;
    }

    //rank(b) = a ; where {b,a} => findParent(,) value
    private static void union( int a, int b, int[] rank ) {
        rank[findParent(rank, b)] = findParent(rank, a);
    }

    private static int findParent( int[] rank, int p ) {
        if (p != rank[p])
            rank[p] = findParent(rank, rank[p]);

        return rank[p];
    }
}
