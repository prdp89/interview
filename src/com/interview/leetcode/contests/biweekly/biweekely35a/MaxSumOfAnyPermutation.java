package com.interview.leetcode.contests.biweekly.biweekely35a;

import java.util.Arrays;

public class MaxSumOfAnyPermutation {

    //https://leetcode.com/problems/sum-of-all-odd-length-subarrays/discuss/854400/Java-or-Sliding-Window
    //https://leetcode.com/contest/biweekly-contest-35/problems/maximum-sum-obtained-of-any-permutation/
    public static void main( String[] args ) {
        int[] nums = {1, 2, 3, 4, 5};
        int[][] requests = {{1, 3}, {0, 1}};

        System.out.println(maxSumRangeQuery(nums, requests));
    }

    /* Read Description carefully:
    We should put the largest number into the most queried position.

    We can count how many times each position was queried using another array cnt.
    To do so in O(n), we mark the start and end of each query with + 1 and - 1, and
    then calculate counts for each position in one swipe.

    Then, we can sort the input array and the count array, so that larger numbers and higher count are in the matching positions.

    Then, Just iterate over count and array and sum the products of the frequencies in sorted aux and elements in sorted arr.

     */

    //Runtime: 21 ms, faster than 50.00% of Java
    private static int maxSumRangeQuery( int[] nums, int[][] requests ) {
        int n = nums.length;
        int[] count = new int[n];

        for (int i = 0; i < requests.length; i++) {
            int[] curr = requests[i];

            int st = curr[0], end = curr[1];

            count[st]++;

            //To bring the range in [start, end]
            //in below loop count[end] will be max{count[end-1]} queried.
            if (end != n - 1)
                count[end + 1]--;
        }

        //calculating running sum or prefix sum of frequency
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            count[i] = sum;
        }

        //sort to match higher num at higher frequency
        Arrays.sort(nums);
        Arrays.sort(count);

        long ans = 0;
        int mod = (int) Math.pow(10, 9) + 7;

        for (int i = 0; i < n; i++) {
            //long temp = 1;
            ans = (ans + ((((long) count[i]) % mod) * nums[i]) % mod) % mod;
        }

        return (int) ans;
    }
}
