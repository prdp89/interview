package com.interview.javabasics.ThreadConcurrency.multithreadingcourse;

public class BlockingQueueSemaphore {

    public static void main( String[] args ) throws InterruptedException {
        final BlockingQueueWithSemaphore<Integer> q = new BlockingQueueWithSemaphore<>(5);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    q.enqueue(i);
                    System.out.println("enqueued " + i);
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 2 dequeued: " + q.dequeue());
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 3 dequeued: " + q.dequeue());
                }
            } catch (InterruptedException ie) {

            }
        });

        t1.start();
        Thread.sleep(4000);
        t2.start();
        t2.join();

        t3.start();
        t1.join();
        t3.join();
    }

    static class BlockingQueueWithSemaphore<T> {
        T[] array;
        int size = 0;
        int capacity;
        int head = 0;
        int tail = 0;
        CountingSemaphore semLock = new CountingSemaphore(1, 1);
        CountingSemaphore semProducer;
        CountingSemaphore semConsumer;

        @SuppressWarnings("unchecked")
        BlockingQueueWithSemaphore( int capacity ) {
            // The casting results in a warning
            array = (T[]) new Object[capacity];
            this.capacity = capacity;
            this.semProducer = new CountingSemaphore(capacity, capacity);
            this.semConsumer = new CountingSemaphore(capacity, 0);
        }

        T dequeue() throws InterruptedException {

            T item = null;

            semConsumer.acquire();
            semLock.acquire();

            if (head == capacity) {
                head = 0;
            }

            item = array[head];
            array[head] = null;
            head++;
            size--;

            semLock.release();
            semProducer.release();

            return item;
        }

        void enqueue( T item ) throws InterruptedException {

            semProducer.acquire();
            semLock.acquire();

            if (tail == capacity) {
                tail = 0;
            }

            array[tail] = item;
            size++;
            tail++;

            semLock.release();
            semConsumer.release();
        }
    }

    static class CountingSemaphore {

        int usedPermits = 0;
        int maxCount;

        public CountingSemaphore( int count ) {
            this.maxCount = count;
        }

        CountingSemaphore( int count, int initialPermits ) {
            this.maxCount = count;
            this.usedPermits = this.maxCount - initialPermits;
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
