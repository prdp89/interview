package com.interview.javabasics.ThreadConcurrency;

public class ThreadJoining {

    private int a = 20;
    private int b = 30;
    private int multiply;
    private int add;

    //https://www.geeksforgeeks.org/joining-threads-in-java/
    //https://i.ibb.co/f2TjBs7/With-Join.png
    public static void main( String[] args ) {
        ThreadJoining threadJoining = new ThreadJoining();
        threadJoining.realLifeJoin();
    }

    private void realLifeJoin() {

        long startTime = System.nanoTime();

        Thread thread_work_1 = new Thread(() -> {

            System.out.println("Thread start: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
            System.out.println("Thread ended: " + Thread.currentThread().getName());
            multiply = a * b;
        });

        thread_work_1.start();

        Thread thread_work_2 = new Thread(() -> {

            System.out.println("Thread start: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
            System.out.println("Thread ended: " + Thread.currentThread().getName());
            add = a + b;
        });

        thread_work_2.start();


        try {
            thread_work_1.join();
            thread_work_2.join();
        } catch (Exception ignored) {
        }

        System.out.println("Addition: " + add + ", Multiplication: " + multiply);

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time Taken: " + totalTime);
    }
}
