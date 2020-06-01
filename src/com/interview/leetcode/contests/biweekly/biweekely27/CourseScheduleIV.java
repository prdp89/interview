package com.interview.leetcode.contests.biweekly.biweekely27;

import java.util.*;

public class CourseScheduleIV {

    //https://leetcode.com/problems/course-schedule-iv/
    public static void main( String[] args ) {
        int n = 5;
        int[][] preq = {
                {1, 2},
                {1, 2},
                {2, 3},
                {3, 4}
        };

        int[][] queries = {
                {0, 4},
                {4, 0},
                {1, 3},
                {3, 0}
        };

        checkIfPrerequisite_Topological(n, preq, queries).forEach(System.out::println);
    }

    //same logic as CourseSchedule
    //Runtime: 47 ms, faster than 50.00% of Java
    private static List<Boolean> checkIfPrerequisite_Topological( int n, int[][] prerequisites, int[][] queries ) {

        int[] in = new int[n];

        //only diff. from CourseSchedule, we are caching all prerequite courses
        HashSet<Integer>[] data = new HashSet[n];

        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
            data[i] = new HashSet();
        }

        //here {0,1} represent correctly as compared to CourseSchedule
        for (int[] e : prerequisites) {
            graph[e[0]].add(e[1]);
            in[e[1]]++;
        }
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {

                data[next].add(cur);
                data[next].addAll(data[cur]);

                if (--in[next] == 0) {
                    q.offer(next);
                }
            }
        }

        List<Boolean> res = new ArrayList();

        for (int[] query : queries) {
            res.add(data[query[1]].contains(query[0]));
        }

        return res;
    }
}
