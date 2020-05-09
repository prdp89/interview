package com.interview.leetcode.contests.contest176;

import java.util.Collections;
import java.util.PriorityQueue;

public class ConstructTargetArray {

    //https://leetcode.com/contest/weekly-contest-176/problems/construct-target-array-with-multiple-sums/
    public static void main( String[] args ) {
        int[] target = {8, 5};

        System.out.println(isPossible(target));
    }

    //This guy using recursion to solve:
    //https://leetcode.com/problems/construct-target-array-with-multiple-sums/discuss/510317/Java-Think-the-problem-from-the-end-to-start.

    /*
    eg.1: [9,3,5] ->[1,3,5]->[1,3,1]->[1,1,1]

    [9,3,5]: max = 9, index = 0, subtract the other nums, 9-5-3=1 , 1>0, so we then change target[0] to 1.
    [1,3,5]: max = 5, index = 2, subtract the other nums, 5-1-3=1 , 1>0, so we then change target[2] to 1.
    [1,3,1]: max = 3, index = 1, subtract the other nums, 3-1-1=1 , 1>0, so we then change target[1] to 1.
    [1,1,1]: max = 1 ,then return true;
     */

    //46 / 68 test cases passed.
    //check this: little more and below code will work..
    //https://leetcode.com/problems/construct-target-array-with-multiple-sums/discuss/510256/JavaC%2B%2BPython-Backtrack-OJ-is-wrong
    private static boolean isPossible( int[] target ) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            sum += target[i];
            pq.offer(target[i]);
        }

        while (sum > target.length) {
            //find remaining elements sum excluding the top value.
            sum = sum - pq.peek();

            //storing remaining sum : Subtracting top element out of remaining elements sum.
            pq.offer(Math.abs(pq.poll() - sum));

            //some error is here..
            sum++;

            if (sum == target.length)
                return true;
        }

        return false;
    }
}
