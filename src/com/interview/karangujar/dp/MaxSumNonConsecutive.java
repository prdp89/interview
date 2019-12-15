package com.interview.karangujar.dp;

import java.util.Arrays;

public class MaxSumNonConsecutive {

    //https://medium.com/@karangujar43/tutorial-3-my-experiences-dynamic-programming-c711b9ff1071

    /*
    Given an array of integers(positive as well as negative) ,select some elements from this array(select a subset) such that:-
    Sum of those elements is maximum(Sum of the subset is maximum) .
    No 2 elements in the subset should be consecutive.

    Example :- {2,4,6,7,8}
    Answer:- {2+6+8=16}
     */
    public static void main( String[] args ) {
        /*int[] arr = {2, 4, 6, 7, 8};

        maxNonConsecutiveSingleArray(arr);*/

        int[] arr1 = {1, 5, 3, 21234};
        int[] arr2 = {-4509, 200, 3, 40};

        maxNonConsecutiveTwoArrays(arr1, arr2);
    }

    private static void maxNonConsecutiveSingleArray( int[] arr ) {
        int[] dp = new int[arr.length];

        //if there's only one element in array then max is that only
        dp[0] = arr[0];

        //if two element : max of both
        dp[1] = Math.max(arr[0], arr[1]);

        //if more than 2 then:
        for (int i = 2; i < arr.length; i++) {

            //either max is  : previous element computed
            //or max is : curr_array_element + non_consecutive_element
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }

        //answer is dp[arr.length -1]
        System.out.println(Arrays.toString(dp));
    }

    private static void maxNonConsecutiveTwoArrays( int[] arr, int[] arr1 ) {
        int[] dp = new int[arr.length];

        dp[0] = Math.max(arr[0], arr1[0]);
        dp[1] = Math.max(dp[0], Math.max(arr[1], arr1[1]));

        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(Math.max(arr[i], arr1[i]) + dp[i - 2],
                    dp[i - 1]);
        }

        //21434…..(verify this with equation…(1))
        //Voila, we did it !!!
        System.out.println(Arrays.toString(dp));
    }
}
