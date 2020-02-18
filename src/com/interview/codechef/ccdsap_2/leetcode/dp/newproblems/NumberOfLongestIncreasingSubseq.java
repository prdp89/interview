package com.interview.codechef.ccdsap_2.leetcode.dp.newproblems;

public class NumberOfLongestIncreasingSubseq {

    //This problem is an extension of : LongestIncreasingSubseq

    //https://leetcode.com/problems/number-of-longest-increasing-subsequence/
    public static void main( String[] args ) {
        int[] arr = {1, 3, 5, 4, 7};

        System.out.println(findNumberOfLIS(arr));
    }

    /*
    For a sequence of numbers,
    1. cnt[k] is total number of longest subsequence ending with nums[k];
    2. dp[k] is the length of longest subsequence ending with nums[k]; //this is same as : LongestIncreasingSubseq
     */

    private static int findNumberOfLIS( int[] nums ) {
        int n = nums.length, max_len = 0, ans = 0;

        int[] dp = new int[n], cnt = new int[n];

        for (int i = 0; i < n; i++) {

            //set both to 1 initially
            dp[i] = cnt[i] = 1;

            //loop same as LongestIncreasingSubseq
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    //Consider we are checking LIS from i...j
                    //If LIS of dp[i] is same as previous computed : 1 + dp[j]
                    if (dp[i] == 1 + dp[j]) //why +1 : bcz in LIS if nums[i] > nums[j] then we do dp[i] = 1 + dp[j]
                        cnt[i] += cnt[j]; //count we prev + curr bcz LIS length is same..

                    //If current dp[i] is less than dp[j] : means we have found greater length LIS
                    if (dp[i] < 1 + dp[j]) {
                        dp[i] = 1 + dp[j]; //updating the last LIS
                        cnt[i] = cnt[j]; //update the count with a new one
                    }
                }
            }

            //max_len = maintaining max_len for each count of ith length LIS
            max_len = Math.max(max_len, dp[i]);
        }

        //counting how many of max_len LIS are present..
        for (int i = 0; i < n; i++) {
            if (dp[i] == max_len)
                ans += cnt[i];
        }

        return ans;
    }
}
