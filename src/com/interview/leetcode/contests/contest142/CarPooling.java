package com.interview.leetcode.contests.contest142;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CarPooling {

    //https://leetcode.com/problems/car-pooling/
    public static void main( String[] args ) {
        int[][] trips = {{3, 5, 7}, {2, 1, 5}};
        int capacity = 3;

        greedy(trips, capacity);
    }

    //passing few test cases
    private static void greedy( int[][] trips, int capacity ) {
        Arrays.sort(trips, Comparator.comparingInt(entry -> entry[2]));

        int dropOff = trips[0][2], totalCapacity = trips[0][0];

        for (int i = 1; i < trips.length; i++) {

            if (dropOff <= trips[i][1])
                totalCapacity = 0;

            totalCapacity += trips[i][0];

            dropOff = trips[i][2];
        }

        if (totalCapacity > capacity)
            System.out.println(false);
        else
            System.out.println(true);
    }

    private static boolean carPooling( int[][] trips, int capacity ) {
        //Sorting acc. to Starting Distance
        Arrays.sort(trips, Comparator.comparing(trip -> trip[1]));

        // PriorityQueue<int[]> pq1 = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(trip -> trip[2]));

        for (int[] trip : trips) {

            //if next trip starting point is greater then aDD more passengers
            while (!pq.isEmpty() && trip[1] >= pq.peek()[2])
                capacity += pq.poll()[0]; // more capacity as passengers out.

            capacity -= trip[0]; // less capacity as passengers in.

            if (capacity < 0)
                return false; // not enough capacity.

            pq.offer(trip); // put into PriorityQueue the information at current location.
        }
        return true;
    }
}