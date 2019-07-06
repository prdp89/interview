package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.HashMap;

public class TargetSum {

    //https://leetcode.com/problems/target-sum/
    public static void main( String[] args ) {
        int[] arr = {1, 1, 1, 1, 1};
        int sum = 3;

        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(solve(arr, 0, 0, sum, map));
    }

    private static int solve( int[] arr, int sum, int index, int target, HashMap<String, Integer> map ) {
        String encodeString = index + ":" + sum;

        if (map.containsKey(encodeString)) {
            return map.get(encodeString);
        }

        if (arr.length == index) {
            if (sum == target)
                return 1;
            else
                return 0;
        }

        /*
        Case 1 : adding current element to sum
        Case 2 : subtract current element to sum
        Adding both result returns total ways.
         */
        int ways = solve(arr, sum + arr[index], index + 1, target, map) +
                solve(arr, sum - arr[index], index + 1, target, map);

        map.put(encodeString, ways);
        return ways;
    }


}
