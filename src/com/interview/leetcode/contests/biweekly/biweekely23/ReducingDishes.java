package com.interview.leetcode.contests.biweekly.biweekely23;

import java.util.Arrays;

public class ReducingDishes {

    //https://leetcode.com/problems/reducing-dishes/
    public static void main( String[] args ) {
        int[] arr = {-1, -8, 0, 5, -9};

        System.out.println(maxSatisfaction(arr));
    }

    //Runtime: 1 ms, faster than 100.00% of Java
    private static int maxSatisfaction( int[] satisfaction ) {
        Arrays.sort(satisfaction);

        int sum = 0, i = satisfaction.length - 1, k = 1, ans = 0;

        //iterating till positive satisfaction
        while (i >= 0 && sum + satisfaction[i] >= 0) {
            sum += satisfaction[i];
            i--;
        }

        //since last satisfaction is negative
        i++;

        //for every dish from this point, multiply time value K
        while (i < satisfaction.length) {
            ans += satisfaction[i] * k;
            i++;
            k++;
        }

        return ans;
    }
}
