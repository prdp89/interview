package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

public class BinarySubarrayWithSum {

    //https://leetcode.com/problems/binary-subarrays-with-sum/
    public static void main( String[] args ) {
      /*  int[] arr = {1, 0, 1, 0, 1};
        int s = 2;*/

        int[] arr = {0, 0, 0, 0, 0};
        int s = 0;

        //solveTry(arr, s);
        solveTrySecond(arr, s);
    }

    //This logic is similar to SubArrayProductLessThanK
    //Runtime: 9 ms, faster than 54.83% of Java online submissions
    private static void solveTrySecond( int[] arr, int s ) {

        int start = 0, end = 0, count = 0, sum = 0;

        while (end < arr.length) {
            sum += arr[end];

            while (start < end && sum > s) {
                sum -= arr[start];
                start++;
            }

            //this count a subarray where sum==s {1, 0, 1, 0}
            if (sum == s)
                count++;

            //This count the sub-subarray when sum==s if subarray = {1, 0, 1, 0} then sub-subarray = {1, 0, 1}
            for (int i = start; sum == s && i < end && arr[i] == 0; i++)
                count++;

            end++;
        }

        System.out.println(count);
    }

    //Runtime: 1088 ms, faster than 5.09% of Java online submissions
    private static void solveTry( int[] arr, int s ) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == s)
                count++;

            int sum = 0;
            for (int j = i + 1; j < arr.length; j++) {

                sum += arr[j];
                if (arr[i] + sum == s)
                    count++;
            }
        }

        System.out.println(count);
    }


}
