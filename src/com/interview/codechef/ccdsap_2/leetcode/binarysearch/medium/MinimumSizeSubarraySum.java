package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

//https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {

    //THis question is a variation of Sliding Window Technique
    //Refer MinWindowSubString for this..
    public static void main( String[] args ) {
        int[] a = {2, 3, 1, 2, 4, 3};
        int target = 7; //possible are {1,2,4} & {4,3} but minimum length is 2.

        //System.out.println(minSubArrayLen(target, a));
        System.out.println(minSubArrayLen_BruteForce(target, a));
    }

    /*
    The only difference is in the way of finding the sum of subarrays:
     1. Create a vector sums of size of nums
     2. Initialize sums[0] = nums[0]
     3. Iterate over the sums vector:
        Update : sums[i] = sums[i−1] + nums[i]
     4. Sum of sub-array from i to j is calculated as: sum=sums[j] − sums[i] + nums[i],
        wherein sums[j] − sums[i] is the sum from (i + 1)th element to the jth element.
     */
    private static int minSubArrayLen_BruteForce( int s, int[] a ) {

        if (a == null || a.length == 0)
            return 0;

        int[] sums = new int[a.length];
        sums[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            sums[i] = sums[i - 1] + a[i];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {

            for (int j = i; j < a.length; j++) {

                int sum = sums[j] - sums[i] + a[i];
                if (sum >= s) {
                    ans = Math.min(ans, (j - i + 1));
                    break; //Found the smallest sub-array with sum>=s starting with index i, hence move to next index
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    //Time: O( N ) : Sliding Window Technique
    //compare this to https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
    private static int minSubArrayLen( int s, int[] a ) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {

            //adding current item to the sum
            sum += a[j++];

            //checking if sum is greater than target sum
            while (sum >= s) {
                //storing the index
                min = Math.min(min, j - i);

                //slide the window from Start and decrement the ith element
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}