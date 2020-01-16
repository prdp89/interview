package com.interview.codechef.ccdsap_2.leetcode.dp.easy;

public class MaximumSubArray {

    //https://leetcode.com/problems/maximum-subarray/

    //refer optimal solution here...
    //https://leetcode.com/problems/maximum-subarray/discuss/20211/Accepted-O(n)-solution-in-java

    public static void main( String[] args ) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //System.out.println(recurse(arr, arr.length - 1));

        System.out.println(maxSubArrayAgain(arr));
    }

    //returning wrong result...
    private static int recurse( int[] arr, int i ) {

        if (i == 0)
            return arr[i];

        return arr[i] + (recurse(arr, i - 1) < 0 ? 0 : recurse(arr, i - 1));
    }

    //solved by me :)
    //got motivation from : MaxSumNonConsecutive
    private static int maxSubArrayAgain( int[] nums ) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        int max;

        dp[0] = nums[0];

        if (nums.length < 2)
            return dp[0];

        dp[1] = Math.max(dp[0] + nums[1], nums[1]);

        //incase of nums size is 2
        max = Math.max(dp[1], dp[0]);

        for (int i = 2; i < nums.length; i++) {

            //max can get by either selecting current or
            //selecting current  + last computed dp[i-1]
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);

            max = Math.max(dp[i], max);
        }

        return max;
    }

    //Almost solved it..faling few test cases
    //Using Kadane Algo.
    public int maxSubArray( int[] nums ) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
