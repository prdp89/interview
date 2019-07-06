package com.interview.codechef.ccdsap_2.leetcode.stack.easy;

import java.util.Stack;

public class QueueUsingStacks {

    //https://leetcode.com/problems/implement-queue-using-stacks/
    Stack<Integer> stack;

    public QueueUsingStacks() {
        stack = new Stack<>();
    }

    //Below solution works fine, one more option using two stacks:
    //https://leetcode.com/problems/implement-queue-using-stacks/discuss/64206/Short-O(1)-amortized-C%2B%2B-Java-Ruby
    public static void main( String[] args ) {
        QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
        queueUsingStacks.push(1);
        queueUsingStacks.push(2);
        queueUsingStacks.push(3);

        System.out.println(queueUsingStacks.pop());
    }

    /**
     * Push element x to the back of queue.
     */
    public void push( int x ) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack.isEmpty()) {
            int num = stack.get(0);
            stack.remove(0);
            return num;
        }
        return -1;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack.isEmpty())
            return stack.get(0);

        return -1;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}
