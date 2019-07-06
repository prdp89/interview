package com.interview.codechef.ccdsap_2.leetcode.stack.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    //https://leetcode.com/problems/next-greater-element-i/
    public static void main( String[] args ) {

        int[] a = {4, 1, 2}, b = {4, 1, 2};

        System.out.println(Arrays.toString(nextGreaterElement(a, b)));
    }

    //ref: https://leetcode.com/problems/next-greater-element-i/discuss/97595/Java-10-lines-linear-time-complexity-O(n)-with-explanation

    private static int[] nextGreaterElement( int[] findNums, int[] nums ) {

        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x

        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {

            //In Map : We are storing for each num its next greater element
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);

            stack.push(num);
        }

        //finding from findNums item if element exist in Map; if true return element
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);

        return findNums;
    }
}
