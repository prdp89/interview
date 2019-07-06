package com.interview.codechef.ccdsap_2.leetcode.binarysearch.easy;

import java.util.Arrays;

public class Heaters {

    //https://leetcode.com/problems/heaters

    //Didn't understood it properly
    public static void main( String[] args ) {

        int[] house = {1, 2, 3};
        int[] heaters = {2};

        System.out.println(findRadius(house, heaters));
    }

    private static int findRadius( int[] houses, int[] heaters ) {
        Arrays.sort(heaters);

        int result = Integer.MIN_VALUE;

        for (int house : houses) {

            int index = Arrays.binarySearch(heaters, house);

            if (index < 0) {
                index = -(index + 1);
            }

            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }
}
