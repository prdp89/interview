package com.interview.leetcode.contests.contest187;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestArrayWithSumAtleastK {

    //https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
    //https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C%2B%2BJavaPython-O(N)-Using-Deque
    public static void main( String[] args ) {
        int[] arr = {2, -1, 2};
        int k = 3;

        System.out.println(shortestSubarray(arr, k));
    }

    private static int shortestSubarray( int[] A, int K ) {

        int n = A.length, min = Integer.MAX_VALUE;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = A[i] + prefix[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n + 1; i++) {

            //We want know if there is a subarray, which starts from an index, ends at A[i-1] and has at least sum K.
            while (deque.size() > 0 && prefix[i] - prefix[deque.getFirst()] >= K)
                min = Math.min(min, i - deque.pollFirst());

            //this logic is similar to NextGreaterElement of Stack
            while (deque.size() > 0 && prefix[i] <= prefix[deque.getLast()])
                deque.pollLast();

            deque.addLast(i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
