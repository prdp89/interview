package com.interview.codechef.ccdsap_2.leetcode.stack.easy;

import java.util.Objects;
import java.util.Stack;

public class BaseBallGame {

    //https://leetcode.com/problems/baseball-game
    public static void main( String[] args ) {
        String[] str = {"5", "2", "C", "D", "+"};

        System.out.println(solveTry(str));
    }

    private static int solveTry( String[] str ) {
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        for (int i = 0; i < str.length; i++) {

            if (Objects.equals(str[i], "C")) {
                int val = stack.pop();
                sum -= val;
            } else if (Objects.equals(str[i], "D")) {
                int value = stack.peek() * 2;
                stack.push(value);

                sum += stack.peek();
            } else if (Objects.equals(str[i], "+")) {
                int sec = stack.peek();
                stack.pop();

                int fir = stack.peek();
                int cur = fir + sec;

                stack.push(sec);
                stack.push(cur);

                sum += cur;
            } else {
                int num = Integer.parseInt(str[i]);

                stack.push(num);

                sum += stack.peek();
            }
        }

        return sum;
    }
}
