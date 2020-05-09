package com.interview.leetcode.contests.biweekly.biweekely19;

public class NumberOfStepsToReduceZero {

    //https://leetcode.com/contest/biweekly-contest-19/problems/number-of-steps-to-reduce-a-number-to-zero/
    public static void main( String[] args ) {
        int n = 123;
        System.out.println(numberOfSteps(n));
    }

    private static int numberOfSteps( int num ) {
        if (num == 0)
            return 0;

        if (num == 1)
            return 1;

        if (num == 2)
            return 2;

        int count = 0;
        while (num > 0) {
            if (num % 2 == 0)
                num = num / 2;
            else
                num -= 1;

            count++;
        }

        return count;
    }

    //If num is even or 1, we use only 1 step to reduce: -
    //otherwise, 2 steps:  divide

    private static int numberOfStepsMoreOptimized( int num ) {
        int cnt = 0;

        while (num > 0) {
            cnt += num % 2 == 0 || num == 1 ? 1 : 2;
            num /= 2;
        }

        return cnt;
    }
}
