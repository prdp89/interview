package com.interview.leetcode.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FlowerPlanting {

    //This is based on Graph-Coloring problem..

    //https://leetcode.com/problems/flower-planting-with-no-adjacent/
    public static void main( String[] args ) {
        int n = 4; //there are 4 vertices

        //edge connection between 2 vertices
        int[][] arr = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 1},
                {1, 3},
                {2, 4}
        };

        System.out.println(Arrays.toString(gardenNoAdj(n, arr)));
    }

    //Runtime: 47 ms, faster than 18.86% of Java
    private static int[] gardenNoAdj( int N, int[][] edges ) {
        //create a graph
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }

        //Adding the Edges
        for (int[] edge : edges) {
            //Undirected graph
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        //Graph coloring problem : assigning unique color to each Vertex
        int[] res = new int[N];

        for (int i = 1; i <= N; i++) {

            //Assign each Garden(Vertex) a unique plant (color)
            Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4));

            for (Integer edge : map.get(i)) {
                set.remove(res[edge - 1]);//remove connected Edge of Current vertex.
            }

            res[i - 1] = set.iterator().next(); //res[i-1] = list.get(0);
        }

        return res;
    }
}
