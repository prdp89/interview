package com.interview.codechef.ccdsap_2.atcoder.educationalDPContest;

import java.util.Arrays;

public class MaxSumSubset {

    //https://medium.com/@karangujar43/tutorial-2-my-experiences-dynamic-programming-7254e35cec1a

    /*
    Problem-2:- Understanding this problem and its solution properly will make a strong foundation for you in the DP world .(This worked for me :-) )
    Here we go- Given an array of integers(positive as well as negative)
                ,select some elements from this array(select a subset) such that:-
    Sum of those elements is maximum(Sum of the subset is maximum) .
    No 2 elements in the subset should be consecutive.

    Example :- {2,4,6,7,8}
    Answer:- {2+6+8=16}
     */
    public static void main( String[] args ) {

        int i = 2;
        int arr[] = {2, 4, 6, 7, 8};

        int dp[] = new int[arr.length];

        Arrays.fill(dp, -1);

        dp[0] = arr[0];
        dp[1] = arr[1];

        while (i < arr.length) {
            dp[i] = Math.max(arr[i] + dp[i - 2]
                    , dp[i - 1]);
            i++;
        }

        System.out.println(dp[arr.length - 1]);

    }
}
