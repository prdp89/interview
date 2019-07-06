package com.interview.codechef.ccdsap_2.leetcode.stack.easy;

import java.util.Stack;

//https://leetcode.com/problems/min-stack
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void main( String[] args ) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public void push( int x ) {
        stack.push(x);

        if (minStack.isEmpty() || x <= getMin())
            minStack.push(x);
    }

    public void pop() {
        //if stack top is min. then element matched with min stack and need to be removed from minStack too
        if (stack.peek() == getMin())
            minStack.pop();

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
