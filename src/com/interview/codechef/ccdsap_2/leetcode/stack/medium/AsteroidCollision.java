package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    //https://leetcode.com/problems/asteroid-collision/
    public static void main( String[] args ) {
        int[] arr = {-2, -2, 1, -1}; //{10, 2, -5}; // {-2, -1, 1, 2};

        System.out.println(Arrays.toString(solveTry(arr)));
    }

    //passes 191/250 test cases.. :(
    private static int[] solveTry( int[] arr ) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (!stack.isEmpty() && arr[i] < 0) {
                int value = Math.abs(arr[i]);
                if (stack.peek() >= 0 && value >= stack.peek()) {

                    stack.pop();

                    if (!stack.isEmpty() && value > stack.peek())
                        stack.push(-value);

                } else if (stack.peek() < 0) {
                    stack.push(arr[i]);
                }
            } else
                stack.push(arr[i]);
        }

        if (stack.size() == 0)
            return new int[0];

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
