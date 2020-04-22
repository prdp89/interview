package com.interview.leetcode.contests.contest174;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArrayToHalf {

    //https://leetcode.com/contest/weekly-contest-174/problems/reduce-array-size-to-the-half/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        solve(arr);
    }

    private static void solve( int[] arr ) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        if (map.size() == 1) {
            System.out.println(1);
            return;
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(( a, b ) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        int k = 0, prev = 0;

        while (true) {

            Map.Entry<Integer, Integer> entry = pq.poll();
            int val = entry.getValue();

            k++;

            //took little help at this place; really greedy approach
            if (prev + val >= arr.length / 2)
                break;

            prev += val;
        }

        System.out.println(k);
    }
}
