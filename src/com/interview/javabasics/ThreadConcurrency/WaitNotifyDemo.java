package com.interview.javabasics.ThreadConcurrency;

public class WaitNotifyDemo {

    //https://www.logicbig.com/tutorials/core-java-tutorial/java-multi-threading/thread-wait-notify.html
    public static void main( String[] args ) {
        SharedObject obj = new SharedObject();

        Thread thread1 = new Thread(() -> obj.printMessage());

        Thread thread2 = new Thread(() -> obj.setMessage("A message from thread1"));

        thread1.start();
        thread2.start();
    }

    private static class SharedObject {
        private String message;

        synchronized void setMessage( String message ) {
            this.message = message;
            notify();
        }

        synchronized void printMessage() {
            while (message == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(message);

        }
    }
}
