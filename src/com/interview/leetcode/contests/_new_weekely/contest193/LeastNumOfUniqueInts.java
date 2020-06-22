package com.interview.leetcode.contests._new_weekely.contest193;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LeastNumOfUniqueInts {

    public static void main( String[] args ) {
        int[] arr = {5,5,4};
        int k = 1;

        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }

    public static int findLeastNumOfUniqueInts( int[] arr, int k ) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int item : arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(( a, b ) -> a[0] - b[0]);

        for (int item : map.keySet()) {
            pq.offer(new int[]{map.get(item), item});
        }

        while (!pq.isEmpty() && k > 0) {
            int[] item = pq.poll();

            //k -= item[0];

            k--;

            item[0]--;

            if (item[0] > 0) {
                pq.offer(item);
            }
        }

        return pq.size();
    }
}
