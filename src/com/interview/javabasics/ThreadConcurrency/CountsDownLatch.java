package com.interview.javabasics.ThreadConcurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountsDownLatch {

    //https://www.geeksforgeeks.org/countdownlatch-in-java/

    //Dev/QA example is also good by user-V jo:
    // https://stackoverflow.com/questions/17827022/how-is-countdownlatch-used-in-java-multithreading
    public static void main( String[] args ) throws InterruptedException {
        // Let us create task that is going to
        // wait for four threads before it starts
        CountDownLatch latch = new CountDownLatch(4);

        // Let us create four worker
        // threads and start them.
        Worker first = new Worker(1000, latch,
                "WORKER-1");
        Worker second = new Worker(2000, latch,
                "WORKER-2");
        Worker third = new Worker(1000, latch,
                "WORKER-3");
        Worker fourth = new Worker(2000, latch,
                "WORKER-4");

        first.start();
        second.start();
        third.start();
        fourth.start();

        // The main task waits for four threads
        latch.await(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        // Main thread has started
        System.out.println(Thread.currentThread().getName() +
                " has finished");
    }

    static class Worker extends Thread {
        private int delay;
        private CountDownLatch latch;

        Worker( int delay, CountDownLatch latch,
                String name ) {
            super(name);
            this.delay = delay;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
                System.out.println(Thread.currentThread().getName()
                        + " finished");

                latch.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
