package com.interview.hackerrank.recursion.advance;

public class GroupNoAdj {

    //https://codingbat.com/prob/p169605
    public static void main( String[] args ) {
        System.out.println(groupNoAdj(0, new int[]{2, 5, 10, 4}, 12));
    }

    private static boolean groupNoAdj( int start, int[] nums, int target ) {

        if (start >= nums.length)
            return target == 0;

        //if start+2 choosen to be in group; then start+1 should not be choosen
        if (groupNoAdj(start + 2, nums, target - nums[start]))
            return true;

        //here : we are not choosing start + 1
        if (groupNoAdj(start + 1, nums, target))
            return true;

        return false;
    }
}
