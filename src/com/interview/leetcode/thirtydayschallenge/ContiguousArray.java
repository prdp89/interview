package com.interview.leetcode.thirtydayschallenge;

import java.util.HashMap;

public class ContiguousArray {

    //https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
    public static void main( String[] args ) {
        int[] arr = {0, 1, 0};
        System.out.println(findMaxLength(arr));
    }

    private static int findMaxLength( int[] nums ) {

        int count = 0, sum = 0;

        //Map<SUM, Index>
        HashMap<Integer, Integer> map = new HashMap<>();

        //set initial sum to zero and index to -1
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            //modelling the Num[i], if:
            //Num[i] == 1 ? 1 : -1

            sum += nums[i] == 1 ? 1 : -1;

            //if we found that sum again means from Prev --- Curr position have equal number of zeros and ones
            //so, we are storing max subArray length between 2 indices
            if (map.containsKey(sum)) {
                count = Math.max(count, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return count;
    }
}
