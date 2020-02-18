package com.interview.javabasics.ThreadConcurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleThreadCompletableFuture {

    public static void main( String[] args ) {
        MultipleThreadCompletableFuture test = new MultipleThreadCompletableFuture();
        test.procesar();
    }

    private void procesar() {
        ExecutorService es = Executors.newFixedThreadPool(4);
        List<Runnable> tasks = getTasks();
        CompletableFuture<?>[] futures = tasks.stream()
                .map(task -> CompletableFuture.runAsync(task, es))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futures).join();
        es.shutdown();

        System.out.println("FIN DEL PROCESO DE HILOS");
    }

    private List<Runnable> getTasks() {
        List<Runnable> tasks = new ArrayList<Runnable>();

        Hilo01 task1 = new Hilo01();
        tasks.add(task1);

        Hilo02 task2 = new Hilo02();
        tasks.add(task2);
        return tasks;
    }

    private class Hilo01 extends Thread {

        @Override
        public void run() {
            System.out.println("HILO 1");
        }

    }

    private class Hilo02 extends Thread {

        @Override
        public void run() {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("HILO 2");
        }

    }
}
