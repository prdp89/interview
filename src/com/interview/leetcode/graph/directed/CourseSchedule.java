package com.interview.leetcode.graph.directed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    //https://leetcode.com/problems/course-schedule/

    //Awesome Video: https://leetcode.com/problems/course-schedule/
    //1. This question is based on Topological sorting and directed graph.
    //2. By completing prerequisite of course means finding cycle in a Directed graph.
    //3. If cycle exists we can't visit/iterate all the nodes in a Graph.
    //4. WE are using Kahn's Algo. using BFS to find cycle in a graph.
    public static void main( String[] args ) {
        int[][] arr = {
                {0, 1},
                {0, 2},
                {1, 2},
                {1, 3}
        };

        System.out.println(canFinish(4, arr));
    }
    /*
    Graph representation of Array: {{0, 1},{0, 2},{1, 2},{1, 3}}

            0 <<------------------------ 1
            ^                            ^
            |                            |
            |                            |
            |                            |
            |                            |
            2 <<------------------------ 3


        Graph[][] = [ []  [0]  [0]   [1, 2]]
           Index  =    0   1    2       3
        Dependency =   2   1    1       0

        So, Graph[0] = index = 0 = NODE 0 = has 2 dependency {1,2} and has EMPTY neighbours
            Graph[3] = index = 3 = NODE 3 = has zero dependency, both node are outgoing, And has 2 neighbours {1,2}
            Graph[1] = index = 1 = NODE 1 = has one dependency {3} has one neighbour {0}
     */

    //Runtime: 5 ms, faster than 67.17% of Java
    private static boolean canFinish( int numCourses, int[][] edges ) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        //Now for each Edges create a Graph structure
        for (int[] edge : edges) {
            //eg: {0,1} : to take course zero we have to complete course 1
            //            That means 0 has dependency on 1
            //            And, 1 is neighbour of 0
            graph[edge[1]].add(edge[0]);

            // 0 has dependency on 1, increasing its indegree
            inDegree[edge[0]]++;
        }

        //Now finding Node which has zero indegree or dependency
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        //Finally, Count will check if we are able to Traverse all Nodes in a Graph
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            count++;

            //We have Poll one Node = 3 of a Graph which has neighbours = {1,2}
            //This means the Node =3 has removed from Traverse list, so its
            //Neighbours Indegree or Dependency should reduce by 1.

            for (int neighbour : graph[node]) {

                if (--inDegree[neighbour] == 0) {
                    //again If node has zero dependency, adding it to the queue
                    queue.offer(neighbour);
                }
            }
        }

        return count == numCourses;
    }
}
