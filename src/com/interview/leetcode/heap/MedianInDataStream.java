package com.interview.leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInDataStream {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    //https://leetcode.com/problems/find-median-from-data-stream/discuss/74047/JavaPython-two-heap-solution-O(log-n)-add-O(1)-find
    private MedianInDataStream() {

    }

    //https://leetcode.com/problems/find-median-from-data-stream/

    //Runtime: 54 ms, faster than 38.63% of Java
    public static void main( String[] args ) {
        MedianInDataStream medianInDataStream = new MedianInDataStream();
        medianInDataStream.addNum(2);
        medianInDataStream.addNum(3);
        medianInDataStream.addNum(4);

        System.out.println(medianInDataStream.findMedian());
    }

    private void addNum( int num ) {
        minHeap.offer(num);

        maxHeap.offer(minHeap.poll());

        if (minHeap.size() < maxHeap.size())
            minHeap.offer(maxHeap.poll());
    }

    //Min-Max heap size is equal : even number of total elements
    private double findMedian() {
        if (minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0;

        //odd number of elements
        return minHeap.peek();
    }
}
