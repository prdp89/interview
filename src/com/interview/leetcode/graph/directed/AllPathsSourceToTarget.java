package com.interview.leetcode.graph.directed;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceToTarget {

    //https://leetcode.com/problems/all-paths-from-source-to-target/
    public static void main( String[] args ) {
        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };

        allPathsSourceTarget(graph).forEach(System.out::println);
    }

    private static List<List<Integer>> allPathsSourceTarget( int[][] graph ) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfsSearch(graph, 0, res, path);

        return res;
    }

    private static void dfsSearch( int[][] graph, int node, List<List<Integer>> res, List<Integer> path ) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);

            dfsSearch(graph, nextNode, res, path);

            path.remove(path.size() - 1);
        }
    }
}
