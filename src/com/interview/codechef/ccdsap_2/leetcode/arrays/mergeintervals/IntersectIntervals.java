package com.interview.codechef.ccdsap_2.leetcode.arrays.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class IntersectIntervals {

    /*
    Given two lists of intervals, find the intersection of these two lists.
    Each list consists of disjoint intervals sorted on their start time.

    Intersect Intervals can be found:
        start = max(a.start, b.start)
        end = min(a.end, b.end)

    Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[2, 3], [5, 7]
    Output: [2, 3], [5, 6], [7, 7]
    Explanation: The output list contains the common intervals between the two lists.

     */

    public static void main( String[] args ) {
        int[][] arr_1 = {{1, 3}, {5, 6}, {7, 9}};
        int[][] arr_2 = {{2, 3}, {5, 7}};

        intersectIntervals(arr_1, arr_2).forEach(System.out::println);
    }

    private static List<Interval> intersectIntervals( int[][] arr_1, int[][] arr_2 ) {

        int i = 0, j = 0;
        List<Interval> intersectIntervals = new ArrayList();

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

        return intersectIntervals;
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
