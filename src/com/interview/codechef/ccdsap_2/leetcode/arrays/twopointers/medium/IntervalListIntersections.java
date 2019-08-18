package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    //https://leetcode.com/problems/interval-list-intersections/
    public static void main( String[] args ) {
        int[][] arr_1 = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] arr_2 = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        System.out.println(Arrays.deepToString(solveTry(arr_1, arr_2)));
    }

    private static int[][] solveTry( int[][] arr_1, int[][] arr_2 ) {

        List<Interval> intersectIntervals = new ArrayList<>();

        int i = 0, j = 0;

        while (i < arr_1.length && j < arr_2.length) {

            // check if the interval arr[i] intersects with arr2[j]
            // check if one of the interval's start time lies within the other interval

            //checking arr_1 -> start >= arr_2 -> start && arr_1 -> start <= arr_2 -> end  OR vice-versa
            if ((arr_1[i][0] >= arr_2[j][0] && arr_1[i][0] <= arr_2[j][1]) ||
                    (arr_2[j][0] >= arr_1[i][0] && arr_2[j][0] <= arr_1[i][1])) {

                //storing intersecting intervals
                intersectIntervals.add(new Interval(Math.max(arr_1[i][0], arr_2[j][0])
                        , Math.min(arr_1[i][1], arr_2[j][1])));
            }

            // move next from the interval which is finishing first
            if (arr_1[i][1] < arr_2[j][1])
                i++;
            else
                j++;
        }

        int[][] res = new int[intersectIntervals.size()][2];

        for (int k = 0; k < intersectIntervals.size(); k++) {

            res[k][0] = intersectIntervals.get(k).start;
            res[k][1] = intersectIntervals.get(k).end;

        }

        return res;
    }

    static class Interval {

        int start;
        int end;

        Interval() {
        }

        Interval( int start, int end ) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + "->" + end;
        }
    }
}
