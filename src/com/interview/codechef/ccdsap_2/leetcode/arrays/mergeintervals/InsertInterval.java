package com.interview.codechef.ccdsap_2.leetcode.arrays.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    /*
    Given a list of non-overlapping intervals sorted by their start time,
    insert a given interval at the correct position and merge all necessary intervals to produce a list that
    has only mutually exclusive intervals.

    Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
    Output: [[1,3], [4,7], [8,12]]
    Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
     */

    //we need to iterate till intervals[i].end < newInterval.start
    public static void main( String[] args ) {
        int[][] arr = {{1, 3}, {5, 7}, {8, 12}};

        int[] newInterval = {4, 6};

        insertIntervals(arr, newInterval).forEach(System.out::println);
    }

    private static List<Interval> insertIntervals( int[][] arr, int[] newInterval ) {

        List<Interval> intervalList = new ArrayList();

        int i = 0;
        // add to output all intervals that come before the 'newInterval'
        // checking if Current arr -> End interval is less than New Inserted Interval -> start.
        // So that we can insert that new interval after ith index
        while (i < arr.length && arr[i][1] < newInterval[0]) {
            intervalList.add(new Interval(arr[i][0], arr[i][1]));
            i++;
        }

        Interval mergeInterval = new Interval();

        //Now we can Merge the Intervals in arr that overlaps with newInterval
        //checking if Current arr intervals start <= new Interval end
        while (i < arr.length && arr[i][0] <= newInterval[1]) {

            //getting Min. starting point of MergeInterval
            mergeInterval.start = Math.min(arr[i][0], newInterval[0]);

            //to get max. boundary out of merging intervals
            mergeInterval.end = Math.max(arr[i][1], newInterval[1]);

            i++;
        }

        intervalList.add(mergeInterval);

        //add remaining intervals to the output
        while (i < arr.length) {
            intervalList.add(new Interval(arr[i][0], arr[i][1]));
            i++;
        }

        return intervalList;
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
