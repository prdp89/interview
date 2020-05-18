package com.interview.leetcode.stacks;

import java.util.Stack;

public class TrappingRainWater {

    //https://leetcode.com/problems/trapping-rain-water/
    public static void main( String[] args ) {
        int[] towers = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trap(towers));
    }

    //First read MaximumHistogram to understand it better..
    //Runtime: 3 ms, faster than 15.04% of Java
    private static int trap( int[] height ) {

        if (height.length < 2)
            return 0;

        Stack<Integer> stack = new Stack<>();

        int water = 0, i = 0;
        while (i < height.length) {

            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int pre = stack.pop();

                //it means stack size should be 3, to calc water between Towers
                //eg: water cannot store between {0,1}
                //    but {1, 0, 2} can have 1 unit of water storage..
                if (!stack.isEmpty()) {
                    //find smaller bw two Towers
                    int minHeight = Math.min(height[stack.peek()], height[i]);

                    //This logic similar to MaximumHistogram
                    //Area : Length * Breadth
                    water += (minHeight - height[pre]) * (i - stack.peek() - 1);
                }
            }
        }

        return water;
    }
}
