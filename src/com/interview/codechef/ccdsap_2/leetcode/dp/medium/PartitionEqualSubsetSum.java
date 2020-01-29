package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/partition-equal-subset-sum
public class PartitionEqualSubsetSum {

    public static void main( String[] args ) {
        int[] arr = {1, 5, 11, 5};

        //Arrays.sort(arr);

      /*
        System.out.println(splitHelper(0, arr, 0, 0));*/

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if (sum % 2 != 0) {
            System.out.println(false);
            return;
        }

        Map<Integer, Boolean> map = new HashMap<>();
        System.out.println(splitMethod2(0, arr, sum / 2, map));

        System.out.println("bottonUp : " + bottonUp(arr, sum / 2));
    }

    //This pattern is again based on Inclusion-Exclusion principle
    //The same pattern has been used in Knapsack1 -> bottomup-Dp solution and CoinChangeTotalWays
    private static boolean bottonUp( int[] arr, int target ) {

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int i = 0; i < arr.length; i++) {

            //inner loop is same as KnapSack1; bcz we cant duplicate values..
            //This is different from : CoinChangeTotalWays
            for (int j = target; j >= arr[i]; j--) {

                //for (int j = amount; j >= arr[i]; j--) {

                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }

        return dp[target];
    }

    private static boolean splitMethod2( int start, int[] nums, int target, Map<Integer, Boolean> map ) {

        if (map.containsKey(target))
            return map.get(target);

        if (target < 0)
            return false;

        if (target == 0)
            return true;

        for (int i = start; i < nums.length; ++i) {

            boolean res = splitMethod2(i + 1, nums, target - nums[i], map);

            map.put(target - nums[i], res);

            if (res)
                return true;
        }

        return false;
    }

    private static boolean splitHelper( int start, int[] nums, int groupSum1, int groupSum2 ) {

        if (start >= nums.length) {
            return groupSum1 == groupSum2;
        }

        if (splitHelper(start + 1, nums, groupSum1 + nums[start], groupSum2))
            return true;

        if (splitHelper(start + 1, nums, groupSum1, groupSum2 + nums[start]))
            return true;

        return false;
    }
}