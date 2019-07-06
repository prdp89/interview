package com.interview.codechef.ccdsap_2.leetcode.stack.easy;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    //https://leetcode.com/problems/implement-stack-using-queues
    private Queue<Integer> queue;

    private StackUsingQueues() {
        queue = new LinkedList<>();
    }

    public static void main( String[] args ) {
        StackUsingQueues stackUsingQueues = new StackUsingQueues();
        stackUsingQueues.push(1);
        stackUsingQueues.push(2);
        stackUsingQueues.push(3);

        System.out.println(stackUsingQueues.pop()); //3 will be popped out
    }

    /**
     * Push element x onto stack.
     */
    public void push( int x ) {
        //this item will be on top of stack after the below loop
        queue.add(x);

        //running one less to prevent last item being removed
        for (int i = 1; i < queue.size(); i++) {
            int n = queue.remove();
            queue.add(n);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
