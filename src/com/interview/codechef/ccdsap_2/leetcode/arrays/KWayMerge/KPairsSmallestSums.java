package com.interview.codechef.ccdsap_2.leetcode.arrays.KWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsSmallestSums {

    //https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
    public static void main( String[] args ) {
        int a[] = {1, 7, 11}, b[] = {2, 4, 6};
        int k = 3; //k pair smallest

        List<int[]> list = kSmallestPairs(a, b, k);

        for (int[] arr : list) {
            System.out.println("X:" + arr[0] + " Y:" + arr[1]);
        }
    }

    //similar as : KthSmallestSortedMatrix
    private static List<int[]> kSmallestPairs( int[] nums1, int[] nums2, int k ) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        int m = nums1.length, n = nums2.length;

        List<int[]> res = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k <= 0)
            return res;

        //Insert Only First row in PQ ASC order
        //{0,0} -> {0,1} -> {0,2}
        for (int j = 0; j <= n - 1; j++)
            pq.offer(new Tuple(0, j, nums1[0] + nums2[j]));

        for (int i = 0; i < Math.min(k, m * n); i++) {

            Tuple t = pq.poll();

            res.add(new int[]{nums1[t.x], nums2[t.y]});

            //if first array reaches end
            if (t.x == m - 1)
                continue;

            pq.offer(new Tuple(t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
        }

        return res;
    }

    static class Tuple implements Comparable<Tuple> {
        int x, y, val;

        Tuple( int x, int y, int val ) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo( Tuple that ) {
            return this.val - that.val;
        }
    }
}
