package com.interview.leetcode.graph.directed;

import java.util.*;

public class FindEventualSafeState {

    //https://leetcode.com/problems/find-eventual-safe-states/
    public static void main( String[] args ) {
        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5}, {}, {}
        };

        eventualSafeNodes(graph).forEach(System.out::println);
    }

    //THis logic is same as CourseScheduleIV --> Topological sort and check diagram in CourseSchedule as well..

    //Runtime: 24 ms, faster than 31.39% of Java
    //given graph.length == n nodes in a graph, where each graph[i] represent,
    //i'th Node connection to others: graph[0] = {1,2} means : 0 --> 1 and 0 --> 2
    private static List<Integer> eventualSafeNodes( int[][] graphs ) {
        Set<Integer> list = new HashSet<Integer>();

        ArrayList<Integer>[] graphList = new ArrayList[graphs.length];
        int[] inDegree = new int[graphs.length];

        for (int i = 0; i < graphs.length; i++)
            graphList[i] = new ArrayList<>();

        int j = 0;
        for (int[] graph : graphs) {

            for (int dependentNode : graph) {
                graphList[dependentNode].add(j);
                inDegree[j]++; //logically it is outdegree of Jth Node
            }

            j++;
        }

        Queue<Integer> queue = new LinkedList<>();

        //now whatever node's in-degree is zero then that is a Terminal node
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                list.add(i);
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbour : graphList[node]) {

                if (--inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                    list.add(neighbour);
                }
            }
        }

        List<Integer> resList = new ArrayList<>(list);
        Collections.sort(resList);

        return resList;
    }
}