package com.interview.array;

/**
 * References
 * https://oj.leetcode.com/problems/trapping-rain-water/
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingWater {

    public static void main( String args[] ) {
        int input[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingWater tw = new TrappingWater();
        System.out.println(tw.trap(input));
    }

    private int trap( int[] height ) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int left[] = new int[len];
        int right[] = new int[len];
        left[0] = height[0];
        right[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
            right[len - i - 1] = Math.max(height[len - i - 1], right[len - i]);
        }

        int maxWaterTrapped = 0;
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(left[i], right[i]);
            if (height[i] < min) {
                maxWaterTrapped += min - height[i];
            }
        }
        return maxWaterTrapped;
    }

    //https://leetcode.com/problems/trapping-rain-water/discuss/17527/My-Accepted-Java-Solution
    public int trapWater( int[] height ) {
        if (height.length <= 2) return 0;

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < height.length; i++) {

            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        int leftMax = height[0];
        int water = 0;
        for (int i = 1; i < maxIndex; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            } else {
                water += leftMax - height[i];
            }
        }

        int rightMax = height[height.length - 1];
        for (int i = height.length - 2; i > maxIndex; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            } else {
                water += rightMax - height[i];
            }
        }

        return water;
    }
}
