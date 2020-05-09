package com.interview.leetcode.contests.contest176;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxNumOfEvents {

    //https://leetcode.com/contest/weekly-contest-176/problems/maximum-number-of-events-that-can-be-attended/
    public static void main( String[] args ) {
        int[][] events = {
                {1, 4},
                {4, 4},
                {2, 2},
                {3, 4},
                {1, 1}
        };

        //System.out.println(maxEvents(events));
        System.out.println(maxEventsOPtimal(events));
    }

    private static int maxEvents( int[][] events ) {
        int res = 0;

        Arrays.sort(events, ( a, b ) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Math.abs(a[0] - b[0]));

        /*for (int i =1; i<events) {

        }*/
        return res;
    }

    //Runtime: 69 ms, faster than 20.12% of Java
    private static int maxEventsOPtimal( int[][] events ) {
        //sort the events by start time
        Arrays.sort(events, ( a, b ) -> a[0] - b[0]);

        /*
        Iterate from the day 1 to day 100000,
        Each day, we add new events starting on day d to the queue pq.
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0, res = 0;
        for (int d = 1; d <= 100000; d++) {

            //picking those events which can attend on Day i
            while (i < events.length && events[i][0] == d) {
                pq.offer(events[i++][1]);
            }

            //remove events that are less than current day..already attended
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();

            //if current day d has events that means it can be attended and counted and removed in parallel
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }

        return res;
    }
}
