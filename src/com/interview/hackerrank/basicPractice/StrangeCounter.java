package com.interview.hackerrank.basicPractice;

public class StrangeCounter {

    //https://www.hackerrank.com/challenges/strange-code/problem
    public static void main( String[] args ) {
        solvE();
    }

    private static void solvE() {
        long t = 4;

        long startTime = 1, startValue = 3;

        while (startTime <= t) {

            //startTime = (prevValue * 2) - startTime + startValue;

            startTime = (startValue * 2) - startValue + startTime;

            startValue *= 2;
        }

        System.out.println(startTime - t);

        //System.out.println((t-1) * 2);
    }
}
