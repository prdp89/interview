package com.interview.leetcode.Arrays.prefix;

public class NumberOfSubArraysOddSum {

    //https://leetcode.com/contest/biweekly-contest-31/problems/number-of-sub-arrays-with-odd-sum/
    public static void main( String[] args ) {
        int[] arr = {1, 3, 5};

        System.out.println(pro(arr));

        System.out.println(numOfSubarrays(arr));
    }

    //https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/discuss/754677/Java-O(n)-time-O(1)-space-with-detailed-explanation
    private static int numOfSubarrays( int[] arr ) {
        int c1 = 0, c2 = 1, n = arr.length;
        int currSum = 0;

        long ans = 0;
        int mod = (int) Math.pow(10, 9) + 7;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            if (currSum % 2 == 0) {
                ans = (ans + c1) % mod;
                c2++;
            } else {
                ans = (ans + c2) % mod;
                c1++;
            }
        }

        return (int) ans;
    }

    private static int pro( int[] nums ) {
        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];

        dp[0] = nums[0] % 2 == 0 ? 0 : 1;

        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                dp[i] += 1;
            }

            sum += nums[i];
            if (sum % 2 != 0)
                dp[i] += dp[i - 1];
        }

        return dp[nums.length - 1];
    }
}
