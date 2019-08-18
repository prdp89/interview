package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

public class MaxConsecutiveOnesIII {

    //https://leetcode.com/problems/max-consecutive-ones-iii/
    public static void main( String[] args ) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        System.out.println(characterReplacement(arr, k));
    }

    private static int characterReplacement( int[] s, int k ) {
        int len = s.length;

        int start = 0, maxCount = 0, maxLength = 0;

        for (int end = 0; end < len; end++) {

            if (s[end] == 0) {
                maxCount++;
            }

            //checking if flipping max K zeros change the max-length
            while (maxCount > k) {

                //decrement zero's count from start; same as LongestRepeatingCharReplacement
                //we are in search of optimal sliding window
               if(s[start] == 0)
                   maxCount--;

                //slide the window from start to find max 1's
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
