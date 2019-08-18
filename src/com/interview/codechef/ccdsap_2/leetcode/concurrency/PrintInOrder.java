package com.interview.codechef.ccdsap_2.leetcode.concurrency;

import java.util.concurrent.Semaphore;

public class PrintInOrder {

    //https://leetcode.com/problems/print-in-order/
    private Semaphore two;
    private Semaphore three;

    private PrintInOrder() {
        two = new Semaphore(0); //initially zero marbles in a bowl
        three = new Semaphore(0);
    }

    //ref : https://leetcode.com/problems/print-in-order/discuss/332890/Java-Basic-semaphore-solution-8ms-36MB
    public static void main( String[] args ) throws InterruptedException {
        PrintInOrder printInOrder = new PrintInOrder();

        printInOrder.second(() -> System.out.println("second"));
        printInOrder.first(() -> System.out.println("first"));
        printInOrder.third(() -> System.out.println("third"));
    }

    private void first( Runnable printFirst ) throws InterruptedException {
        printFirst.run();
        two.release();
    }

    private void second( Runnable printSecond ) throws InterruptedException {
        two.acquire();
        printSecond.run();
        three.release();
    }

    private void third( Runnable printThird ) throws InterruptedException {
        three.acquire();
        printThird.run();
    }
}
