package com.interview.javabasics.ThreadConcurrency.multithreadingcourse;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CyclicBarrierImpl {

    /*
    CyclicBarrier is a synchronization mechanism introduced in JDK 5 in the java.util.concurrent package.
    It allows multiple threads to wait for each other at a common point (barrier) before continuing execution.

    The threads wait for each other by calling the await() method on the CyclicBarrierImpl.
    All threads that wait for each other to reach barrier are called parties.
     */
    public static void main( String[] args ) {
        //Creating CyclicBarrierImpl with 3 parties i.e. 3 Threads needs to call await()
        final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {

            //Action that executes after the last thread arrives
            @Override
            public void run() {
                System.out.println("All parties have arrived at the barrier, lets continue execution.");
            }
        });

        //starting each thread
        Thread t1 = new Thread(new Task(cb), "Thread 1");
        Thread t2 = new Thread(new Task(cb), "Thread 2");
        Thread t3 = new Thread(new Task(cb), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }

    static class Task implements Runnable {

        private CyclicBarrier barrier;

        Task( CyclicBarrier barrier ) {
            this.barrier = barrier;
        }

        //Await is invoked to wait for other threads
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
                barrier.await();
                //printing after crossing the barrier
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            } catch (InterruptedException ex) {
                Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
