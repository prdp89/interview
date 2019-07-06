package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.*;

public class LargestDivisibleSubset {

    private static Map<Integer, List<Integer>> mem = new HashMap<>();

    //https://leetcode.com/problems/largest-divisible-subset/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 4, 8};
        List<Integer> list = largestDivisibleSubset(arr);

        list.forEach(System.out::println);
    }

    private static List<Integer> helper( int[] nums, int i ) {
        if (mem.containsKey(i))
            return mem.get(i);

        List<Integer> maxLenLst = new ArrayList<>();

        //The tricky part is initially (i==0) I set div to be 1 so that every number can start.
        int div = i == 0 ? 1 : nums[i - 1];

        for (int k = i; k < nums.length; k++) {

            //if i is zero then div will be 1 so that atleast one number divides in an array.
            if (nums[k] % div == 0) {

                // make a copy is crucial here, so that we won't modify the returned List reference
                List<Integer> lst = new ArrayList<>(helper(nums, k + 1));
                lst.add(nums[k]);

                if (lst.size() > maxLenLst.size())
                    maxLenLst = lst;
            }
        }

        mem.put(i, maxLenLst);
        return maxLenLst;
    }

    private static List<Integer> largestDivisibleSubset( int[] nums ) {
        Arrays.sort(nums);
        return helper(nums, 0);
    }
}
