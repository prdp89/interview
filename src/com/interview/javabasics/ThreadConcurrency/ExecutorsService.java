package com.interview.javabasics.ThreadConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ExecutorsService {

    //https://stackoverflow.com/questions/1250643/how-to-wait-for-all-threads-to-finish-using-executorservice
    public static void main( String[] args ) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Runnable task = () -> System.out.println(Thread.currentThread().getName() + ": 1");
        Runnable task_1 = () -> System.out.println(Thread.currentThread().getName() + ": 2");
        Runnable task_2 = () -> System.out.println(Thread.currentThread().getName() + ": 3");

        //to execute single task
        //pool.execute(task);

        pool.submit(task);
        pool.submit(task_1);
        pool.submit(task_2);

        pool.shutdown();

        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException ignored) {
        }

        System.out.println("Finished");

        pool.shutdownNow();
    }
}
