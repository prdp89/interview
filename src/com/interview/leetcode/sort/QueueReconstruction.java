package com.interview.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstruction {

    //https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/
    public static void main( String[] args ) {
        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };

        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

    private static int[][] reconstructQueue( int[][] people ) {

        //if two person heights are not equal : o1[0] != o2[0]
        //Then we are sorting by Height in descending else
        //we are sorting by increasing order {1,2..N} of number of persons in front of them..

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare( int[] o1, int[] o2 ) {
                return o1[0] != o2[0] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]);
            }
        });

        List<int[]> res = new LinkedList<>();

        //res[i] : ith element will be number of person in front..

        for (int[] cur : people) {
            if (null != cur)
                res.add(cur[1], cur);
        }

        return res.toArray(new int[people.length][]);
    }
}
