package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class MaxSumSelected {

    //https://www.geeksforgeeks.org/maximize-sum-selected-numbers-performing-following-operation/
    //https://codeforces.com/problemset/problem/455/A
    public static void main( String[] args ) {
        int[] arr = new int[]{1, 2, 2, 2, 3, 4};

        int[] ans = new int[5];
        int max = 0;

        for (int anArr : arr) {
            ans[anArr]++;
            max = Math.max(max, anArr);
        }

        //why max : bcz ans array contains max values only.
        System.out.println(recurse(ans, max));
    }

    private static int recurse( int[] arr, int index ) {

        //bcz index 0 contains nothing
        if (index == 0) return 0;

        //index 1 contain repetition of 1's
        if (index == 1) return arr[1];

        //exclude and recurse : recurse(arr, index - 1)
        //include : (arr[index] * index) : if 2 is selected it is 2 * 3 {occurance of 2's}
                   //and recur to 2 + 2 : 4 bcz 3 got deleted from array.
        return Math.max(recurse(arr, index - 1)
                , (arr[index] * index) + recurse(arr, index - 2));
    }
}
