package com.interview.codechef.ccdsap_2.leetcode.contests.contest144;

import java.util.Arrays;

public class CorporateFlightBookings {

    //https://leetcode.com/contest/weekly-contest-144/problems/corporate-flight-bookings/
    public static void main( String[] args ) {
        int bookings[][] = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };

        int n = 5;

        // System.out.println(Arrays.toString(solveTry(bookings, n)));
        System.out.println(Arrays.toString(corpFlightBookings(bookings, n)));
    }

    //passed in one go
    private static int[] solveTry( int[][] bookings, int n ) {

        int[] op = new int[n];

        for (int i = 0; i < bookings.length; i++) {

            int start = bookings[i][0];
            int end = bookings[i][1];

            op[start - 1] += bookings[i][2];

            for (int j = start; j < end; j++) {
                op[j] += bookings[i][2];
            }
        }

        return op;

    }

    //optimal solution using Running-sum approach
    //Since ranges are continuous, what if we add reservations to the first flight in the range,
    //and remove them after the last flight in range?
    // We can then use the running sum to update reservations for all flights.

    private static int[] corpFlightBookings( int[][] bookings, int n ) {
        int[] res = new int[n];

        for (int[] v : bookings) {
            //adding start value of flight
            res[v[0] - 1] += v[2];

            //After the flight ends, decrement the start value from end + 1 index
            if (v[1] < n) res[v[1]] -= v[2];
        }

        for (int i = 1; i < n; ++i)
            res[i] += res[i - 1];

        return res;
    }
}
