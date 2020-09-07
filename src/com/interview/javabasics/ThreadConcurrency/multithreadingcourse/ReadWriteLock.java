package com.interview.javabasics.ThreadConcurrency.multithreadingcourse;

public class ReadWriteLock {

    /*
    Imagine you have an application where you have multiple readers and multiple writers.
    You are asked to design a lock which lets multiple readers read at the same time,
    but only one writer write at a time.
     */
    public static void main( String[] args ) throws InterruptedException {
        final ReadWriteLockImpl rwl = new ReadWriteLockImpl();

        Thread t1 = new Thread(() -> {
            try {

                System.out.println("Attempting to acquire write lock in t1: " + System.currentTimeMillis());
                rwl.acquireWriteLock();
                System.out.println("write lock acquired t1: " + +System.currentTimeMillis());

                // Simulates write lock being held indefinitely
                for (; ; ) {
                    Thread.sleep(500);
                }

            } catch (InterruptedException ie) {

            }
        });

        //This Writer will not able to acquire LOCK, bcz only 1 writer is allowed.
        Thread t2 = new Thread(() -> {
            try {

                System.out.println("Attempting to acquire write lock in t2: " + System.currentTimeMillis());
                rwl.acquireWriteLock();
                System.out.println("write lock acquired t2: " + System.currentTimeMillis());

            } catch (InterruptedException ie) {

            }
        });

        Thread tReader1 = new Thread(() -> {
            try {

                rwl.acquireReadLock();
                System.out.println("Read lock acquired: " + System.currentTimeMillis());

            } catch (InterruptedException ie) {

            }
        });

        Thread tReader2 = new Thread(() -> {
            System.out.println("Read lock about to release: " + System.currentTimeMillis());
            rwl.releaseReadLock();
            System.out.println("Read lock released: " + System.currentTimeMillis());
        });

        tReader1.start();
        t1.start();
        Thread.sleep(3000);
        tReader2.start();
        Thread.sleep(1000);
       // t2.start();
        tReader1.join();
        tReader2.join();
        //t2.join();
    }

    static class ReadWriteLockImpl {

        boolean isWriteLocked = false;
        int readers = 0;

        synchronized void acquireReadLock() throws InterruptedException {

            while (isWriteLocked) {
                wait();
            }

            readers++;
        }

        synchronized void releaseReadLock() {
            readers--;
            notify();
        }

        synchronized void acquireWriteLock() throws InterruptedException {

            while (isWriteLocked || readers != 0) {
                wait();
            }

            isWriteLocked = true;
        }

        public synchronized void releaseWriteLock() {
            isWriteLocked = false;
            notify();
        }
    }
}
