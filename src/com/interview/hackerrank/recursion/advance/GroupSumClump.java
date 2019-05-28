package com.interview.hackerrank.recursion.advance;

public class GroupSumClump {

    //https://codingbat.com/prob/p105136
    public static void main( String[] args ) {
        System.out.println(groupSumClump(0, new int[]{2, 4, 4, 8}, 14));
    }

    private static boolean groupSumClump( int start, int[] nums, int target ) {

        if (start >= nums.length)
            return target == 0;

        int i = start;
        int sum = 0;

        while (i < nums.length && nums[start] == nums[i]) {
            sum += nums[i];
            i++;
        }

        /*if (start <= nums.length - 2 && nums[start] == nums[start + 1]) {

            for (int i = start + 1; i < nums.length; i++) {

                if (nums[i] == nums[i - 1])
                    groupSumClump(start + 1, nums, target - nums[i]);
            }
        }
*/
        //so we have to choose continuous 'i', next start is replaced with 'i'
        if (groupSumClump(i, nums, target - sum))
            return true;

        if (groupSumClump(i, nums, target))
            return true;

        return false;
    }
}
