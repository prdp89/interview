package com.interview.leetcode.dp.lis;

public class PickElementsInRange {

    //https://leetcode.com/discuss/interview-question/804325/hyperverge-sde-online-test-question

    /*
    Given an array of integers A of size N and an integer B.
    You have to pick some elements from the array A while picking you have to follow the given conditions:
    1. The first element to be picked should be A[1]
    2. The last element to be picked should be A[n]
    3. If you pick some element A[j] after A[i], then it should follow the constraints j-i >= B, j-i <= 2*B

    Return the maximum sum of all picked elements.
    Note: Array A has 1-based indexing.

    Constraints:
    1 ≤ N ≤ 10^5
    1 ≤ A[I] ≤ 10^5
    1 ≤  B ≤ N

    Example:
    A = [7, 9, 3, 8, 11, 10] , B = 2
    Output: 25
    Explanation: You pick {7, 8, 10}

    A = [5, 4, 3, 2, 1], B = 1
    Output: 15
    Explanation: You pick all elements
     */
    public static void main( String[] args ) {
        int[] arr = {7, 9, 3, 8, 11, 10};
        int b = 2;

        using2DDP(arr, b);
    }

    private static void using2DDP( int[] arr, int b ) {
        int[] dp = new int[arr.length];

        dp[0] = arr[0]; //The first element to be picked should be A[1] {1 based indexing}

        for (int i = 1; i < arr.length; i++) {

            for (int j = Math.max(i - 2 * b, 0); j <= i - b; j++)
                dp[i] = Math.max(dp[i], arr[i] + dp[j]);
        }

        System.out.println(dp[arr.length - 1]);
    }
}
