package com.interview.javabasics.ThreadConcurrency;

import java.util.concurrent.*;

//https://www.codejava.net/java-core/concurrency/java-concurrency-understanding-thread-pool-and-executors
public class CallableFutureService {

    // A Callable task returns a value upon completion and we use the Future object to obtain the value.
    // Here’s the code:
    public static void main( String[] args ) {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            try {
                // fake computation time
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            return 1000;
        };

        Future<Integer> result = pool.submit(task);

        try {

            Integer returnValue = result.get();
            System.out.println("Return value = " + returnValue);

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }

        pool.shutdown();
    }
}
