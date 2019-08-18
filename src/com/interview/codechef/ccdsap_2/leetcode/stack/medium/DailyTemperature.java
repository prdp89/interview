package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class DailyTemperature {

    //https://leetcode.com/problems/daily-temperatures/

    //This question is similar to codechef.ccdsap_2.leetcode.stack.easy -> NextGreaterElement
    public static void main( String[] args ) {
        // int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] arr = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};

        System.out.println(Arrays.toString(solveTry(arr)));
    }

    //solved and passed all test cases.
    private static int[] solveTry( int[] arr ) {

        Stack<Pair> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] op = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && stack.peek().value < arr[i]) {
                Pair pair = stack.pop();
                map.put(pair.index, i - pair.index);
            }

            stack.push(new Pair(i, arr[i]));
        }

        for (int i = 0; i < arr.length - 1; i++) {
            op[i] = map.getOrDefault(i, 0);
            //map.remove(arr[i]);
        }

        op[arr.length - 1] = 0;

        return op;
    }

    //ANother way to solve : similar to MaximumHistogram
    public int[] dailyTemperatures( int[] temperatures ) {
        Stack<Integer> stack = new Stack<>();

        int[] ret = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            //Instead of Hashmap : comparing stack.peek() index of temperature array.
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                int idx = stack.pop();

                ret[idx] = i - idx;
            }
            stack.push(i);
        }

        return ret;
    }

    static class Pair {
        int index;
        int value;

        Pair( int index, int value ) {
            this.index = index;
            this.value = value;
        }
    }
}
