package com.interview.hackerrank.recursion.advance;

public class GroupSum {

    public static void main( String[] args ) {
        System.out.println(groupSum(0, new int[]{2, 4, 8}, 8, ""));
    }

    private static boolean groupSum( int start, int[] nums, int target ) {

        if (start >= nums.length)
            return false;

        for (int i = start; i < nums.length; i++) {

            if (nums[i] + nums[start] == target)
                return true;

            groupSum(start + 1, nums, target);

            groupSum(start, nums, target);

        }

        return false;
    }

    /*

    //https://stackoverflow.com/questions/18029242/understanding-how-recursion-works-with-multiple-returns

    groupSum(0,[2,4,8],10)
    0 >= 3? no, so continue:

    groupSum(1,[2,4,8],10-2)?
     1 >= 3? no, so continue:

        groupSum(2,[2,4,8],8-4)?
          2 >= 3? no, so continue:
            groupSum(3,[2,4,8],4-8)?
                3 >= 3? yes. -4 == 0? no, return false
            groupSum(3,[2,4,8],4)?
                3 >= 3? yes. 4 == 0? no, return false
                return false

        groupSum(2,[2,4,8],8)?
            2 >= 3? no, so continue:

            groupSum(3,[2,4,8],8-8)?
                3 >= 3? yes. 0 == 0? yes, return true

                    yes, return true
                         yes, return true
                            yes, return true

     */

    private static boolean groupSum( int start, int[] nums, int target, String s ) {

        System.out.println(new String(new char[start]).
                replace("\0", "    ") + "start = " + start + " target = " + target + " parent = " + s);

        // Base case: if there are no numbers left, then there is a
        // solution only if target is 0.
        if (start >= nums.length)
            return (target == 0);

        // Key idea: nums[start] is chosen or it is not.
        // Deal with nums[start], letting recursion
        // deal with all the rest of the array.

        // Recursive call trying the case that nums[start] is chosen --
        // subtract it from target in the call.
        if (groupSum(start + 1, nums, target - nums[start], " A: " + start + " _ _ " + target))
            return true;

        // Recursive call trying the case that nums[start] is not chosen.
        if (groupSum(start + 1, nums, target, "B:" + start + "_" + target))
            return true;

        // If neither of the above worked, it's not possible.
        return false;
    }

}
