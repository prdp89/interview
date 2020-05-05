package com.interview.leetcode.contests.contest180;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxPerformanceOfTeam {

    //https://leetcode.com/contest/weekly-contest-180/problems/maximum-performance-of-a-team/
    public static void main( String[] args ) {
        int[] speed = {2, 10, 3, 1, 5, 8}, freq = {5, 4, 3, 9, 7, 2};
        int k = 2, n = 6;

        System.out.println(maxPerformance(n, speed, freq, k));
    }

    //O(NlogN + NlogK), noted we have an Arrays.sort() before for loop. Then, K <= N. So we have overall, O(NlogN).
    //Runtime: 43 ms, faster than 29.83% of Java
    //https://leetcode.com/problems/maximum-performance-of-a-team/discuss/539680/Java-Detailed-Explanation-PriorityQueue-O(NlogN)
    private static int maxPerformance( int n, int[] speed, int[] efficiency, int k ) {

        int[][] arr = new int[speed.length][2];

        for (int i = 0; i < speed.length; i++) {
            arr[i] = new int[]{efficiency[i], speed[i]};
        }

        long res = Long.MIN_VALUE, totalSpeed = 0;

        //sort by Higher Efficiency
        Arrays.sort(arr, ( a, b ) -> b[0] - a[0]);

        //We also want to sort the Speed by Higher value and PQ is maintained to Remove lowest Speed from Top
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, ( a, b ) -> a - b);
        for (int[] engineer : arr) {

            //if only want K high performing Engineer, so lower Speed engineer will be removed.
            if (pq.size() == k)
                totalSpeed -= pq.poll();

            //maintaining Engg. Speed in a Queue
            pq.add(engineer[1]);

            totalSpeed += engineer[1];

            // performance = min(efficiency) * sum(speed)
            //So, why not we just try every efficiency and at the same time, and
            // form up a sum of speeds as large as possible.
            res = Math.max(res, (totalSpeed * engineer[0]));
        }

        return (int) (res % (long) (1e9 + 7));
    }
}
