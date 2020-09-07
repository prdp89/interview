package com.interview.leetcode.graph.directed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinVerticesToAllNodes {

    //https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
    public static void main( String[] args ) {
        List<List<Integer>> listList = new ArrayList<>();
        listList.add(Arrays.asList(0, 1));
        listList.add(Arrays.asList(0, 2));
        listList.add(Arrays.asList(2, 5));
        listList.add(Arrays.asList(3, 4));
        listList.add(Arrays.asList(4, 2));

        findSmallestSetOfVertices(6, listList).forEach(System.out::println);
    }

    //https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/discuss/805685/JavaC%2B%2BPython-Nodes-with-no-In-Degree
    private static List<Integer> findSmallestSetOfVertices( int n, List<List<Integer>> edges ) {
        List<Integer> list = new ArrayList<>();
        int[] seen = new int[n];

        for (List<Integer> item : edges)
            seen[item.get(1)] = 1;

        for (int i = 0; i < n; i++)
            if (seen[i] == 0)
                list.add(i);

        return list;
    }
}
