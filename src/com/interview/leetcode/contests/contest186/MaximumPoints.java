package com.interview.leetcode.contests.contest186;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumPoints {

    //https://leetcode.com/contest/weekly-contest-186/problems/maximum-points-you-can-obtain-from-cards/
    public static void main( String[] args ) {

        int[] arrr = {1, 79, 80, 1, 1, 1, 200, 1};
        int k = 3;


        System.out.println(maxScore(arrr, k));
    }

    private static int maxScore( int[] cardPoints, int k ) {
        int sum = 0;

        if (k == cardPoints.length) {
            for (int i = 0; i < cardPoints.length; i++) {
                sum += cardPoints[i];
            }
            return sum;
        }

        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < cardPoints.length; i++) {
            deque.offer(cardPoints[i]);
        }

        while (k-- > 0) {
            if (deque.getFirst() > deque.getLast()) {
                sum += deque.pollFirst();
            } else {
                sum += deque.pollLast();
            }

            //sum += deque.getFirst() > deque.getLast() ? deque.pollFirst() : deque.pollLast();
        }
        return sum;
    }
}
