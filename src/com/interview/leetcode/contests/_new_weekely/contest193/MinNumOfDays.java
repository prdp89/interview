package com.interview.leetcode.contests._new_weekely.contest193;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MinNumOfDays {

    public static void main( String[] args ) {
        int[] bol = {7, 7, 7, 7, 12, 7, 7};
        int m = 2, k = 3;

        System.out.println(days(bol, m, k));
    }

    private static int days( int[] bloomDay, int m, int k ) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int item : bloomDay) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(( a, b ) -> a[0] - b[0]);

        for (int item : map.keySet()) {
            pq.offer(new int[]{map.get(item), item});
        }

        int temp = 0, res = 0;
        while (!pq.isEmpty()) {

            int[] item = pq.poll();

            if (item[0] >= k || temp >= k) {
                res = item[1];
                m--;
                temp = 0;
            } else {
                temp += item[0];
            }

        }

        return m == 0 ? res : -1;
    }
}
