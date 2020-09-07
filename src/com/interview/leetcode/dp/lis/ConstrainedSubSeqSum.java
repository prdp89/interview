package com.interview.leetcode.dp.lis;

import java.util.Deque;
import java.util.LinkedList;

public class ConstrainedSubSeqSum {

    //https://leetcode.com/problems/constrained-subsequence-sum/

    //https://leetcode.com/problems/constrained-subsequence-sum/discuss/605822/Java-Decreasing-Monotonic-Queue-Clean-code-O(N)
    public static void main( String[] args ) {
        int[] arr = {10, 2, -10, 5, 20};
        int k = 2;

        System.out.println(constrainedSubsetSum_2D_DP(arr, k));

        System.out.println(constrainedSubsetSum_2D_DP_MONOTONIC(arr, k));
    }

    //This is based on LIS pattern
    private static int constrainedSubsetSum_2D_DP( int[] arr, int k ) {
        int n = arr.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int max = 0;

            for (int j = Math.max(i - k, 0); j < i; j++) { // choose the max element in latest k elements, it's in range [i-k, i-1]
                max = Math.max(max, dp[j]);
            }

            dp[i] = arr[i] + max;
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static int constrainedSubsetSum_2D_DP_MONOTONIC( int[] arr, int k ) {
        int n = arr.length;
        int[] dp = new int[n];

        Deque<Integer> deque = new LinkedList<>();
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int max = Math.max(0, deque.isEmpty() ? 0 : dp[deque.peekFirst()]);

            dp[i] = arr[i] + max;

            ans = Math.max(ans, dp[i]);

            //can relate to monotonic increasing stack
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) { // If dp[i] >= deque.peekLast() -> Can discard the tail since it's useless
                deque.pollLast();
            }

            deque.addLast(i);

            if (i - deque.peekFirst() + 1 > k) { // remove the last element of range k
                deque.removeFirst();
            }
        }

        return ans;
    }
}
