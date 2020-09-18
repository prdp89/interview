package com.interview.codechef.ccdsapfoundation_1.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    //https://leetcode.com/problems/k-closest-points-to-origin
    public static void main( String[] args ) {

        System.out.println(Arrays.deepToString(kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
    }

    //https://www.youtube.com/watch?v=1rEUgAG7f_c
    private static int[][] kClosest( int[][] points, int k ) {

        //formula : x2^2 + x1^2 - (y2^2 + y1^2)

        //a[0] a[1] : x1, x2
        //b[0] b[1] : y1, y2

        /*
        we can maintain a max-heap with size K. Then for each point, we add it to the heap.

        Once the size of the heap is greater than K, we are supposed to extract one from the max heap to
        ensure the size of the heap is always K. Thus, the max heap is always maintain top K smallest elements
        from the first one to current one.
         */
        PriorityQueue<int[]> pq = new PriorityQueue<>(( a, b ) ->
                (b[0] * b[0] + b[1] * b[1] - (a[0] * a[0] + a[1] * a[1])));

        //refer 'MergeIntervals' for why we use PriorityQueue<int[]> and comparator usage : Arrays.sort(intervals, ( a, b ) -> a[0] - b[0]);

        for (int[] point : points) {
            pq.add(point);

            if (pq.size() > k)
                pq.remove();
        }

        int[][] result = new int[k][2];
        while (k-- > 0) {
            result[k] = pq.remove();
        }

        return result;
    }
}
