package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    //https://leetcode.com/problems/permutations-ii/
    public static void main( String[] args ) {
        int[] arr = {1, 1, 2};

        permuteUnique(arr).forEach(System.out::println);
    }

    //Runtime: 296 ms, faster than 5.02% of Java
    private static void dfs( int[] nums, List<List<Integer>> res, List<Integer> list, int index ) {

        if (index >= nums.length) {
            if (!res.contains(list))
                res.add(new ArrayList<>(list));
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

    //solution : https://leetcode.com/problems/permutations-ii/discuss/18594/Really-easy-Java-solution-much-easier-than-the-solutions-with-very-high-vote
    private static void dfsTryII( int[] nums, List<List<Integer>> res, List<Integer> list, int index, boolean used[] ) {

        if (index >= nums.length) {
            //if (!res.contains(list))
            res.add(new ArrayList<>(list));
        }

        //same as Permutations second template
        for (int i = 0; i < nums.length; i++) {

            if (used[i])
                continue;

            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
                continue;

            used[i] = true;

            list.add(nums[i]);

            //swap(nums, i, index);
            dfsTryII(nums, res, list, index + 1, used);

            //backtrack...
            used[i] = false;

            list.remove(list.size() - 1);
            // swap(nums, i, index);
        }
    }

    private static void swap( int[] nums, int i, int index ) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    private static List<List<Integer>> permuteUnique( int[] nums ) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        boolean[] used = new boolean[nums.length + 1];

        Arrays.sort(nums);
        dfsTryII(nums, res, list, 0, used);

        return res;
    }
}
