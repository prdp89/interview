package com.interview.leetcode.contests.contest181;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArray {

    //https://leetcode.com/contest/weekly-contest-181/problems/create-target-array-in-the-given-order/
    public static void main( String[] args ) {
        int[] nums = {1, 2, 3, 4, 0};
        int[] index = {0, 1, 2, 3, 0};

        solve(nums, index);
    }

    private static void solve( int[] nums, int[] index ) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        list.forEach(System.out::println);
    }
}
