package com.interview.leetcode.contests.biweekly.biweekely27;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIV_FloydWarshal {

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

        checkIfPrerequisite(n, preq, queries).forEach(System.out::println);
    }

    //Algo video: https://www.youtube.com/watch?v=oNI0rf2P9gE

    //same logic as CourseSchedule
    //Runtime: 54 ms, faster than 50.00% of Java
    private static List<Boolean> checkIfPrerequisite( int n, int[][] prerequisites, int[][] queries ) {
        boolean[][] connection = new boolean[n][n];

        //initially plotting the vertices, those are connected..
        for (int[] preq : prerequisites) {
            connection[preq[0]][preq[1]] = true;
        }

        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    //A[i][j] = Math.min (A[i][j],  A[i][k] + A[k][j])
                    connection[i][j] = connection[i][j] || connection[i][k] && connection[k][j];
                }
            }
        }

        List<Boolean> list = new ArrayList<>();
        for (int[] query : queries) {
            list.add(connection[query[0]][query[1]]);
        }

        return list;
    }
}