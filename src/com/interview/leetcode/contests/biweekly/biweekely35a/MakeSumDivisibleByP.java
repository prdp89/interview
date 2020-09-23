package com.interview.leetcode.contests.biweekly.biweekely35a;

import java.util.HashMap;

public class MakeSumDivisibleByP {

    //https://leetcode.com/problems/make-sum-divisible-by-p/
    public static void main( String[] args ) {
        int[] nums = {3, 1, 4, 2};
        int p = 6;

        System.out.println(minSubarray(nums, p));
    }

    //https://leetcode.com/problems/make-sum-divisible-by-p/discuss/854166/JavaPython-3-O(n)-code-w-brief-explanation-analysis-and-similar-problems.
    private static int minSubarray( int[] nums, int p ) {
        int remainder = 0, prefixSum = 0;
        int n = nums.length, minLen = n;

        for (int num : nums) {
            remainder = (remainder + num) % p;
        }

        if (remainder == 0) {
            return 0;
        }

        //remainder  = 10 % 6 = 4
        HashMap<Integer, Integer> prefixSumToIndex = new HashMap<Integer, Integer>();
        prefixSumToIndex.put(prefixSum, -1);

        for (int i = 0; i < n; ++i) {
            prefixSum = (prefixSum + nums[i]) % p;

            int key = (prefixSum - remainder + p) % p;

            if (prefixSumToIndex.containsKey(key)) {
                minLen = Math.min(minLen, i - prefixSumToIndex.get(key));
            }

            prefixSumToIndex.put(prefixSum, i);
        }
        return minLen == n ? -1 : minLen;
    }
}
