package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

public class HouseRobber {

    //https://leetcode.com/problems/house-robber/#
    //Ref : https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.

    public static void main( String[] args ) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));

        System.out.println(robBottomUp(new int[]{2, 7, 9, 3, 1}));
    }

    private static int rob( int[] nums ) {
        return rob(nums, nums.length - 1);
    }

    private static int rob( int[] nums, int i ) {
        if (i < 0) {
            return 0;
        }

        return Math.max(

                rob(nums, i - 2) + nums[i] //checking if looting current house and next->next will work
                //or
                , rob(nums, i - 1));       //Looting of next house will work :)
    }

    //Really easy implementation...
    //https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.

    //yayy, solved it own too : Runtime: 0 ms, faster than 100.00% of Java
    private static int robBottomUp( int[] nums ) {

        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length + 1];

       /* dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];

            dp[i + 1] = Math.max(dp[i], val + dp[i - 1]);
        }

        return dp[nums.length];*/

        dp[0] = nums[0];

        if (nums.length < 2)
            return dp[0];

        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {

            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[nums.length - 1];

    }
}
