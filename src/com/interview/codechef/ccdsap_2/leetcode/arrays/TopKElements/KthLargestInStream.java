package com.interview.codechef.ccdsap_2.leetcode.arrays.TopKElements;

import java.util.PriorityQueue;

public class KthLargestInStream {

    //https://leetcode.com/problems/kth-largest-element-in-a-stream/

    private final PriorityQueue<Integer> q;
    private final int k;

    private KthLargestInStream( int k, int[] nums ) {
        this.k = k;

        //initialize Min-Heap of k size only
        q = new PriorityQueue<>(k);
        for (int a : nums) {
            add(a);
        }
    }

    public static void main( String[] args ) {
        int[] arr = {4, 5, 8, 2};
        int k = 3;

        KthLargestInStream kthLargestInStream = new KthLargestInStream(k, arr);

        System.out.println(kthLargestInStream.add(6));
    }

    //Time complexity of finding the k’th largest element is O(Log k)
    public int add( int val ) {
        q.offer(val);

        //K helps to maintain top k elements in PQ; smallest will be removed
        if (q.size() > k) {

            //poll remove top smallest element in PQ
            q.poll();
        }

        //it return top element of PQ
        return q.peek();
    }
}
