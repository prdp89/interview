package com.interview.leetcode.contests.contest137;

import java.util.*;

public class LastStoneWeight {

    //https://leetcode.com/contest/weekly-contest-137/problems/last-stone-weight
    public static void main( String[] args ) {
        int[] arr = {2, 7, 4, 1, 8, 1};
        Arrays.sort(arr);

        solve(arr);
    }

    //Runtime : 2 MS
    private static int solveAgain( int[] stones ) {

        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add(stone);
        }

        while (list.size() > 1) {
            Collections.sort(list);

            int rock_a = list.get(list.size() - 1);
            list.remove(list.size() - 1);

            int rock_b = list.get(list.size() - 1);
            list.remove(list.size() - 1);

            int mat = Math.abs(rock_a - rock_b);
            if (mat > 0) list.add(mat);
        }

        return (list.isEmpty()) ? 0 : list.get(0);
    }

    private static int solve( int[] arr ) {

        while (true) {

            int n = arr.length % 2 == 0 ? arr.length / 2 : (arr.length / 2) + 1;
            int[] temp = new int[n];

            int j = 0;
            for (int i = arr.length - 1; i >= 0; i -= 2) {
                temp[j++] = arr[i] - arr[i - 1];
            }


        }

    }

    //Runtime: 32MS
    public int lastStoneWeight( int[] stones ) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(( a, b ) -> b - a);

        //storing elements in descending order
        for (int i = 0; i < stones.length; i++)
            pq.offer(stones[i]);

        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();

            //sorted descending, so zero is always at last in PQ
            if (a != b)
                pq.offer(a - b);
        }

        if (pq.size() == 0)
            return 0;

        return pq.peek();
    }
}
