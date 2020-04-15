package com.interview.codechef.ccdsap_2.leetcode.design;

//TODO: GO through THis : https://github.com/donnemartin/system-design-primer

public class CircularDequeue {

    private int front = 0, rear = -1, len = 0, k = 0;
    private int[] arr;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    private CircularDequeue( int k ) {
        arr = new int[k];
        this.k = k;
    }

    //https://leetcode.com/problems/design-circular-deque/
    public static void main( String[] args ) {
        CircularDequeue obj = new CircularDequeue(3);
        boolean param_1 = obj.insertFront(1);
        boolean param_2 = obj.insertLast(2);
        boolean param_3 = obj.deleteFront();
        boolean param_4 = obj.deleteLast();
        int param_5 = obj.getFront();
        int param_6 = obj.getRear();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront( int value ) {
        if (isFull()) return false;
        front = --front % k;
        if (front < 0) front += k;
        arr[front] = value;
        len++;
        if (len == 1) rear = front;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast( int value ) {
        if (isFull()) return false;
        rear = ++rear % k;
        arr[rear] = value;
        len++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = ++front % k;
        len--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = --rear % k;
        if (rear < 0) rear += k;
        len--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return isEmpty() ? -1 : arr[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return isEmpty() ? -1 : arr[rear];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return len == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return len == k;
    }
}
