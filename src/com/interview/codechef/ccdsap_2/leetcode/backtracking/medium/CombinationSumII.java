package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    private static List<List<Integer>> lists = new ArrayList<>();

    //https://leetcode.com/problems/combination-sum-ii/
    public static void main( String[] args ) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        combinationSum2(arr, target).forEach(System.out::println);
    }

    private static List<List<Integer>> combinationSum2( int[] candidates, int target ) {
        Arrays.sort(candidates);

        //backtrack(new ArrayList<>(), candidates, target, 0);

        groupSumWithoutDuplicates(0, candidates, target, new ArrayList<>());
        return lists;
    }

    //Method-----------------1--------------
    //128 / 172 test cases passed.
    //correct code with only 1 line diff. inside for loop:
    //https://leetcode.com/problems/combination-sum-ii/discuss/16861/Java-solution-using-dfs-easy-understand
    private static void backtrack( List<Integer> tempList, int[] nums, int target, int start ) {

        if (target < 0 || start >= nums.length)
            return;

        if (target == 0) {
            //same logic working in Method-2 but not here...
            if (!lists.contains(tempList))
                lists.add(new ArrayList<>(tempList));

            return;
        }

        for (int i = start; i < nums.length; i++) {

            tempList.add(nums[i]);

            backtrack(tempList, nums, target - nums[i], i + 1); // i + 1 because we cannot reuse same elements

            tempList.remove(tempList.size() - 1);
        }
    }

    //Method-------------2----------------------
    //Runtime: 8 ms, faster than 21.73% of Java online submissions
    private static void groupSumWithoutDuplicates( int start, int[] nums, int target, List<Integer> tempList ) {

        if (target == 0) {
            if (!lists.contains(tempList))
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

        groupSumWithoutDuplicates(start + 1, nums, target - nums[start], tempList);

        tempList.remove(tempList.size() - 1);

        // Recursive call trying the case that nums[start] is not chosen.
        groupSumWithoutDuplicates(start + 1, nums, target, tempList);
    }
}
