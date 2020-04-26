package com.interview.leetcode.thirtydayschallenge;

public class JumpGame {

    //https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3310/
    public static void main( String[] args ) {
        //  int[] arr = {3, 2, 1, 0, 4};
        int[] arr = {2, 3, 1, 1, 4};

        System.out.println(canJump(arr));
    }

    private static boolean canJump( int[] nums ) {

        int dis = 0;
        for (int i = 0; i <= dis; i++) {

            dis = Math.max(dis, i + nums[i]);

            if (dis >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
