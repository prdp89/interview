package com.interview.leetcode.contests.contest174;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRow {

    //https://leetcode.com/contest/weekly-contest-174/problems/the-k-weakest-rows-in-a-matrix/
    public static void main( String[] args ) {

        /*int[][] arr = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };

        solve(arr, 3);*/

        int[][] arr = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };

        solve(arr, 2);
    }

    //in one go :D :P
    private static void solve( int[][] arr, int k ) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(k, ( a, b ) -> {

            //soldiers equal
            if (a.x == b.x)
                return a.y - b.y;
            else
                return a.x - b.x;
        });

        for (int i = 0; i < arr.length; i++) {

            int soldiers = 0;
            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j] == 1)
                    soldiers++;
            }

            pq.offer(new Pair(soldiers, i));
        }

        int[] kArr = new int[k];
        int i = 0;
        while (k-- > 0) {
            kArr[i++] = pq.poll().y;
        }

        System.out.println(Arrays.toString(kArr));
    }

    private static class Pair {
        int x, y;

        public Pair( int soldiers, int i ) {
            this.x = soldiers;
            this.y = i;
        }
    }
}
