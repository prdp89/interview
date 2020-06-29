package com.interview.javabasics.ThreadConcurrency.multithreadingcourse;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeDefferedCallback {

    /*
    Design and implement a thread-safe class that allows registeration of callback methods
    that are executed after a user specified time interval in seconds has elapsed.

    Here's another test-case, which first submits a callback that should get executed after eight seconds. Three seconds later another call back is submitted which should be executed after only one second. The callback being submitted later should execute first. The test run would timeout if run in the browser since the callback service is a perpetual thread but from the output you can observe the callback submitted second execute first.
     */
    public static void main( String[] args ) throws InterruptedException {
        DeferredCallbackExecutor.runLateThenEarlyCallback();
    }

    static class DeferredCallbackExecutor {

        private static Random random = new Random(System.currentTimeMillis());

        PriorityQueue<CallBack> q = new PriorityQueue<CallBack>(( o1, o2 ) -> (int) (o1.executeAt - o2.executeAt));

        ReentrantLock lock = new ReentrantLock();
        Condition newCallbackArrived = lock.newCondition();

        static void runLateThenEarlyCallback() throws InterruptedException {
            final DeferredCallbackExecutor deferredCallbackExecutor = new DeferredCallbackExecutor();

            Thread service = new Thread(new Runnable() {
                public void run() {
                    try {
                        deferredCallbackExecutor.start();
                    } catch (InterruptedException ie) {
                    }
                }
            });

            service.start();

            Thread lateThread = new Thread(new Runnable() {
                public void run() {
                    CallBack cb = new CallBack(8, "Hello this is the callback submitted first");
                    deferredCallbackExecutor.registerCallback(cb);
                }
            });
            lateThread.start();

            Thread.sleep(3000);

            Thread earlyThread = new Thread(() -> {
                CallBack cb = new CallBack(1, "Hello this is callback sumbitted second");
                deferredCallbackExecutor.registerCallback(cb);
            });
            earlyThread.start();

            lateThread.join();
            earlyThread.join();
        }

        private long findSleepDuration() {
            long currentTime = System.currentTimeMillis();
            return q.peek().executeAt - currentTime;
        }

        public void start() throws InterruptedException {
            long sleepFor = 0;

            while (true) {

                lock.lock();

                while (q.size() == 0) {
                    newCallbackArrived.await();
                }

                while (q.size() != 0) {
                    sleepFor = findSleepDuration();

                    if (sleepFor <= 0)
                        break;

                    newCallbackArrived.await(sleepFor, TimeUnit.MILLISECONDS);
                }

                CallBack cb = q.poll();
                System.out.println(
                        "Executed at " + System.currentTimeMillis() / 1000 + " required at " + cb.executeAt / 1000
                                + ": message:" + cb.message);

                lock.unlock();
            }
        }

        void registerCallback( CallBack callBack ) {
            lock.lock();
            q.add(callBack);
            newCallbackArrived.signal();
            lock.unlock();
        }

        static class CallBack {
            long executeAt;
            String message;

            CallBack( long executeAfter, String message ) {
                this.executeAt = System.currentTimeMillis() + executeAfter * 1000;
                this.message = message;
            }
        }
    }
}
