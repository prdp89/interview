package com.interview.javabasics.ThreadConcurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlockingsQueue {

    //https://www.geeksforgeeks.org/blockingqueue-interface-in-java/

    //code: https://www.javatpoint.com/java-multithreading-interview-questions

    //Producing and consuming runs in parallel
    public static void main( String[] args ) throws InterruptedException {
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        //Creating Producer and Consumer Thread
        Thread prod = new Thread(new Producer(sharedQueue));
        Thread cons = new Thread(new Consumer(sharedQueue));

        //Starting producer and Consumer thread
        prod.start();
        cons.start();

        //prod.join();
        //cons.join();

        System.out.println("finished");
    }

    //Producer Class in java
    static class Producer implements Runnable {

        private final BlockingQueue sharedQueue;

        Producer( BlockingQueue sharedQueue ) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Produced: " + i);
                    sharedQueue.put(i);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    //Consumer Class in Java
    static class Consumer implements Runnable {

        private final BlockingQueue sharedQueue;

        Consumer( BlockingQueue sharedQueue ) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Consumed: " + sharedQueue.take());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
