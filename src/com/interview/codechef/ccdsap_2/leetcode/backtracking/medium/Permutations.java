package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    //https://leetcode.com/problems/permutations/
    public static void main( String[] args ) {

        int[] arr = {1, 2, 3};
        permute(arr).forEach(System.out::println);
    }

    private static List<List<Integer>> permute( int[] nums ) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(nums, res, list, 0);

        return res;
    }

    //solved in one go...
    //similar to PermuationOfString, but last solved problem : braceExpansion, recursion helped alot
    private static void dfs( int[] nums, List<List<Integer>> res, List<Integer> list, int index ) {

        if (index >= nums.length) {
            res.add(new ArrayList<>(list));
            //return; //work with/without return as well, no change in final result.
        }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);

            swap(nums, i, index);
            dfs(nums, res, list, index + 1);

            //backtrack...
            list.remove(list.size() - 1);
            swap(nums, i, index);
        }
    }

    private static void swap( int[] nums, int i, int index ) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
