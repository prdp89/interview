package com.interview.leetcode.graph.directed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    //https://leetcode.com/problems/course-schedule-ii/
    public static void main( String[] args ) {
        int[][] graph = {
                {1, 0}
        };

        System.out.println(Arrays.toString(findOrder(2, graph)));
    }

    //Runtime: 3 ms, faster than 94.19% of Java
    //similar Logic as CourseSchedule
    private static int[] findOrder( int numCourses, int[][] prerequisites ) {

        ArrayList<Integer>[] graphList = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            graphList[i] = new ArrayList<>();

        //here {0,1} represent differently as compared to CourseScheduleIV
        for (int[] graph : prerequisites) {
            graphList[graph[1]].add(graph[0]);
            inDegree[graph[0]]++; //logically it is outdegree of Jth Node
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] list = new int[numCourses];
        int resIndex = 0;

        //now whatever node's in-degree is zero then that is a END node
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                list[resIndex++] = i;
            }
        }

        int countVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            countVisited++;
            for (int neighbour : graphList[node]) {

                if (--inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                    list[resIndex++] = neighbour;
                }
            }
        }

        if (countVisited != numCourses)
            return new int[]{};

        return list;
    }
}
