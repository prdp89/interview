package com.interview.array;
/**
 * https://leetcode.com/problems/first-missing-positive/
 */
public class FirstPositiveMissing {
    public int firstMissingPositive(int[] nums) {
        int startOfPositive = segregate(nums);
        for (int i = startOfPositive; i < nums.length; i++) {
            int index = Math.abs(nums[i]) + startOfPositive - 1;
            if (index < nums.length) {
                nums[index] = -Math.abs(nums[index]);
            }
        }
        for (int i = startOfPositive; i < nums.length; i++) {
            if (nums[i] > 0) {
                //plus 1 is done since array starts from 0 and Minus startPositive will give correct index of start.
                return i - startOfPositive + 1;
            }
        }
        //this means number at last index
        return nums.length - startOfPositive + 1;
    }

    private int segregate(int[] nums) {
        int start = 0;
        int end = nums.length -1 ;
        while (start <= end) {
            if (nums[start] <= 0) {
                start++;
            } else if (nums[end] > 0) {
                end--;
            } else {
                swap(nums, start, end);
            }
        }
        return start;
    }

    private void swap(int[] nums, int start, int end) {
        int t = nums[start];
        nums[start] = nums[end];
        nums[end] = t;
    }

    public static void main( String[] args ) {
        FirstPositiveMissing firstPositiveMissing = new FirstPositiveMissing();
        //System.out.println(firstPositiveMissing.firstMissingPositive(new int[]{1,2,0}));

        System.out.println(firstPositiveMissing.firstMissingPositive(new int[]{ 2, 3, 7, 6, 8, -1, -10, 15}));

    }
}


