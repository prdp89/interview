package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/find-right-interval/
public class FindRightInterval {

    public static void main( String[] args ) {
        int[][] arr = {{3, 4}, {2, 3}, {1, 2}};

        System.out.println(Arrays.toString(findRightInterval(arr)));
    }

    //very easy problem; just read the comments..
    private static int[] findRightInterval( int[][] intervals ) {

        int[] result = new int[intervals.length];

        TreeMap<Integer, Integer> intervalMap = new TreeMap<>();

        //storing the First Index of an Interval
        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i][0], i); //storing i at value bcz on output array we have to return the index of interval
        }

        for (int i = 0; i < intervals.length; ++i) {

            //ceilingEntry : returns the entry for the least key greater than the specified key;
            // if no such entry exists returns NULL

            //[ [3,4], [2,3], [1,2] ]
            //op = {-1, 0, 1}
            //for {2,3} the interval [3,4] has minimum-"right" start point

            //for {2,3} -> output is {3,4} bcz its start point '3' is bigger or equals to end point of {2,3}
            //and we are returning {3,4} ka index '0' as an answer.

            //So, we are comparing with Current Interval End point with Arrays minimum-"right" start point
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i][1]);

            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }
}
