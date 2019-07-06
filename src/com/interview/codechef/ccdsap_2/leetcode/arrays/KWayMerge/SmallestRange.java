package com.interview.codechef.ccdsap_2.leetcode.arrays.KWayMerge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestRange {

    //explanation :https://www.youtube.com/watch?v=Fqal25ZgEDo
    //https://leetcode.com/problems/smallest-range/
    public static void main( String[] args ) {
        int[][] arr = {{4, 10, 15, 24, 26},
                {0, 9, 12, 20},
                {5, 18, 22, 30}};

        System.out.println(Arrays.toString(smallestRange(arr)));
    }

    //This logic is similar to ChunkMerge -> Array
    private static int[] smallestRange( int[][] nums ) {
        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            Element e = new Element(i, 0, nums[i][0]);
            pq.offer(e);

            //max helps to retain maximum value of a range
            max = Math.max(max, nums[i][0]);
        }

        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;

        while (pq.size() == nums.length) {

            Element curr = pq.poll();

            //if Max {out of 3 array} - Cur_value helps in getting smaller range
            if (max - curr.val < range) {

                //update range value
                range = max - curr.val;

                //update start/end for answer
                start = curr.val;
                end = max;
            }

            //similar to chunk-merge: if current element ki list is not finished
            if (curr.idx + 1 < nums[curr.row].length) {

                curr.idx = curr.idx + 1;
                curr.val = nums[curr.row][curr.idx];

                //add curr in PQ and heapify it.
                pq.offer(curr);

                //update max here..
                if (curr.val > max) {
                    max = curr.val;
                }
            }
        }

        return new int[]{start, end};
    }

    static class Element {
        int val;
        int idx;
        int row;

        private Element( int r, int i, int v ) {
            val = v;
            idx = i;
            row = r;
        }
    }
}
