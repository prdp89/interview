package com.interview.stackqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Date 03/03/2016
 *
 * @author Tushar Roy
 * <p>
 * Find median in stream of numbers
 * <p>
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFinder {

    /*
    I keep two heaps (or priority queues):

    Max-heap small has the smaller half of the numbers.
    Min-heap large has the larger half of the numbers.

    This gives me direct access to the one or two middle values
    (they're the tops of the heaps), so getting the median takes O(1) time.
    And adding a number takes O(log n) time.
     */
    PriorityQueue<Integer> minPq = new PriorityQueue<>();
    PriorityQueue<Integer> maxPq = new PriorityQueue<>();

    public MedianFinder() {
        minPq = new PriorityQueue<>();

        //or for max heap : Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        maxPq = new PriorityQueue<>(20, Collections.reverseOrder());
    }

    public static void main( String args[] ) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(4);
        System.out.println(mf.findMedian());
        mf.addNum(8);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());

        /* mf.addNum(11);
        System.out.println(mf.findMedian());
        mf.addNum(13);
        System.out.println(mf.findMedian());
        mf.addNum(14);
        System.out.println(mf.findMedian());
        mf.addNum(-1);
        System.out.println(mf.findMedian());*/

    }

    // Adds a number into the data structure.
    public void addNum( int num ) {
        if (maxPq.size() == 0) {
            maxPq.add(num);
            return;
        }
        if (maxPq.size() == minPq.size()) {
            if (minPq.peek() < num) {
                maxPq.offer(minPq.poll());
                minPq.offer(num);
            } else {
                maxPq.offer(num);
            }
        } else {
            int toBeOffered = 0;
            if (num >= maxPq.peek()) {
                toBeOffered = num;
            } else {
                toBeOffered = maxPq.poll();
                maxPq.offer(num);
            }
            minPq.offer(toBeOffered);
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minPq.size() == maxPq.size()) {
            return ((double) minPq.peek() + (double) maxPq.peek()) / 2;
        } else {
            return maxPq.peek();
        }
    }
}
