package com.interview.leetcode.contests.contest186;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaximumPoints {

    //https://leetcode.com/contest/weekly-contest-186/problems/maximum-points-you-can-obtain-from-cards/
    public static void main( String[] args ) {

        int[] arrr = {11, 49, 100, 20, 86, 29, 72};
        int k = 4; //op = 232


        //System.out.println("wrong:" + maxScore(arrr, k));

        System.out.println(maxScoreOptimal(arrr, k));
    }

    //16 / 40 test cases passed.
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
        }
        return sum;
    }


    //arr = {11, 49, 100, 20, 86, 29, 72}
    //k = 4
    /*
    leftSum = {0, 11, 60, 160, 180}
    rightSum = {0, 72, 101, 187, 207}

    Iteration:
    i=0:{0, 207} - 207
    i=1:{11,187} - 197
    i=2:{60, 101} - 161
    i=3:{160, 72} - 232
    i=4:{180, 0} - 180

    Max = 232
     */

    /*
    Key idea: You can’t choose 2nd element from the beginning unless you have chosen the first one.
    Similarly, you can’t choose 2nd element from last unless you have chosen the last one.

    So now just try all possible combinations. Choose 0 from the beginning and K from the last,
    1 from front and K-1 from last and so on until K from beginning and 0 from behind.
    Maximum out of all those combinations is the answer. {This line is important}

    To make it faster to find sum of first i cards,
    store the cumulative sum from the beginning to current index i in an array.

    In the similar way, store cumulative sums from the back in separate array.
     */

    //Runtime: 58 ms, faster than 75.00% of Java
    private static int maxScoreOptimal( int[] cardPoints, int k ) {
        Map<Integer, Integer> leftSum = new HashMap<>();
        leftSum.put(0, 0);

        for (int i = 0; i < k; i++) {
            leftSum.put(i + 1, cardPoints[i] + leftSum.get(i));
        }

        Map<Integer, Integer> rightSum = new HashMap<>();
        rightSum.put(0, 0);

        for (int i = 0; i < k; i++) {
            rightSum.put(i + 1, cardPoints[cardPoints.length - 1 - i] + rightSum.get(i));
        }

        int sum = 0;
        for (int i : leftSum.keySet()) {

            int left = leftSum.get(i);
            int right = rightSum.getOrDefault(k - i, 0);

            sum = Math.max(sum, left + right);
        }

        return sum;
    }
}
