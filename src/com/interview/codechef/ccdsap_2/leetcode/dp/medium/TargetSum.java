package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.HashMap;

public class TargetSum {

    //https://leetcode.com/problems/target-sum/
    public static void main( String[] args ) {
        int[] arr = {1, 1, 1, 1, 1};
        int sum = 3;

        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(solve(arr, 0, 0, sum, map));

        System.out.println("bottom up : " + bottonUpDP(arr, sum));
    }


    //This pattern is again based on Inclusion-Exclusion principle
    //The same pattern has been used in Knapsack1 -> bottomup-Dp solution
    //The diff. is just that we are calculating number of ways to get Total sum = s


    //ref : https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
    /* ****Beautiful Explanation********

    let's start with int[][] dp = new int[nums.length][s + 1]
    where dp is 2-d array with dp[i][j] means number of ways to get sum j with first i elements from nums.

    Then you have the transition dp[i][j] = dp[i-1][j] + dp[i][j-nums[i]],
    i.e. you can get the sum j either by just repeating all the ways to get sum j by using first i-1 elements,
    or add nums[i] on top of each way to get sum j-nums[i] using first i elements
     */
    private static int bottonUpDP( int[] arr, int S ) {

        if (arr.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // corner case: when S is out of range [-sum, sum]
        if (S < -sum || S > sum) {
            return 0;
        }

        /*
         if we calculate total sum of all candidate numbers, then the range of possible calculation result will be in
         * the range [-sum, sum]. So we can define an dp array with size sum * 2 + 1 to calculate number of possible ways
         * to reach every target value between -sum to sum, and save results to dp array. dp[sum + S] will be out final
         * result. (because dp[sum] or less represents number of possible ways to reach a number in range [-sum, 0])
         *
         */
        int[] dp = new int[sum * 2 + 1];

        //number of ways to get sum =0 is 1
        //dp[0] = 1;

        //base case:  //if we add all numbers
        dp[sum] = 1;

        //looping for each array elements
        for (int i = 0; i < arr.length; i++) {

            int[] tempTarget = new int[sum * 2 + 1];

            //number of ways to make sum or j = 3 using first array element = 1:
            //dp[3] = dp[3] + dp[3 - arr[i]]
            //for (int j = S; j >= arr[i]; j--) {

            for (int j = (sum * 2 + 1) - 1; j >= arr[i]; j--) {

                //dp[j] = dp[j] + dp[j - arr[i]];

                // WARNING: DO NOT FORGET to check condition whether dp[i] is 0 or not
                // if it is NOT 0, it means we at least have one possible way to reach target j. Otherwise, we may have
                // array out of bound exception

                if (dp[j] != 0) {
                    tempTarget[j + arr[i]] += dp[j];
                    tempTarget[j - arr[i]] += dp[j];
                }
            }

            dp = tempTarget;
        }

        return dp[sum + S];
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
