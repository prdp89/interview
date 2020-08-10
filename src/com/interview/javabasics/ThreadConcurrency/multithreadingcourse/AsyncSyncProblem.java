package com.interview.javabasics.ThreadConcurrency.multithreadingcourse;

public class AsyncSyncProblem {

    public static void main( String[] args ) throws Exception {
        SynchronousExecutor executor = new SynchronousExecutor();
        executor.asynchronousExecution(() -> {
            System.out.println("I am done");
        });

        System.out.println("main thread exiting...");
    }

    interface Callback {
        void done();
    }

    static class SynchronousExecutor extends Executor {

        @Override
        public void asynchronousExecution( Callback callback ) throws Exception {

            Object signal = new Object();
            final boolean[] isDone = new boolean[1];

            Callback cb = new Callback() {

                @Override
                public void done() {
                    callback.done();
                    synchronized (signal) {
                        signal.notify();
                        isDone[0] = true;
                    }
                }
            };

            // Call the asynchronous executor
            super.asynchronousExecution(cb);

            synchronized (signal) {
                while (!isDone[0]) {
                    signal.wait();
                }
            }

        }
    }

    static class Executor {

        public void asynchronousExecution( Callback callback ) throws Exception {

            Thread t = new Thread(() -> {
                // Do some useful work
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ie) {
                }

                System.out.println("Nested asynchronousExecution..");
                callback.done();
            });
            t.start();
        }
    }
}
