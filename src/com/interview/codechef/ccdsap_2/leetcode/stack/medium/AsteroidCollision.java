package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    //https://leetcode.com/problems/asteroid-collision/
    public static void main( String[] args ) {
        int[] arr = {10, 2, -5};

        //System.out.println(Arrays.toString(solveTry(arr)));

        System.out.println(Arrays.toString(solveOPtimal(arr)));
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

    //Runtime: 5 ms, faster than 69.53% of Java online
    private static int[] solveOPtimal( int[] arr ) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > 0) {
                stack.push(arr[i]);
            } else {

                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(arr[i]))
                    stack.pop();

                if (stack.isEmpty() || stack.peek() < 0) //if the rightmost asteriod destroyed all..
                    stack.push(arr[i]);
                else if (stack.peek() == Math.abs(arr[i])) //if both asteroid are equal
                    stack.pop();
            }
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
    /*
     public int[] asteroidCollision(int[] a) {
        LinkedList<Integer> s = new LinkedList<>(); // use LinkedList to simulate stack so that we don't need to reverse at end.
        for (int i : a) {
            while (!s.isEmpty() && s.getLast() > 0 && s.getLast() < -i)
                s.pollLast();
            if (s.isEmpty() || i > 0 || s.getLast() < 0)
                s.add(i);
            else if (i < 0 && s.getLast() == -i)
                s.pollLast();
        }
        return s.stream().mapToInt(i->i).toArray();
    }
     */
}
