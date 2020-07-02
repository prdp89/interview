package com.interview.javabasics.ThreadConcurrency.multithreadingcourse;

public class ImplementingBarrier {

    public static void main( String[] args ) throws InterruptedException {
        Barrier.runTest();
    }

    static class Barrier {

        int count = 0;
        int released = 0;
        int totalThreads;

        Barrier( int totalThreads ) {
            this.totalThreads = totalThreads;
        }

        static void runTest() throws InterruptedException {
            final Barrier barrier = new Barrier(3);

            Thread p1 = new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println("Thread 1");
                        barrier.await();
                        System.out.println("Thread 1");
                        barrier.await();
                        System.out.println("Thread 1");
                        barrier.await();
                    } catch (InterruptedException ie) {
                    }
                }
            });

            Thread p2 = new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(500);
                        System.out.println("Thread 2");
                        barrier.await();
                        Thread.sleep(500);
                        System.out.println("Thread 2");
                        barrier.await();
                        Thread.sleep(500);
                        System.out.println("Thread 2");
                        barrier.await();
                    } catch (InterruptedException ie) {
                    }
                }
            });

            Thread p3 = new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1500);
                        System.out.println("Thread 3");
                        barrier.await();
                        Thread.sleep(1500);
                        System.out.println("Thread 3");
                        barrier.await();
                        Thread.sleep(1500);
                        System.out.println("Thread 3");
                        barrier.await();
                    } catch (InterruptedException ie) {
                    }
                }
            });

            p1.start();
            p2.start();
            p3.start();

            p1.join();
            p2.join();
            p3.join();
        }

        synchronized void await() throws InterruptedException {

            // block any new threads from proceeding till,
            // all threads from previous barrier are released
            while (count == totalThreads)
                wait();

            // increment the counter whenever a thread arrives at the
            // barrier.
            count++;

            if (count == totalThreads) {
                // wake up all the threds.
                notifyAll();

                // remember to set released to totalThreads
                released = totalThreads;
            } else {
                // wait till all threads reach barrier
                while (count < totalThreads)
                    wait();
            }

            released--;
            if (released == 0) {
                count = 0;
                // remember to wakeup any threads
                // waiting on line#81
                notifyAll();
            }
        }
    }
}