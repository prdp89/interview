package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

public class WiggleSubsequence {

    //https://www.geeksforgeeks.org/longest-zig-zag-subsequence/
    //https://leetcode.com/problems/wiggle-subsequence/discuss/84849/Very-Simple-Java-Solution-with-detail-explanation

    public static void main( String[] args ) {

        System.out.println(wiggleMaxLength(new int[]{2, 1, 4, 5, 6, 3, 3, 4, 8, 4})); //op : 6 {2,1,6,3,8,4}

        System.out.println("Bottom up DP :" + bottomUPDP(new int[]{2, 1, 4, 5, 6, 3, 3, 4, 8, 4})); //op : 6 {2,1,6,3,8,4}

        //System.out.println(wiggleMaxLength(new int[]{10, 22, 9, 33, 49, 50, 31, 60})); //op : 6

        //System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8})); //op : 7 {1,17,10,13,10,16,8}
    }

    private static int wiggleMaxLength( int[] nums ) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int k = 0;
        while (k < nums.length - 1 && nums[k] == nums[k + 1]) {  //Skips all the same numbers from series beginning eg 5, 5, 5, 1
            k++;
        }
        if (k == nums.length - 1) {
            return 1;
        }
        int result = 2;     // This will track the result of result array
        boolean smallReq = nums[k] < nums[k + 1];       //To check series starting pattern
        for (int i = k + 1; i < nums.length - 1; i++) {
            if (smallReq && nums[i + 1] < nums[i]) {
                nums[result] = nums[i + 1];
                result++;
                smallReq = !smallReq;    //Toggle the requirement from small to big number
            } else {
                if (!smallReq && nums[i + 1] > nums[i]) {
                    nums[result] = nums[i + 1];
                    result++;
                    smallReq = !smallReq;    //Toggle the requirement from big to small number
                }
            }
        }
        return result;
    }

    //https://leetcode.com/articles/wiggle-subsequence/

    /*
    Any element in the array could correspond to only one of the three possible states:

    up position, it means nums[i] > nums[i-1]
    down position, it means nums[i] < nums[i-1]
    equals to position, nums[i] == nums[i-1]
    The updates are done as:

    If nums[i] > nums[i-1], that means it wiggles up.
    The element before it must be a down position. So up[i] = down[i-1] + 1

    If nums[i] < nums[i-1], that means it wiggles down.
    The element before it must be a up position. So down[i] = up[i-1] + 1
     */
    private static int bottomUPDP( int[] nums ) {
        if (nums.length < 2)
            return nums.length;

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        up[0] = down[0] = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }

        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
}
