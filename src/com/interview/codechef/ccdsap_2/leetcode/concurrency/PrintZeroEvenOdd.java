package com.interview.codechef.ccdsap_2.leetcode.concurrency;

import java.util.concurrent.Semaphore;

public class PrintZeroEvenOdd {

    //https://leetcode.com/problems/print-zero-even-odd/

    private Semaphore semaphoreEven, semaphoreOdd, semaphoreZero;
    private int n;

    public PrintZeroEvenOdd( int n ) {
        this.n = n;

        semaphoreZero = new Semaphore(1);
        semaphoreEven = new Semaphore(0);
        semaphoreOdd = new Semaphore(0);
    }

    //ref: https://leetcode.com/problems/print-zero-even-odd/discuss/332943/Java-Basic-semaphore-solution-4ms-35.8MB-Updated
    public static void main( String[] args ) {

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero( IntConsumer printNumber ) throws InterruptedException {
        int numTimes = this.n;
        boolean printOdd = true;

        for (int i = 0; i < numTimes; i++) {
            semaphoreZero.acquire();

            printNumber.accept(0);

            //print the next number
            if (printOdd)
                semaphoreOdd.release();
            else
                semaphoreEven.release();

            printOdd = !printOdd;   //flip it!
        }
    }

    public void even( IntConsumer printNumber ) throws InterruptedException {
        int numTimes = this.n / 2;

        int nextEvenNum = 2;
        for (int i = 0; i < numTimes; i++) {
            semaphoreEven.acquire();

            printNumber.accept(nextEvenNum);
            nextEvenNum += 2;

            semaphoreZero.release();
        }
    }

    public void odd( IntConsumer printNumber ) throws InterruptedException {
        int numTimes = (int) Math.ceil((double) this.n / 2);

        int nextOdd = 1;
        for (int i = 0; i < numTimes; i++) {
            semaphoreOdd.acquire();

            printNumber.accept(nextOdd);
            nextOdd += 2;

            semaphoreZero.release();
        }
    }

    interface IntConsumer {
        void accept( int x );
    }
}
