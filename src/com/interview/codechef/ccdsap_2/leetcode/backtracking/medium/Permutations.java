package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    //using template: https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
    private void backtrack_One_MOre_WAY( List<List<Integer>> list, Set<Integer> tmpSet, int[] nums ) {
        if (tmpSet.size() == nums.length) {
            list.add(new ArrayList<>(tmpSet));
        } else {
            for (int i = 0; i < nums.length; i++) {

                if (tmpSet.contains(nums[i]))
                    continue; // element already exists, skip

                tmpSet.add(nums[i]);

                backtrack_One_MOre_WAY(list, tmpSet, nums);

                tmpSet.remove(tmpSet.size() - 1);
            }
        }
    }
}
