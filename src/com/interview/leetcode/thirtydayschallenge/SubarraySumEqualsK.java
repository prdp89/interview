package com.interview.leetcode.thirtydayschallenge;

import java.util.HashMap;

public class SubarraySumEqualsK {

    //https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/
    public static void main( String[] args ) {
        int[] arr = {3, 4, 7, -2, 2, 1, 4, 2};
        int k = 7;

        //System.out.println(subarraySum(arr, k));

        System.out.println(subarraySumDP(arr, k));
    }

    //Suppose arr = {3, 4, 7, -2,  2,  1,  4,   2}, k = 7
    //      Prefix= {3, 7, 14, 12, 14, 15, 19,  21}

    /*
    Map should look like:
    (3,1), (7,1), (14,2) , (12,1) , (15,1) , (19,1) , (21,1)
     */


    private static int subarraySumDP( int[] nums, int k ) {

        if (nums.length == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, totalCount = 0;

        //instead of this if (sum == k) condition we can use:
        //map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k)
                totalCount++;

            if (map.containsKey(sum - k))
                totalCount += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return totalCount;
    }

    //passing 25/90 test cases
    private static int subarraySum( int[] nums, int k ) {
        int count = 0;

        int start = -1, end = 0, sum = 0;
        while (end < nums.length) {

            sum += nums[end];

            if (sum == k)
                count++;

            if (sum > k) {
                while (sum > k && ++start != end) {
                    sum -= nums[start];

                    if (sum == k)
                        count++;
                }
            }

            end += 1;
        }

        return count;
    }
}
