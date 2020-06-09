package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    private static List<List<Integer>> lists = new ArrayList<>();

    //https://leetcode.com/problems/combination-sum/
    public static void main( String[] args ) {
        int[] arr = {2, 3, 5};
        int target = 8;

        System.out.println(combinationSum(arr, target));

        System.out.println(sum_dp_total_ways(target, arr));
    }

    private static List<List<Integer>> combinationSum( int[] candidates, int target ) {
        Arrays.sort(candidates);
        // groupSum(0, candidates, target, new ArrayList<>());

        backtrack(new ArrayList<>(), candidates, target, 0);
        return lists;
    }

    //Method ----- 1
    //Runtime: 2 ms, faster than 99.82% of Java
    //based on com.interview.hackerrank.recursion.advance
    private static void groupSum( int start, int[] nums, int target, List<Integer> tempList ) {

        if (target == 0) {
            lists.add(new ArrayList<>(tempList));
            return;
        }

        // Base case: if there are no numbers left, then there is a
        // solution only if target is 0.
        if (start >= nums.length || target - nums[start] < 0) {
            return;
        }

        // Recursive call trying the case that nums[start] is chosen --
        // subtract it from target in the call.
        tempList.add(nums[start]);

        groupSum(start, nums, target - nums[start], tempList);

        tempList.remove(tempList.size() - 1);

        // Recursive call trying the case that nums[start] is not chosen.
        groupSum(start + 1, nums, target, tempList);
    }

    //Method ------------------ 2
    //Runtime: 6 ms, faster than 30.24% of Java

    //Runtime: 5 ms, faster than 39.07% of Java
    private static void backtrack( List<Integer> tempList, int[] nums, int target, int start ) {

        //This condition is also imp. otherwise we get stackoverflow
        if (target < 0 || start >= nums.length)
            return;

        if (target == 0) {
            lists.add(new ArrayList<>(tempList));
            //return; //work without return as well
        }

        //else : work with else too

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);

            backtrack(tempList, nums, target - nums[i], i); // not i + 1 because we can reuse same elements

            tempList.remove(tempList.size() - 1);
        }
    }

    //not working..
    private static int sum_dp_total_ways( int totalWeight, int[] arr ) {
        //bcz we have to calculate for total weight of items
        int[] dp = new int[totalWeight + 1];

        dp[0] = 1;

        //Loop until all items are evaluated
        for (int i = 0; i < arr.length; i++) {

            int[] tempTarget = new int[totalWeight + 1];

            for (int j = totalWeight; j >= arr[i]; j--) {

                if (dp[j] != 0) {
                    tempTarget[j - arr[i]] += dp[j];
                }
                   /* dp[j] = Math.max(dp[j]
                            , arr[i] + dp[j - arr[i]]);*/
            }
            dp = tempTarget;
        }

        return dp[totalWeight];
    }
}
