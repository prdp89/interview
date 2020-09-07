package com.interview.leetcode.contests._new_weekely.weekely204;

public class MaxLengthArrPosProd {

    //https://leetcode.com/contest/weekly-contest-204/problems/maximum-length-of-subarray-with-positive-product/
    public static void main( String[] args ) {
        int[] arr = {0, 1, -2, -3, -4};
        System.out.println(getMaxLen(arr));
    }

    //Runtime: 3 ms, faster than 80.00% of Java
    //nice video explanation: https://www.youtube.com/watch?v=vmY9ctncXQI&feature=youtu.be&t=1

    //If we want to get Max length of Array by Product of items then:
    // 1. If all values are +ve, ans is the size of array
    // 2. If count of -ve values are are even then ans is size of array as well. (if no zero value inside)
    // 3. If count of -ve values are ODD then:
    //    Eg: { 2, -2, 3, 6, 4, -7, -9, 2, 9, 9}
    //      a. option 1 : index : 0 -- 1 & 2 --- 5 elements can be taken
    //      b. option 2 : index : 2 -- 5 & 6 --- 9 elements can be taken
    //4. If array have zero elements then:
    //    Eg: { -2, 2, 0, 3, -3, -6, 0, 9, 8, -16}
    //      Max size of array : {0 -- 1, 3 -- 5, 7 -- 9} can be considered.
    //example :
    private static int getMaxLen( int[] nums ) {

        int len = nums.length, ans = 0;

        for (int start = 0; start < nums.length; ) {

            int tempStart = start;

            //filtering out the zero's, so a range can start with +ve or a -ve value
            while (tempStart < len && nums[tempStart] == 0)
                tempStart++;

            int end = tempStart;
            int negativeCount = 0, startNegative = -1, endNegative = -1;

            //similar to Sliding window, incrementing endIndex to find optimum array size
            while (end < len && nums[end] != 0) {
                if (nums[end] < 0) {
                    negativeCount++;

                    if (startNegative == -1)
                        startNegative = end;

                    endNegative = end;
                }

                end++;
            }

            //Case 2: Even -ve values
            if (negativeCount % 2 == 0)
                ans = Math.max(ans, end - tempStart);
            else {
                //Case 3 : option 2 {2 -- 5 & 6 --- 9 elements can be taken}
                if (startNegative != -1) {
                    ans = Math.max(ans, end - startNegative - 1);
                }

                //Case 3 : option 1 {0 -- 1 & 2 --- 5 elements can be taken}
                if (endNegative != -1) {
                    ans = Math.max(ans, endNegative - tempStart);
                }
            }

            start = end + 1;
        }

        return ans;
    }
}
