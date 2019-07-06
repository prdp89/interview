package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/combination-sum-iv/
public class CombinationSum4 {

    //THis recursion pattern is same as : com.interview.codechef.ccdsap_2.leetcode.dp.medium.CoinChangeMinCoins
    //or RodCuttingMaxProfit is same too.
    private static int recurse( int[] arr, int sum, Map<Integer, Integer> dp ) {

        int ways = 0;

        if (sum <= 0)
            return sum == 0 ? 1 : 0;

        if (dp.containsKey(sum))
            return dp.get(sum);

        for (int i = 0; i < arr.length; i++) {
            ways += recurse(arr, sum - arr[i], dp);
        }

        dp.put(sum, ways);

        return ways;
    }

    public static void main( String[] args ) {
        int[] arr = {1, 2, 3};
        int sum = 4;

        Map<Integer, Integer> hp = new HashMap<>();

        System.out.println(recurse(arr, sum, hp));
    }
}
