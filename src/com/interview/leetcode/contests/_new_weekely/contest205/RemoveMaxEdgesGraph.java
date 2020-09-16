package com.interview.leetcode.contests._new_weekely.contest205;

import java.util.Arrays;

public class RemoveMaxEdgesGraph {

    //https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
    public static void main( String[] args ) {
        int components = 4;
        int[][] edges = {
                {3, 1, 2},
                {3, 2, 3},
                {1, 1, 3},
                {1, 2, 4},
                {1, 1, 2},
                {2, 3, 4}
        };

        System.out.println(maxNumEdgesToRemove(components, edges));
    }

    //Runtime: 34 ms, faster than 55.12% of Java
    private static int maxNumEdgesToRemove( int n, int[][] edges ) {
        /*
        Here order matters. Therefore we need to sort the edge by type.
        Type 3 comes first, then type 1 or 2. For type 3 edge, if and only if it is redundant
        for both players, then we can say that this path can be removed, otherwise not.
         */

        //sorting in desc order of edges; type 3 comes first
        Arrays.sort(edges, ( a, b ) -> b[0] - a[0]);

        int[] rankBob = new int[n];
        int[] rankAlice = new int[n];

        for (int i = 0; i < n; i++) {
            rankBob[i] = i;
            rankAlice[i] = i;
        }

        int bobComponent = n, aliceComponent = n;
        int res = 0;

        for (int[] edge : edges) {

            int type = edge[0];

            //{a, b} : represent bi-directional edge
            int a = edge[1] - 1;
            int b = edge[2] - 1;

            switch (type) {
                case 1: //traversed by Alice only
                {
                    int root_a = findParent(a, rankAlice);
                    int root_b = findParent(b, rankAlice);

                    // If roots are the same, then this is a redundant edge and can be removed.
                    if (root_a == root_b) {
                        res++;
                    } else { // If roots are different, we connect two different components.
                        union(a, b, rankAlice);
                        aliceComponent--;
                    }
                }
                break;
                case 2: //traversed by Bob only
                {
                    int root_a = findParent(a, rankBob);
                    int root_b = findParent(b, rankBob);

                    // If roots are the same, then this is a redundant edge and can be removed.
                    if (root_a == root_b) {
                        res++;
                    } else { // If roots are different, we connect two different components.
                        union(a, b, rankBob);
                        bobComponent--;
                    }
                }
                break;
                case 3: //both can traverse
                    int root_a_1 = findParent(a, rankBob);
                    int root_b_1 = findParent(b, rankBob);

                    if (root_a_1 != root_b_1) {
                        union(a, b, rankBob);
                        bobComponent--;
                    }

                    int root_a_2 = findParent(a, rankAlice);
                    int root_b_2 = findParent(b, rankAlice);

                    if (root_a_2 != root_b_2) {
                        union(a, b, rankAlice);
                        aliceComponent--;
                    }

                    //if both can traverse common path
                    if (root_a_1 == root_b_1 && root_a_1 == root_b_2) {
                        res++;
                    }
                    break;
            }
        }

        if (aliceComponent != 1 || bobComponent != 1)
            return -1; // If total number of components is not one for either players, return -1.

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
