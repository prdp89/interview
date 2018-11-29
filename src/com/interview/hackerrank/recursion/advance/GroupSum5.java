package com.interview.hackerrank.recursion.advance;

public class GroupSum5 {

    //https://codingbat.com/prob/p138907
    public static void main( String[] args ) {
        //System.out.println(groupSum5(0, new int[]{2, 5, 10, 4}, 19));

        System.out.println(groupSum6(0, new int[]{5, 6, 2}, 8));
    }

    private static boolean groupSum5( int start, int[] nums, int target ) {

        // Base case: if there are no numbers left, then there is a
        // solution only if target is 0.
        if (start >= nums.length)
            return target == 0;

        //give priority to 5, check if element divisible by 5
        if (nums[start] % 5 == 0) {
            //to check if last element is 1
            if (start <= nums.length - 2 && nums[start + 1] == 1)
                return groupSum5(start + 2, nums, target - nums[start]);

            //otherwise include the element that divide by 5.
            return groupSum5(start + 1, nums, target - nums[start]);
        }

        //include the element that doesn't divide by 5.
        if (groupSum5(start + 1, nums, target - nums[start]))
            return true;

        //exclude the element to check if it sum to the target.
        if (groupSum5(start + 1, nums, target))
            return true;

        return false;
    }


    //https://codingbat.com/prob/p199368
    private static boolean groupSum6( int start, int[] nums, int target ) {

        // Base case: if there are no numbers left, then there is a
        // solution only if target is 0.
        if (start >= nums.length)
            return target == 0;

        //give priority to 5, check if element divisible by 5
        if (nums[start] % 6 == 0) {

            //otherwise include the element that divide by 5.
            return groupSum6(start + 1, nums, target - nums[start]);
        }

        //include the element that doesn't divide by 5.
        if (groupSum6(start + 1, nums, target - nums[start]))
            return true;

        //exclude the element to check if it sum to the target.
        if (groupSum6(start + 1, nums, target))
            return true;

        return false;
    }
}
