package com.interview.javabasics.ThreadConcurrency.multithreadingcourse;

public class CustomBlockingQueue {

    public static void main( String args[] ) throws Exception {
        final BlockingQueue<Integer> q = new BlockingQueue<>(5);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    q.enqueue(i);
                    System.out.println("enqueued " + i);
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 25; i++) {
                    System.out.println("Thread 2 dequeued: " + q.dequeue());
                }
            } catch (InterruptedException ie) {

            }
        });

        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < 25; i++) {
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
}

// The blocking queue class
class BlockingQueue<T> {

    private final Object lock = new Object();
    private T[] array;
    private int size = 0;
    private int capacity;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("unchecked")
    BlockingQueue( int capacity ) {
        // The casting results in a warning
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    void enqueue( T item ) throws InterruptedException {

        synchronized (lock) {

            while (size == capacity) {
                lock.wait();
            }

            if (tail == capacity) {
                tail = 0;
            }

            array[tail] = item;
            size++;
            tail++;
            lock.notifyAll();
        }
    }

    T dequeue() throws InterruptedException {

        T item = null;
        synchronized (lock) {

            while (size == 0) {
                lock.wait();
            }

            if (head == capacity) {
                head = 0;
            }

            item = array[head];
            array[head] = null;
            head++;
            size--;

            lock.notifyAll();
        }

        return item;
    }
}
