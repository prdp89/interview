package com.interview.leetcode.contests.contest187;

public class KPlacesAway {

    public static void main( String[] args ) {
        int[] nums = {0,1,0,1};
        int k = 1;

        System.out.println(kLengthApart(nums, k));
    }

    private static boolean kLengthApart( int[] nums, int k ) {

        if (k <= 0 && nums.length > 0)
            return true;

        if (nums.length == 0 && k > 0)
            return false;

        int last1Index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 && last1Index != -1) {

                if (i - last1Index - 1 < k)
                    return false;
                else
                    last1Index = i;
            } else if (nums[i] == 1) {
                last1Index = i;
            }
        }

        return true;
    }
}
