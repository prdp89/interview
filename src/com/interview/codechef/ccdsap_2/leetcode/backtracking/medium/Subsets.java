package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    //https://leetcode.com/problems/subsets/
    public static void main( String[] args ) {
        /*int[] nums = {1, 2, 3};

        subsets(nums).forEach(System.out::println);*/

        int[] nums = {4, 4, 4, 1, 4};
        subsets(nums).forEach(System.out::println);
    }

    private static List<List<Integer>> subsets( int[] nums ) {

        List<List<Integer>> listList = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        //dfsSubset(nums, list, listList, 0);

        //--------------------------------------
        Arrays.sort(nums);
        dfsSubsetII(nums, list, listList, 0);
        //--------------------------------------

        return listList;
    }

    //This pattern similar to PalindromePartitioning, except we need all element when index >= 0
    private static void dfsSubset( int[] nums, List<Integer> list, List<List<Integer>> listList, int index ) {
        if (index >= 0) {
            listList.add(new ArrayList<>(list));
            //return; //is not needed bcz this will again backtrack from first level stack itself, and generate wrong result
        }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);

            //we are using i+1 instead of index + 1
            //bcz index + 1 will generate permutation of combination as LetterTilePossibilities
            dfsSubset(nums, list, listList, i + 1);

            list.remove(list.size() - 1);
        }
    }

    //https://leetcode.com/problems/subsets-ii/
    private static void dfsSubsetII( int[] nums, List<Integer> list, List<List<Integer>> listList, int index ) {
        if (index >= 0) {
            List<Integer> temp = new ArrayList<>(list);

            if (!listList.contains(temp))
                listList.add(temp);

            //return; //is not needed bcz this will again backtrack from first level stack itself, and generate wromg result
        }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);

            //we are using i+1 instead of index + 1
            //bcz index + 1 will generate permutation of combination as LetterTilePossibilities
            dfsSubsetII(nums, list, listList, i + 1);

            list.remove(list.size() - 1);
        }
    }
}
