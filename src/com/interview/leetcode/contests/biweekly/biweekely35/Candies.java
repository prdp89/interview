package com.interview.leetcode.contests.biweekly.biweekely35;

import java.util.Arrays;
import java.util.List;

public class Candies {


    public static void main( String[] args ) {
        int[] candies = {12,1,12};
        int extra = 10;

        kidsWithCandies(candies, extra).forEach(System.out::println);
    }

    private static List<Boolean> kidsWithCandies( int[] candies, int extraCandies ) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        Boolean[] res = new Boolean[candies.length];
        for (int i = 0; i < candies.length; i++) {
            res[i] = candies[i] + extraCandies >= max;
        }

        return Arrays.asList(res);
    }
}
