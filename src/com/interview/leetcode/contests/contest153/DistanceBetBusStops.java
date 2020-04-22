package com.interview.leetcode.contests.contest153;

public class DistanceBetBusStops {

    //https://leetcode.com/contest/weekly-contest-153/problems/distance-between-bus-stops/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 4};
        int start = 0, desti = 1;

        System.out.println(distanceBetweenBusStops(arr, start, desti));
    }

    //couldn't understand this problem well enough..
    //15/37 test passed...
    private static int distanceBetweenBusStops( int[] distance, int start, int destination ) {

        int temp;

        if (start > destination) {
            temp = start;
            start = destination;
            destination = temp;
        }

        int sum1 = 0, sum2 = 0;
        for (int i = start; i < destination; i++) {
            sum1 += distance[i];
        }

        while (destination <= distance.length - 1) {
            sum2 += distance[destination++];
        }

        return Math.min(sum1, sum2);
    }
}
