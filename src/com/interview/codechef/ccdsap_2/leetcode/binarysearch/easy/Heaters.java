package com.interview.codechef.ccdsap_2.leetcode.binarysearch.easy;

import java.util.Arrays;
import java.util.TreeSet;

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

    private static int findRadiusUsingTreeSet( int[] houses, int[] heaters ) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int heater : heaters)
            set.add(heater);

        int res = 0;
        for (int house : houses) {
            int dist1 = set.ceiling(house) == null ? Integer.MAX_VALUE : set.ceiling(house) - house;
            int dist2 = set.floor(house) == null ? Integer.MAX_VALUE : house - set.floor(house);
            res = Math.max(res, Math.min(dist1, dist2));
        }

        return res;
    }
}
