package com.interview.codechef.ccdsap_2.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageSum {

    private Queue<Integer> queue;
    private Double sum;
    private int size;

    private MovingAverageSum( int size ) {
        this.size = size;
        this.sum = 0.0;
        this.queue = new LinkedList<>();
    }

    //https://www.youtube.com/watch?v=E-kjYOZEBxY
    public static void main( String[] args ) {
        MovingAverageSum movingAverageSum = new MovingAverageSum(3);
        movingAverageSum.next(1);
        movingAverageSum.next(2);
        movingAverageSum.next(3);

        System.out.println(movingAverageSum.next(4)); //op : 9 / 3 = 3 => last 3 num sum { 2, 3 ,4}
    }

    public double next( int val ) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }

        queue.offer(val);
        sum += val;

        return sum / queue.size();
    }
}
