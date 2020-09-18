package com.interview.codechef.ccdsapfoundation_1.sorting;

import java.util.Arrays;

public class SortColors {

    //https://leetcode.com/problems/sort-colors/
    public static void main( String[] args ) {
        Integer[] num = {2, 0, 2, 1, 1, 0};
        sortColors(num);
        System.out.println(Arrays.toString(num));
    }

    //The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.
    private static void sortColors( Integer[] nums ) {
        int pivot0 = 0;
        int pivot2 = nums.length - 1;

        for (int i = 0; i <= pivot2; ) {
            if (nums[i] == 2) { //swap 2 to the end, and then pivot2--
                int temp = nums[pivot2];
                nums[pivot2] = 2;
                nums[i] = temp;
                pivot2--;
            } //0 from the end may swap to nums[i], therefore we should check 2 first then 0
            if (nums[i] == 0) { //swap 0 to the head, and then pivot0++
                int temp = nums[pivot0];
                nums[pivot0] = 0;
                nums[i] = temp;
                pivot0++;
                i++;
            } else if (nums[i] == 1) i++;
        }
    }
}
