package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.*;

//https://leetcode.com/problems/subsets-ii/
public class SubsetII {

    //THis question is same as XORSUB or PrintAllSubsequence
    //It generates all subsequences of array elements
    private static Set<List<Integer>> res = new HashSet();

    public static void main( String[] args ) {
        List<List<Integer>> listList = subsetsWithDup(new int[]{1, 2, 3});

        for (List<Integer> list : listList) {
            list.forEach(System.out::print);
            System.out.println("-----------------");
        }
    }

    private static List<List<Integer>> subsetsWithDup( int[] nums ) {
        Arrays.sort(nums);

        dfs(new ArrayList(), nums, 0);

        List<List<Integer>> list = new ArrayList();

        for (List<Integer> e : res)
            list.add(e);

        return list;
    }

    private static void dfs( List<Integer> tmp, int[] nums, int start ) {

        res.add(new ArrayList(tmp));

        for (int i = start; i < nums.length; i++) {

            tmp.add(nums[i]);
            dfs(tmp, nums, i + 1);

            //backtrack to remove the last used
            tmp.remove(tmp.size() - 1);
        }
    }
}
