package com.interview.codechef.ccdsap_2.leetcode.dp.easy;

public class RangeSumQuery {

    //Adding Tags
    //PrefixSum Prefix
    //Prefix Array

    static int[] sums;

    //https://leetcode.com/problems/range-sum-query-immutable/
    public static void main( String[] args ) {
        solve(new int[]{-2, 0, 3, -5, 2, 1});
    }

    //almost same as MaximumSubArray
    //https://leetcode.com/problems/range-sum-query-immutable/discuss/75192/Java-simple-O(n)-init-and-O(1)-query-solution
    private static void solve( int[] nums ) {
        if (nums.length != 0) {
            sums = new int[nums.length];

            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = nums[i] + sums[i - 1];
            }
        }

        System.out.println(sumRange(0, 2));

        System.out.println("------------------");

        System.out.println(sumRange(1, 3));
    }

    private static int sumRange( int i, int j ) {
        return i == 0 ? sums[j] : sums[j] - sums[i - 1];
    }
}
