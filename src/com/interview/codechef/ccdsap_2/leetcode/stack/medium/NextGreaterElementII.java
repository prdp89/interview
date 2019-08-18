package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    //https://leetcode.com/problems/next-greater-element-ii/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 1}; //op = {2, -1, 2}

        System.out.println(Arrays.toString(solveTry(arr)));
    }

    //logic is similar to ccdsap_2.leetcode.stack.medium -> DailyTemperature

    //Loop once, we can get the Next Greater Number of a normal array.
    //Loop twice, we can get the Next Greater Number of a circular array

    //i%n = for getting circular element index when i > n
    private static int[] solveTry( int[] arr ) {

        Stack<Integer> stack = new Stack<>();
        int out[] = new int[arr.length];

        Arrays.fill(out, -1);

        for (int i = 0; i < arr.length * 2; i++) {

            while (!stack.isEmpty() && arr[i % arr.length] > arr[stack.peek()]) {
                int lastElement = stack.pop();
                out[lastElement] = arr[i % arr.length];
            }

            //push circular array element
            stack.push(i % arr.length);
        }

        return out;
    }
}
