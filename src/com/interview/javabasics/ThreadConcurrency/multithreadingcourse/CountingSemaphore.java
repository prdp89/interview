package com.interview.javabasics.ThreadConcurrency.multithreadingcourse;

public class CountingSemaphore {

    public static void main( String[] args ) throws InterruptedException {
        //Allow one thread to run at a time..
        final CountingSemaphoreImpl cs = new CountingSemaphoreImpl(1);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    cs.acquire();
                    System.out.println("Ping " + i);
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    cs.release();
                    System.out.println("Pong " + i);
                } catch (InterruptedException ie) {

                }
            }
        });

        t2.start();
        t1.start();
        t1.join();
        t2.join();
    }

    static class CountingSemaphoreImpl {

        int usedPermits = 0;
        int maxCount;

        CountingSemaphoreImpl( int count ) {
            this.maxCount = count;

        }

        synchronized void acquire() throws InterruptedException {

            while (usedPermits == maxCount)
                wait();

            notify();
            usedPermits++;
        }

        synchronized void release() throws InterruptedException {

            while (usedPermits == 0)
                wait();

            usedPermits--;
            notify();
        }
    }
}
