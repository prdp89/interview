package com.interview.leetcode.graph.unionfind;

import java.util.HashMap;
import java.util.Map;

public class LargestComponentSize {

    //Almost similar to AccountsMerge
    //https://leetcode.com/problems/largest-component-size-by-common-factor/

    //video : https://www.youtube.com/watch?v=DNfNZwilaC4
    //Runtime: 243 ms, faster than 36.28% of Java
    public static void main( String[] args ) {
        int[] A = {4, 6, 15, 35};

        System.out.println(largestComponentSize(A));
    }

    // { 4, 6, 15, 35}
    //Factors of 4 : 2, 4
    //Factors of 6 : 2, 3
    //Factors of 15 : 3, 5
    //Factors of 35: 5, 7
    //So, 4 --> 6 belong to same component bcz 2 are common in between
    //    15 --> 35 belong to same component bcz 5 are common in between
    //    6 --> 15 belong to same component bcz 3 are common in between
    //That means 4 --> 6 --> 15 --> 35 can be a same component

    private static void union( int a, int b, int[] rank ) {
        rank[findParent(b, rank)] = findParent(a, rank);
    }

    private static int findParent( int p, int[] rank ) {
        if (p != rank[p]) {
            rank[p] = findParent(rank[p], rank);
        }

        return rank[p];
    }

    private static int largestComponentSize( int[] A ) {
        int[] rank = new int[10010];

        for (int i = 0; i < rank.length; i++)
            rank[i] = i;

        for (int num : A) {

            for (int j = 2; j <= Math.sqrt(num); j++) {

                if (num % j == 0) {

                    if (findParent(num, rank) != findParent(j, rank))
                        union(j, num, rank); //here rank[4] = 2

                    //generating another factor
                    if (findParent(num, rank) != findParent(num / j, rank))
                        union(num, num / j, rank);
                }
            }
        }

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        //for each item finding the parent group it belongs to:
        //Eg: 4 --> 2
        //    6 --> 2
        //so, map[2] = 2
        for (int x : A) {
            int j = findParent(x, rank);

            count = Math.max(count, 1 + map.getOrDefault(j, 0));
            map.put(j, 1 + map.getOrDefault(j, 0));
        }

        return count;
    }
}
