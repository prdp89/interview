package com.interview.codechef.ccdsap_2.leetcode.dp.newproblems;

public class MaxSubArraySumOneDeletion {

    //https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/

    //Read : MaxSumSubArray for easy understanding : https://leetcode.com/submissions/detail/288875284/
    public static void main( String[] args ) {

        System.out.println(maximumSum(new int[]{1, -2, 0, 3}));
    }

    /*
     arr = {1, -2, 0, 3}

     consider two elements in array = {1, -2}, we have two options:

     - We can delete and check : if we delete then we try add curr element with delete sum :
                                 oneDelete + arr[i] or
                                 by exclude curr element, by using noDelete sum :
                                 nodelete

     - We don't delete and check : if we don't delete we can include curr element with prev sum:
                                   noDelete + arr[i] or
                                   Just include the curr element : arr[i]
     */
    private static int maximumSum( int[] arr ) {
        int n = arr.length;

        int oneDelete = 0, noDelete = arr[0], max = arr[0];

        for (int i = 1; i < n; i++) {

            oneDelete = Math.max(oneDelete + arr[i], noDelete);

            //https://leetcode.com/submissions/detail/288875284/
            noDelete = Math.max(noDelete + arr[i], arr[i]); //same as MaxSumSubArray DP problem

            max = Math.max(max, Math.max(oneDelete, noDelete)); //just maintaining max of 2 states above
        }

        return max;
    }
}
